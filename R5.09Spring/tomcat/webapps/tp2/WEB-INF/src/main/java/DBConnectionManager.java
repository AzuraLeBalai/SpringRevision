import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionManager {

    private String dbURL;
    private String user;
    private String password;
    private Connection con;

    public DBConnectionManager(){
        this.dbURL="jdbc:postgresql://psqlserv/but3";
        this.user="joshuacollinetu";
        this.password="moi";

    }

    public Connection getConnection() throws SQLException {
        this.con = DriverManager.getConnection(this.dbURL, this.user, this.password);
        return this.con;
    }

    public void closeConnection() throws SQLException {
        this.con.close();
    }
}
