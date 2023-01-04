package src;

import java.sql.*;

public class SelectApp {

    private static Connection connect(){

        String url = "jdbc:sqlite:Kata5P1/KATA5.db";
        Connection con = null;
        try {
            con = DriverManager.getConnection(url);
            System.out.println("Conexión establecida");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        /*finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex){
                System.out.println(ex.getMessage());
            }
        }*/

        return con;

    }

    public void selectAll(){
        String sql = "SELECT * FROM PEOPLE";
        try (Connection con = this.connect();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while(rs.next()) {
                System.out.println(rs.getInt("id") + "\t" +
                                    rs.getString("Name") + "\t" +
                                    rs.getString("Surname") + "\t" +
                                    rs.getString("Department") + "\t");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
