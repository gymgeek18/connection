package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String driveName = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/studio";
        String user = "root";
        String password = "root";

        try
        {
            Class.forName(driveName);
            Connection con = DriverManager.getConnection(url, user, password);
            Statement stmt = con.createStatement();
            if(con!=null)
            {
                System.out.println("Connection success");
            }
            ResultSet rs = stmt.executeQuery("SELECT * FROM equipment");

            while(rs.next()){
                System.out.println("Mics :"+rs.getInt(1));
                System.out.println("Genre :"+rs.getString(2));
                System.out.println("Price :"+rs.getInt(3));
                System.out.println("Artist :"+rs.getString(4));

                System.out.println("====================================");

            }

            int row_count = stmt.executeUpdate("INSERT INTO equipment(mics,artist,price,genre) VALUES(22,'john lennon',55,'trance')");
            System.out.println("Row insert :"+row_count);

        }
        catch(Exception ex)
        {
            System.out.println("DB error :"+ex);
        }
    }
}
