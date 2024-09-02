package studentwithhtmle13;

import java.io.IOException;
import java.util.List;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import studentwithhtmle13.dao.StudentDao;
import studentwithhtmle13.dto.Student;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email=req.getParameter("studentemail");
		String password=req.getParameter("studentpassword");
		
		StudentDao dao=new StudentDao();
		List<Student> list=dao.getAllStudents();
		boolean value=false;
		
		for(Student student:list) {
			if(email.equals(student.getEmail())) {
//				that student is present 
				value=true;
				break;
				
			}
		}
		
		
		
	}

}
