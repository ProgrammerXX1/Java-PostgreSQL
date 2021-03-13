package com.company;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
class Patterns_Table_3 extends Main_Data_Table_1 {
    Patterns_Table_3() throws SQLException { }
    void create_table_string_3(String create, int id, String shirt, String pants, String dresses) throws SQLException {
        preparedStatement = connection.prepareStatement(create);
        preparedStatement.setInt(1, id);
        preparedStatement.setString(2, shirt);
        preparedStatement.setString(3, pants);
        preparedStatement.setString(4, dresses);
        preparedStatement.executeUpdate(); }
    public void table_Patterns() throws SQLException {
        String SQL_SELECT = "SELECT * FROM public.\"Patterns\"\n" + "ORDER BY id ASC";
        ResultSet result = statement.executeQuery(SQL_SELECT);
        System.out.println("--------------------------------");
        while (result.next()) {
            System.out.println(
                    result.getInt("id") + " " +
                            result.getString("shirt") + " " +
                            result.getString("pants") + " " +
                            result.getString("dresses")
            );}
        System.out.println("--------------------------------"); }
    static void Patterns_Table_3_Send() throws SQLException {
        int id;
        String shirt,pants,dresses;
        Scanner scan = new Scanner(System.in);
        while(true) {
            Patterns_Table_3 T = new Patterns_Table_3();
            T.print_com("Patterns");
            int command = scan.nextInt();
            switch(command){
                case 1:
                    T.table_Patterns();
                    break;
                case 2:
                    System.out.println("Введите названия и опишите его");
                    String create="insert into public.\"Patterns\"\n (id,shirt,pants,dresses) values (?,?,?,?)";
                    System.out.print("ID:");
                    id = scan.nextInt();
                    System.out.print("Shirt:");
                    shirt = scan.next();
                    System.out.print("Pants:");
                    pants = scan.next();
                    System.out.print("Dresses:");
                    dresses = scan.next();
                    T.create_table_string_3(create,id, shirt, pants, dresses);
                    break;
                case 3:
                    System.out.println("Введите идентификатор ID");
                    String delete="DELETE FROM public.\"Patterns\"\n WHERE id = ?";
                    id = scan.nextInt();
                    T.delete_string(delete,id);
                    break;
                case 4:
                    System.out.println(0);
                    break;
                default:
                    System.out.println("Такой команды нету введите занова");
                    break;
            }}}}
