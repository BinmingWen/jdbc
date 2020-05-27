package cn.wyu.jdbc.part2.DataSource.c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class C3p0Demo01 {
    public static void main(String[] args) throws SQLException {
        //1.创建数据库连接对象
        DataSource ds = new ComboPooledDataSource();
        //2.获取连接对象
        Connection conn = ds.getConnection();

        System.out.println(conn);

    }
}
