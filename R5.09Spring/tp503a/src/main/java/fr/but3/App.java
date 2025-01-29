package fr.but3;
import com.sun.tools.javac.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Hello world!
 */
public class App {
    private static String dbURL;
    private static String user;
    private static String password;
    private static Connection con;

    public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {
        Class.forName("org.postgresql.Driver");
        dbURL="jdbc:postgresql://psqlserv/but3";
        user="joshuacollinetu";
        password="moi";
        con = DriverManager.getConnection(dbURL, user, password);
        con.close();
        System.out.println("Hello World!");

                try {
                    // Charger le fichier de propriétés à partir des ressources
                    InputStream is = Main.class.getClassLoader().getResourceAsStream("data.txt");
                    BufferedReader br = new BufferedReader(new InputStreamReader(is));

                    // Afficher "Hello World!" avant de lire le contenu du fichier
                    System.out.println("Hello World!");

                    // Lire et afficher le contenu complet du fichier data.txt
                    String line;
                    while ((line = br.readLine()) != null) {
                        System.out.println(line);
                    }

                    br.close(); // N'oubliez pas de fermer le BufferedReader

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
}
