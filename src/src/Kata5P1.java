package src;

import java.sql.*;

import static src.CreateTable.createNewTable;

public class Kata5P1 {

    public static void main(String[] args) {
        /*SelectApp app = new SelectApp();
        app.selectAll();*/
        CreateTable newTable = new CreateTable();
        newTable.createNewTable();
    }



}
