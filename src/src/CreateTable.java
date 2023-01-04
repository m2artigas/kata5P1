package src;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {

    public static void createNewTable() {
        String url = "jdbc:sqlite:Kata5P1/KATA5.db";

        String sql = "CREATE TABLE IF NOT EXISTS EMAIL (\n"
                + " Id integer PRIMARY KEY AUTOINCREMENT, \n"
                + "Mail text NOT NULL);";
        try (Connection con = DriverManager.getConnection(url);
             Statement stmt = con.createStatement()) {
            stmt.execute(sql);
            System.out.println("Tabla creada");

        } catch (SQLException e){
            System.out.println(e.getMessage());
        }

    }
}
