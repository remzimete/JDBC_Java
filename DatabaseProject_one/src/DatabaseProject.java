


/*
*
* Load the driver
* establish the connection
* create a statement object
* execute a query
* process the results
* close the connection
*
*  section by section.
*
*
* */

import java.sql.*;

public class DatabaseProject {
    public static void main(String[] args) {

        DatabaseProject pro = new DatabaseProject();
        pro.createConnection();



    }

    void createConnection(){


        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Driver and Database  // server address / port address / database name // login // password
            // (DATABASE URL)
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:9999/testdb","root","123123");
            System.out.println("Database connection good :)");



            // statement
            Statement stmt = conn.createStatement();
            // query
            ResultSet rs = stmt.executeQuery("SELECT * FROM coffees");
            while(rs.next()){
                String COF_NAME = rs.getString("COF_NAME");
                int SUP_ID,SALES,TOTAL;
                float PRICE;

                SUP_ID = rs.getInt("SUP_ID");
                SALES = rs.getInt("SALES");
                TOTAL = rs.getInt("TOTAL");

                PRICE = rs.getFloat("PRICE");

                System.out.println("Coffee names:");
                System.out.println(COF_NAME);
                System.out.println("---------------------------");

                System.out.println("SALES");
                System.out.println(SALES);
                System.out.println("---------------------------");

                System.out.println("TOTAL");
                System.out.println(TOTAL);
                System.out.println("----------------------------");

                System.out.println("PRICE");
                System.out.println(PRICE);
                System.out.println("----------------------------");


            }


        }catch(ClassNotFoundException exception){
            System.out.println(exception);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }


}