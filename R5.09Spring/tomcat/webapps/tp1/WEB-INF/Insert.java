import java.sql.*;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
@WebServlet("/servlet-insert")
public class Insert extends HttpServlet
{
    public void doGet( HttpServletRequest req, HttpServletResponse res ) throws ServletException, IOException{
        res.setContentType("text/html;charset=UTF-8");
        PrintWriter out = res.getWriter();
        out.println( "<html> <form action=servlet-insert method=post> Saisir votre Nom <input name=nom type=text> <br/> Saisir votre Prenom <input name=prenom type=text> <br/> Saisir votre Groupe <input name=groupe type=text> <br/><input type=submit></form></html>");

    }

    public void doPost (HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{

        final String JDBC_URL = "jdbc:postgresql://psqlserv/but3";
        final String JDBC_USER = "joshuacollinetu";
        final String JDBC_PASSWORD = "moi";


        try { Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
            System.out.println("test");
            System.out.println("'" + req.getParameter("prenom") + "'");
            String nom = "'"  + req.getParameter("nom") + "'";
            String prenom = "'" + req.getParameter("prenom") + "'";
            String groupe = "'" + req.getParameter("groupe") + "'";
            String query = "INSERT INTO etudiant (prenom,nom,groupe) VALUES ("+ prenom + "," + nom + "," + groupe + ");";
            PreparedStatement ps = connection.prepareStatement(query);
            System.out.println(query);
            ps.executeUpdate();
            res.sendRedirect("servlet-select");

        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
