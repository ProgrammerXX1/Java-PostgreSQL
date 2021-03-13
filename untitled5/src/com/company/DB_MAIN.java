package com.company;
import java.sql.*;
import java.util.Scanner;
public class DB_MAIN {
    private static final String DB_USERNAME = "postgres";
    private static final String DB_PASSWORD = "2123";
    private static final String DB_URL = "jdbc:postgresql:postgres";
    static PreparedStatement preparedStatement;

    public static void main(String[] args) throws SQLException {
        Scanner scan = new Scanner(System.in);
        System.out.println("You need select");
        System.out.println("1.Main_Data\n2.Cloth\n3.Patterns");
        System.out.println("--------------------------------");
        int a=scan.nextInt();
        switch(a){
            case 1:
                Main_Data_Table_1.Main_Data_Send();
                break;
            case 2:
                Cloth_Table_2.Cloth_Table_2_Send();
                break;
            case 3:
                Patterns_Table_3.Patterns_Table_3_Send();
                break;
            case 4:
                System.out.println("Вы вышли из программы");
                break;
            default:{
                System.out.println("Вы ошиблись вводом");
                System.out.println("--------------------------------");}
        }
    }
}
