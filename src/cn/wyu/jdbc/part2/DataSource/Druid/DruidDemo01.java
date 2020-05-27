package cn.wyu.jdbc.part2.DataSource.Druid;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

public class DruidDemo01 {
    public static void main(String[] args) throws Exception {
        Properties pro = new Properties();
        //FileInputStream fis = new FileInputStream("F:\\intellij idea\\jdbc\\src\\druid.properties");
        InputStream fis = DruidDemo01.class.getClassLoader().getResourceAsStream("druid.properties");
        pro.load(fis);
        DataSource ds = DruidDataSourceFactory.createDataSource(pro);
        Connection conn = ds.getConnection();
        System.out.println(conn);
    }
}
