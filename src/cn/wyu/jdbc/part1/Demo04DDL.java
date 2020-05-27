package cn.wyu.jdbc.part1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo04DDL {
    public static void main(String[] args) {
        //可以不用写，加载驱动
        Connection conn = null;
        Statement statement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //1.创建连接
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "root");
            //2.得到语句对象
            statement = conn.createStatement();
            //3.执行sql
            statement.executeUpdate("create table student(id int PRIMARY KEY auto_increment," +
                    "name varchar (20) not null,gender boolean,birthday date)");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //释放资源
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }


        //创建成功
        System.out.println("创建成功");

    }
}
