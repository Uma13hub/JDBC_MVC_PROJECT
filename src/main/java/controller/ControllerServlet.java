package controller;

import java.io.IOException;
import java.io.PrintWriter;

import dto.Student;
import factory.StudentServiceFactory;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletSecurityElement;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.IStudentService;

@WebServlet("/controller/*")
public class ControllerServlet extends jakarta.servlet.http.HttpServlet {
	private static final long serialVersionUID = 1L;
    public ControllerServlet() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String requestURI=request.getRequestURI();
		System.out.println(requestURI);
		IStudentService studentService=StudentServiceFactory.getStudentService();;
		Student student=null;
		RequestDispatcher rd=null;
		if(requestURI.endsWith("layout")) {
			rd=request.getRequestDispatcher("../layout.html");
			rd.forward(request, response);
		}
		if(requestURI.endsWith("addForm")) {
			Integer sid=Integer.parseInt(request.getParameter("sid"));
			String sname=request.getParameter("sname");
			Integer sage=Integer.parseInt(request.getParameter("sage"));
			String saddress=request.getParameter("saddress");
			student=new Student();
			student.setSid(sid);
			student.setSname(sname);
			student.setSage(sage);
			student.setSaddress(saddress);
			String status=studentService.save(student);
			if(status.equalsIgnoreCase("success")) {
				rd=request.getRequestDispatcher("../success.jsp");
				ServletContext context=getServletContext();
				context.setAttribute("insert", "success");
				rd.forward(request, response);}
			else if(status.equalsIgnoreCase("failure")) {
				rd=request.getRequestDispatcher("../success.jsp");
				ServletContext context=getServletContext();
				context.setAttribute("insert", "failure");
				rd.forward(request, response);
			}
		}
		if(requestURI.endsWith("searchForm")) {
			Integer sid=Integer.parseInt(request.getParameter("sid"));
			student=studentService.findById(sid);
			if(student != null){
				
				response.setContentType("text/html");
				PrintWriter out = response.getWriter();
				out.println("<html><head><title>STUDENT DATA</title></head>");
				out.println("<body bgcolor='lightblue'>");
				out.println("<br/><br/><br/>");
				out.println("<table align='center' border='1'>");
				out.println("<tr>");
				out.println("<th>SID</th>");
				out.println("<th>SNAME</th>");
				out.println("<th>SAGE</th>");
				out.println("<th>SADDRESS</th>");
				out.println("</tr>");

				out.println("<tr>");
				out.println("<td>" + student.getSid() + "</td>");
				out.println("<td>" + student.getSname() + "</td>");
				out.println("<td>" + student.getSage() + "</td>");
				out.println("<td>" + student.getSaddress() + "</td>");
				out.println("</tr>");

				out.println("</table>");
				out.println("</body>");
				out.println("</html>");

				out.close();

			} 
			else {
				rd = request.getRequestDispatcher("../notfound.html");
				rd.forward(request, response);
			}
			
		}
		
		if(requestURI.endsWith("deleteForm")) {
			Integer sid=Integer.parseInt(request.getParameter("sid"));
			student=studentService.findById(sid);
			if(student != null){
				response.setContentType("text/html");
				PrintWriter out = response.getWriter();
				out.println("<html><head><title>STUDENT DATA</title></head>");
				out.println("<body bgcolor='lightblue'>");
				out.println("<br/><br/><br/>");
				out.println("<table align='center' border='1'>");
				out.println("<tr>");
				out.println("<th>SID</th>");
				out.println("<th>SNAME</th>");
				out.println("<th>SAGE</th>");
				out.println("<th>SADDRESS</th>");
				out.println("</tr>");

				out.println("<tr>");
				out.println("<td>" + student.getSid() + "</td>");
				out.println("<td>" + student.getSname() + "</td>");
				out.println("<td>" + student.getSage() + "</td>");
				out.println("<td>" + student.getSaddress() + "</td>");
				out.println("</tr>");

				out.println("</table>");
				out.println("</body>");
				out.println("</html>");

				out.close();
				String status=studentService.deleteById(sid);
				if(status.equalsIgnoreCase("success")) {
					rd=request.getRequestDispatcher("../success.jsp");
					rd.forward(request, response);}
				else if(status.equalsIgnoreCase("failure")) {
					rd=request.getRequestDispatcher("../success.jsp");
					rd.forward(request, response);
				}
			} 
			else {
				rd = request.getRequestDispatcher("../notfound.html");
				rd.forward(request, response);
			}
			
		}
		
		if (requestURI.endsWith("deleteform")) {
			String sid = request.getParameter("sid");
			String status = studentService.deleteById(Integer.parseInt(sid));

			if (status.equals("success")) {
				rd = request.getRequestDispatcher("../success.jsp");
				rd.forward(request, response);
			} else if (status.equals("failure")) {
				rd = request.getRequestDispatcher("../success.jsp");
				rd.forward(request, response);
			} else {
				rd = request.getRequestDispatcher("../notfound.html");
				rd.forward(request, response);
			}
		}
		if (requestURI.endsWith("editForm")) {
			String sid = request.getParameter("sid");
			student = studentService.findById(Integer.parseInt(sid));
			if (student != null) {
				response.setContentType("text/html");
				PrintWriter out = response.getWriter();
				out.println("<html><head><title>OUTPUT</title></head>");
				out.println("<body bgcolor='lightblue'>");
				out.println("<br/><br/><br/>");
				out.println("<form method='post' action='./update'>");
				out.println("<table align='center'>");
				out.println("<tr><th>ID</th><td>" + student.getSid() + "</td></tr>");
				out.println("<input type='hidden' name='sid' value='" + student.getSid() + "'/>");
				out.println("<tr><th>NAME</th><td><input type='text' name='sname' value='" + student.getSname()
						+ "'/></td></tr>");
				out.println("<tr><th>AGE</th><td><input type='text' name='sage' value='" + student.getSage()
						+ "'/></td></tr>");
				out.println("<tr><th>ADDRESS</th><td><input type='text' name='saddress' value='" + student.getSaddress()
						+ "'/></td></tr>");
				out.println("<tr><td></td><td><input type='submit' value='update'/></td></tr>");
				out.println("</table>");
				out.println("</form>");
				out.println("</body>");
				out.println("</html>");
				out.close();

			} else {
				rd = request.getRequestDispatcher("../notfound.html");
				rd.forward(request, response);
			}
		}

		if(requestURI.endsWith("update")) {

			String sid = request.getParameter("sid");
			String sname = request.getParameter("sname");
			String sage = request.getParameter("sage");
			String saddress = request.getParameter("saddress");

			student = new Student();
			student.setSid(Integer.parseInt(sid));
			student.setSname(sname);
			student.setSage(Integer.parseInt(sage));
			student.setSaddress(saddress);
			
			String status = studentService.updateById(student);
			if (status.equals("success")) {
				rd = request.getRequestDispatcher("../success.jsp");
				rd.forward(request, response);
			} else if (status.equals("failure")) {
				rd = request.getRequestDispatcher("../success.jsp");
				rd.forward(request, response);
			} 
		}
	}
}