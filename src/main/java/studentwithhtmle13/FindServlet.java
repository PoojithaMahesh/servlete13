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
@WebServlet("/find")
public class FindServlet extends HttpServlet{
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	int id=Integer.parseInt(req.getParameter("id"));
	
	StudentDao dao=new StudentDao();
	Student student=dao.findStudentById(id);
	if(student!=null) {
//		student is present
		PrintWriter printWriter=resp.getWriter();
		printWriter.print(student);
	}else {
//		student is not present
		PrintWriter printWriter=resp.getWriter();
		printWriter.print("Sorry id is not present");
	}
}
}
