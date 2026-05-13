package class3;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Servlet implementation class task6
 */
@WebServlet("/task6")
public class task6 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public task6() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
HttpSession z=request.getSession(true);
		
		Date createtime=new Date(z.getCreationTime());
		Date accesstime=new Date(z.getLastAccessedTime());
		
		String title="Hello welcome back";
		String uid=new String("anup");
		if(z.isNew()) {
			title="Hello welcome";
			z.setAttribute(title, uid);
			
		}
		z.setAttribute(title,uid);
		
		response .setContentType("text/html");
		PrintWriter out=response.getWriter();
		String docType="<!doctype html public";
		out.println(docType+
				"<html>\n"+
				"<body>\n"+
				"<ul>\n"+
				"<li><b>sessionId:</b>"+createtime+"\n"+
				"<li><b>Access ID:</b>"+accesstime+"\n"+
				"<li><b>User ID:</b>"+uid+"\n"+
				"<li><b>User ID:</b>"+title+"\n"+
				"</ul>\n"+
				"</body>"+
				"</html>");
		
		response.setIntHeader("Refresh", 10);
		response.setContentType("text/html");
		Format z1=new SimpleDateFormat("dd.MM.yyyy.HH.mm.ss");
		Date d=new Date();
		String newDate=z1.format(d);
		
		out.print(newDate);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
