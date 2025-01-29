import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
@WebServlet("/servlet-S2")
public class S2 extends HttpServlet
{
    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException
    {

        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        out.println("<head> <title>Implémenter un compteur</title> ");
        out.println("</head> <body>");
        out.println("<h1> S2 </h1>");
        out.println("</body>");
    }
}
