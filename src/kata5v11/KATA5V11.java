
package kata5v11;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class KATA5V11 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
        //Class.forName("oracle.jdbc.driver.OracleDriver");
        Class.forName("org.sqlite.JDBC");
        //Connection conect = DriverManager.getConnection("jdbc:oracle:thin:@10.22.143.90:1521:orcl", "system", "orcl");
        Connection conect = DriverManager.getConnection("jdbc:sqlite:PEOPLE");
	Statement state = conect.createStatement();
        
        String query = " SELECT * FROM PEOPLE";
        ResultSet rs = state.executeQuery(query);
        
        while (rs.next()){
            System.out.println(rs.getInt("ID"));
            System.out.println(rs.getString("NAME"));
            
        }
        String nameFile ="C:\\Users\\usuario\\Documents\\NetBeansProjects\\KATA5V11\\mail.txt";
        BufferedReader reader = new BufferedReader (new FileReader(nameFile));
        String mail;
        /*
        while((mail=reader.readLine()) != null) {
            query = "INSERT INTO MAIL (MAIL) VALUES (' "+mail+"')";
            state.executeUpdate(query);
        }
        */
        
        rs.close();
        state.close();
        
    }
}
