package cn.wyu.jdbc.part1;

import java.sql.*;

public class Demo06DQL {
    public static void main(String[] args) throws SQLException {
        //1.获取连接对象
        Connection conn = DriverManager.getConnection("jdbc:mysql:///jdbc", "root", "root");
        //2.得到语句对象
        Statement statement = conn.createStatement();
        //3.执行sql对象
        ResultSet resultSet = statement.executeQuery("select * from student");
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            boolean gender = resultSet.getBoolean("gender");
            Date birthday = resultSet.getDate("birthday");
            //5.输出数据
            System.out.println("编号："+id+" 姓名："+name+" 性别："+gender+" 生日："+birthday);
        }
        //释放资源
        resultSet.close();
        statement.close();
        conn.close();

    }
}
