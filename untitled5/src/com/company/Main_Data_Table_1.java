package com.company;
import java.sql.*;
import java.util.Scanner;
class Main_Data_Table_1 {
    private static final String DB_USERNAME = "postgres";
    private static final String DB_PASSWORD = "2123";
    private static final String DB_URL = "jdbc:postgresql:postgres";
    static PreparedStatement preparedStatement;
    Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
    Statement statement = connection.createStatement();
    Main_Data_Table_1() throws SQLException { }
    void table_Main_Data() throws SQLException {
        String SQL_SELECT = "SELECT * FROM public.\"Main_Data\"\n" + "ORDER BY id ASC";
        ResultSet result = statement.executeQuery(SQL_SELECT);
        System.out.println("--------------------------------");
        while (result.next()) {
            System.out.println(
                    result.getInt("id") + " " +
                            result.getString("nam") + " " +
                            result.getString("chest") + " " +
                            result.getString("waist") + " " +
                            result.getString("hips") + " " +
                            result.getString("height") + " " +
                            result.getString("numb")
            );}
        System.out.println("--------------------------------");
    }
    void create_table_string(String create,int id,String Name,String Chest,String Waist,String Hips,String Height,String Number) throws SQLException {
        preparedStatement = connection.prepareStatement(create);
        preparedStatement.setInt(1, id);
        preparedStatement.setString(2, Name);
        preparedStatement.setString(3, Chest);
        preparedStatement.setString(4, Waist);
        preparedStatement.setString(5, Hips);
        preparedStatement.setString(6, Height);
        preparedStatement.setString(7, Number);
        preparedStatement.executeUpdate();
    }
    void delete_string(String delete,int id) throws SQLException {
        preparedStatement = connection.prepareStatement(delete);
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
    }
    void print_com(String Table){
        System.out.println("1.Показать "+Table+" таблицу по строкам");
        System.out.println("2.Создать строку");
        System.out.println("3.Удалит по ID");
        System.out.println("4.Выйти");
    }
    static void Main_Data_Send() throws SQLException{
        int id;
        String s,h,table,Name,Chest,Waist,Hips,Height,Number;
        Scanner scan = new Scanner(System.in);
        while(true) {
            Main_Data_Table_1 T = new Main_Data_Table_1();
            T.print_com("Main_Data");
            int command = scan.nextInt();
            switch(command){
                case 1:
                    T.table_Main_Data();
                    break;
                case 2:
                    System.out.println("Введите названия и опишите его");
                    String create="insert into public.\"Main_Data\"\n (id,nam,chest,waist,hips,height,numb) values (?,?,?,?,?,?,?)";
                    System.out.print("ID:");
                    id = scan.nextInt();
                    System.out.print("Name:");
                    Name = scan.next();
                    System.out.print("Chest:");
                    Chest = scan.next();
                    System.out.print("Waist:");
                    Waist = scan.next();
                    System.out.print("Hips:");
                    Hips = scan.next();
                    System.out.print("Height:");
                    Height = scan.next();
                    System.out.print("Number:");
                    Number = scan.next();
                    T.create_table_string(create,id, Name, Chest, Waist, Hips, Height, Number);
                    break;
                case 3:
                    System.out.println("Введите идентификатор ID");
                    String delete="DELETE FROM public.\"Main_Data\"\n WHERE id = ?";
                    id = scan.nextInt();
                    T.delete_string(delete,id);
                    break;
                case 4:
                    System.out.println("Вы успешно вышли с программы");
                    break;
                default:
                    System.out.println("Такой команды нету введите занова");
                    break;
            }}}
}
