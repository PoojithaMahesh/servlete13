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
@WebServlet("/delete")
public class DeleteServlet extends HttpServlet{
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	int id=Integer.parseInt(req.getParameter("id"));
	StudentDao dao=new StudentDao();
	Student student =dao.deleteStudentById(id);
	PrintWriter printWriter=resp.getWriter(); 
	if(student!=null) {
//		student id is present and data deleted successfully
		printWriter.print("DATA DELETED SUCCESSFULLY");
	}else {
//		student id is not present 
		printWriter.print("SORRY ID IS NOT PRESENT");
	}
	
}
}
