package studentwithhtmle13;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import studentwithhtmle13.dao.StudentDao;
import studentwithhtmle13.dto.Student;

@WebServlet("/update")
public class UpdateServlet extends HttpServlet{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
	
	int id=Integer.parseInt(req.getParameter("id"));
	
	StudentDao dao=new StudentDao();
	Student dbStudent=dao.updateStudent(id,student);
	PrintWriter printWriter=resp.getWriter();
	if(dbStudent!=null) {
//		student is present data updated successfully
		printWriter.print("UPDATED SUCCESSFULLY");
	}else {
//		student is not present data not updated
		printWriter.print("SORRY ID IS NOT PRESENT");
	}
	
	
	
	
	
}
}
