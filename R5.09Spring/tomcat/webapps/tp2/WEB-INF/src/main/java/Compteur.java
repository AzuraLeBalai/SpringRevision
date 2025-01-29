import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
@WebServlet("/servlet-compteur")
public class Compteur extends HttpServlet
{ int globalCpt =0;
    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException
    {
        HttpSession session = req.getSession( true );
        Integer sessionCpt = (Integer)session.getAttribute( "compteur" );
        if (sessionCpt == null){
            sessionCpt = 1;
        }else {
            sessionCpt = sessionCpt + 1;
        }
        session.setAttribute( "compteur", sessionCpt );

        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        globalCpt++;
        out.println("<head> <title>Implémenter un compteur</title> ");
        out.println("</head> <body>");
        out.println("<h1> Le nombre de chargements global est : "+ globalCpt + "</h1>");
        out.println("<h1> Le nombre de chargements perso est : "+ sessionCpt + "</h1>");
        out.println("</body>");
    }
}
