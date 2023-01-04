package src;

import java.sql.*;
import java.util.List;

public class Kata5P1 {

    public static void main(String[] args) {

        /*CreateTable newTable = new CreateTable();
        newTable.createNewTable();*/
        String txtEmails = "Kata5P1/email.txt";
        List<String> emails = MailListReader.read(txtEmails);

        DatabaseConnection dbc = new DatabaseConnection();

        for (String email: emails) {
            dbc.insert(email);
        }
    }



}
