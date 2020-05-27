package cn.wyu.jdbc.part1;

import java.sql.*;
import java.util.Scanner;

public class Demo08Login {
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
        String sql = "select * from user where name=? and password=?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2,password);
            rs = ps.executeQuery();
            if (rs.next()) {
                System.out.println("登录成功！欢迎" + name);
            }else{
                System.out.println("抱歉，登录失败！");
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            jdbcUtils.close(rs,ps,conn);
        }

    }
}
