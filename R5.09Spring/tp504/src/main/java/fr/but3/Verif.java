package fr.but3;

import fr.but3.tools.DBConnectionManager;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

// N'est appelée QUE par la page de login
@WebServlet("/verif")
public class Verif extends HttpServlet
{
  public void service( HttpServletRequest req, HttpServletResponse res ) 
       throws ServletException, IOException
    {
            String login = req.getParameter("login");
            String pwd = req.getParameter("pwd");
        
            System.out.println("Verif : "+login+" "+pwd);
            DBConnectionManager db = new DBConnectionManager();

            try{
                Connection connection = db.getConnection();
                String query = "\"select * from utilisateurs where login='\"login+\"’ and mdp=’\"+mdp+\"’ ;\"+";
            }catch (SQLException e){
                e.printStackTrace();
            }

            if (login != null && pwd != null && login.equals("xxx") && pwd.equals("xxx"))
            {   // le login est correct, on fournit la page demandée
                HttpSession session=req.getSession(true);
                session.setAttribute("token", login);
                System.out.println("Dans la session :"+session.getAttribute("token"));
                System.out.println("Redirection vers "+req.getParameter("origine"));
                res.sendRedirect(req.getParameter("origine"));
            } else
            {
                // non authentifié, on repart au login
                res.sendRedirect("login.jsp?mess=login/mdp incorrect : "+login+" "+pwd);
            }
    }
}
