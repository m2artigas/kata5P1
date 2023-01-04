package src;

import java.sql.*;

public class DatabaseConnection {

    private static Connection connect(){

        String url = "jdbc:sqlite:Kata5P1/KATA5.db";
        Connection con = null;
        try {
            con = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
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

    public void insert(String email) {
        String sql = "INSERT INTO EMAIL(Mail) VALUES(?)";

        try(Connection con = this.connect();
            PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, email);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
