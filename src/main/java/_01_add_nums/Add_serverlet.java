package _01_add_nums;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
//befor this go to webApp/web-inf/web.xml, add servlet details ie class details there and then come here
public class Add_serverlet extends HttpServlet{
	
	
	// get method, would return good res only if form action is set as 'get' at front end, WOULD append params passed into form into the url
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		res
		.getWriter()
		.append("Sum is ")
		.println(
				Integer.parseInt(req.getParameter("num1"))+
				Integer.parseInt(req.getParameter("num2"))
		);
	}
	
	
	// post method, would return good res only if form action is set as 'post' at front end, this WOULDNT append params of form when submitted into the url
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			// TODO Auto-generated method stub
			res
			.getWriter()
			.append("Sum is ")
			.println(
					Integer.parseInt(req.getParameter("num1"))+
					Integer.parseInt(req.getParameter("num2"))
			);
		}
		
	
	//using this method in place of doGet and doPost, client or in fronted we don t have to worry about whether to call using http.post or http.get, ie no restriction , but genrally not recommened
//	@Override
//	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//		res
//		.getWriter()
//		.append("Sum is ")
//		.println(
//				Integer.parseInt(req.getParameter("num1"))+
//				Integer.parseInt(req.getParameter("num2"))
//		);
//	}
	
	
	//suppose u want to print sum, thats ok, but in say via some other server (say here "xyz") such that the method of this(original) server is called(though even xyz needs to be mentioned in web.xml, then basically u need to transfer or dispatch the functionality to that , syntax:
	/*
	 
	 protected void someHttpMeth(req,res){
	 	int sum=num1+num2;
	 	req.setAttribute("sum":sum);//no u have appended sum to request
	 	RequestDispatcher rd=req.getRequestDispathcer("xyz");//make sure u declre xyz in web.xml
	 	rd.forward(req,res);
	 	//now u can access sum from other server using its (int)req.getAttribute("sum"), now notie the differnece between get paramater and getAttribute, see that we use get parameter when working post within same server, but use getAtrribute when u r passing req from one server to other server
	 } 
	 
	 */
		
		
		
		/*
		 	When to use ReqDispatcher: when u want to do some computation x on other server using values of original server, the url still remains same ie originalServer/add,
		 	
		 	But now what if u want to redirect there itself ie url  shoould become xyz/add, solution is the knowledge that whatsover and howmany ever servers we r maintaining alll will have same session object, so just make changes to it
		 	
		 	example:
		 	
		 	original server side code:
		 	
		 	int sum=num1+num2;
		 	HttpSession session=req.getSession();
		 	session.setAttribute("sum",sum);
		 	//redirect to server xyz with this state of session
		 	res.sendRedirect("xyz")
		 	
		 	
		 	xyz server side code:
		 	HttpSession session = req.getSession();
		 	int sum=(int)session.getAttribute("sum")//acccess sum here
		 	
		 	
		 	
		 	//allso u can even send cookies between servers
		 	original sevrer side
		 	
		 	Cookie c=new Cookie("sum",sum+"");
		 	res.sendCookie(c)
		 	
		 	on xyz side
		 	res.getCookies().stream().filter(e.getName()="sum")
		 	
		 	
		  */
	
}
