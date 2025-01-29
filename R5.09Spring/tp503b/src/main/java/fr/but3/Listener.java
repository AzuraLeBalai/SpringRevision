package fr.but3;

import java.sql.*;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/servlet-liste")
public class Listener extends HttpServlet
{
    public void service(HttpServletRequest req, HttpServletResponse res ) throws ServletException, IOException{

        final String JDBC_URL = "jdbc:postgresql://psqlserv/but3";
        final String JDBC_USER = "joshuacollinetu";
        final String JDBC_PASSWORD = "moi";

        res.setContentType("text/html;charset=UTF-8");
        PrintWriter out = res.getWriter();
        out.println( "<h1>Point Rouge</h1>");
        try { Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);

            String query = "select * from etudiant";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            out.println( "<table>");
            while (rs.next())
            {
                int id = rs.getInt("id");
                String nom = rs.getString("nom");
                String prenom = rs.getString("prenom");
                String group = rs.getString("groupe");
                out.println( "<tr><td>" + id + "</td><td> " + nom + "</td><td> " + prenom + "</td><td> " + group + "</td></tr>"+  "<br>");
            }
            out.println( "</table></body></html>" );
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
}