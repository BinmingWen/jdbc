package cn.wyu.jdbc.part1;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Demo07Login {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名");
        String name = sc.nextLine();
        System.out.println("请输入密码");
        String password = sc.nextLine();
        login(name, password);
    }

    private static void login(String name, String password) {
        Connection conn = jdbcUtils.getConnection();
        String sql = "select * from user where name='" + name + "' and password='" + password + "'";
        Statement statement = null;
        ResultSet rs = null;
        try {
            statement = conn.createStatement();
            rs = statement.executeQuery(sql);
            if (rs.next()) {
                System.out.println("登录成功！欢迎" + name);
            }else{
                System.out.println("抱歉，登录失败！");
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            jdbcUtils.close(rs,statement,conn);
        }

    }
}
