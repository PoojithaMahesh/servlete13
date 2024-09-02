package studentwithhtmle13;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

import studentwithhtmle13.dao.StudentDao;
import studentwithhtmle13.dto.Student;
@WebServlet("/signup")
public class SignupServlet extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		String address=req.getParameter("address");
		String phone =req.getParameter("phone");
		long phoneNumber=Long.parseLong(phone);
		
		Student student=new Student();
		student.setAddress(address);
		student.setEmail(email);
		student.setName(name);
		student.setPassword(password);
		
		
		StudentDao dao=new StudentDao();
		dao.saveStudent(student);
		PrintWriter printWriter=res.getWriter();
		printWriter.print("SignedUp successfully Thank Youuuuu!!!!!!!!!!");
		
		
		
		
		
		
				
	}

}
