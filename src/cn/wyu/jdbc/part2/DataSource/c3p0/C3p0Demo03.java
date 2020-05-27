package cn.wyu.jdbc.part2.DataSource.c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class C3p0Demo03 {
    public static void main(String[] args) throws SQLException {
        setNameConfig();
    }

    private static void setNameConfig() throws SQLException {
        DataSource ds = new ComboPooledDataSource("otherc3p0");
        for (int i = 0; i < 10; i++) {
            Connection conn = ds.getConnection();
            System.out.println(i+" "+conn);
        }
    }
}
