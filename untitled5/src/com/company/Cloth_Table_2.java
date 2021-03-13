package com.company;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
class Cloth_Table_2 extends Main_Data_Table_1 {
    Cloth_Table_2() throws SQLException { }
    void create_table_string_2(String create,int id,String Name,String Chest) throws SQLException {
        preparedStatement = connection.prepareStatement(create);
        preparedStatement.setInt(1, id);
        preparedStatement.setString(2, Name);
        preparedStatement.setString(3, Chest);
        preparedStatement.executeUpdate(); }
    public void table_Cloth() throws SQLException {
        String SQL_SELECT = "SELECT * FROM public.\"Cloth\"\n" + "ORDER BY id ASC";
        ResultSet result = statement.executeQuery(SQL_SELECT);
        System.out.println("--------------------------------");
        while (result.next()) {
            System.out.println(
                    result.getInt("id") + " " +
                            result.getString("color") + " " +
                            result.getString("type")
            );}
        System.out.println("--------------------------------"); }
    static void Cloth_Table_2_Send() throws SQLException {
        int id;
        String s,h,color,type;
        Scanner scan = new Scanner(System.in);
        while(true) {
            Cloth_Table_2 T = new Cloth_Table_2();
            T.print_com("Cloth");
            int command = scan.nextInt();
            switch(command){
                case 1:
                    T.table_Cloth();
                    break;
                case 2:
                    System.out.println("Введите названия и опишите его");
                    String create="insert into public.\"Cloth\"\n (id,color,type) values (?,?,?)";
                    System.out.print("ID:");
                    id = scan.nextInt();
                    System.out.print("Color:");
                    color = scan.next();
                    System.out.print("Type:");
                    type = scan.next();
                    T.create_table_string_2(create,id, color, type);
                    break;
                case 3:
                    System.out.println("Введите идентификатор ID");
                    String delete="DELETE FROM public.\"Cloth\"\n WHERE id = ?";
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