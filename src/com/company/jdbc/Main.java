package com.company.jdbc;

import java.sql.*;

public class Main {

    public static void main(String[] args) {
        // write your code here
        try {
            //Load driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/java19", "root", "koodinh");
            Statement stm = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
            String query = "SELECT * FROM users";
            ResultSet rs = stm.executeQuery(query);
            rs.next();
            rs.relative(5);
            String id = rs.getString("id");
            String fullName = rs.getString("fullname");
            String userName = rs.getString("username");
            String address = rs.getString("address");
            System.out.println(id + "-" + fullName + "-" + userName + "-" + address);

            /*while (rs.next()) {
                String id = rs.getString("id");
                String fullName = rs.getString("fullname");
                String userName = rs.getString("username");
                String address = rs.getString("address");
                System.out.println(id + "-" + fullName + "-" + userName + "-" + address);
            }*/

           /* query = "INSERT INTO users(id,fullname,username,address) VALUES(101,'Nam','Nam','HN')";
            stm.execute(query);*/

            PreparedStatement prp = conn.prepareStatement("INSERT INTO users(id,fullname,username,address) VALUES(?,?,?,?)");
            prp.setInt(1, 102);
            prp.setString(2, "Nguyen Luan");
            prp.setString(3, "Lrandom");
            prp.setString(4, "Ha Long");
            prp.execute();

            prp.setInt(1,104);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
