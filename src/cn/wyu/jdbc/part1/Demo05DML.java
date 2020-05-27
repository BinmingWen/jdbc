package cn.wyu.jdbc.part1;

import java.sql.*;

public class Demo05DML {
    public static void main(String[] args) throws Exception {
        //1.创建连接
        Connection conn = DriverManager.getConnection("jdbc:mysql:///jdbc?characterEncoding=utf8", "root", "root");
        //2.创建Statement对象
        Statement statement = conn.createStatement();
        //3.执行Sql语句
        int count = 0;
        count +=statement.executeUpdate("insert into student values (null,'孙悟空',1,'1993-02-02')");
        count +=statement.executeUpdate("insert into student values (null,'猪八戒',1,'1993-02-02')");
        count +=statement.executeUpdate("insert into student values (null,'白骨精',0,'1993-02-02')");
        count +=statement.executeUpdate("insert into student values (null,'紫霞',0,'1993-02-02')");
        System.out.println("插入了" + count + "条记录");
        //5.释放资源
        statement.close();
        conn.close();
    }
}
