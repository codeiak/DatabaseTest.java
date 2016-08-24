/*
 * THIS PROJECT IS A SIMPLE TEST, IT'S MY FIRST TIME USING JAVA TO CONNECT TO MY DATABASE ANS IT WORKS.   
 */
package databasetest;

import java.sql.*;

/**
 *
 * @author codeiaks
 */
public class Databasetest {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws SQLException {
        //Declare variable for host name, username, password, and database to be used.
        String uname = "ENTER YOUR USERNAME HERE!";
        String pword = "PUT YOU PASSWORD HERE!";
        connectToAndQueryDatabase(uname, pword);
       
    }
    public static void connectToAndQueryDatabase(String username, String password) throws SQLException{
        /* Create a connection to the database, passing in the username and password to allow successfull connection. */
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/chats", username, password);
        
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM logs ORDER BY id ASC");
        
        while(rs.next()){
            String uName = rs.getString("username");
            String message = rs.getString("messages");
            System.out.println(uName + ": " + message);
        }
    }
}
