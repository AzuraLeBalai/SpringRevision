package fr.but3;

// Servlet Test.java  de test de la configuration
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/private/welcome2")
public class Welcome2 extends HttpServlet
{
  public void service( HttpServletRequest req, HttpServletResponse res ) 
       throws ServletException, IOException
  {
    res.setContentType("text/html;charset=UTF-8");
    PrintWriter out = res.getWriter();
    out.println("<!doctype html>");
    out.println("<head><title>servlet Welcome</title>");
    out.println("<link rel=stylesheet href="+req.getContextPath()+"/style.css></head>");
    out.println("</head><body><center> ");
    HttpSession session=req.getSession(true);
    String login = (String) session.getAttribute("token");
    out.println("<h1>Servlet2<h1>");
    out.println("<h2>Bonjour Mr/Mme "+login+", bienvenu sur ce site<h2>");
    out.println("</body></html> ");
  }
}
