package cn.wyu.jdbc.part2.DataSource.Druid;

import cn.wyu.jdbc.Utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DruidDemo02 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JDBCUtils.getConnection();
            //System.out.println(conn);
            ps = conn.prepareStatement("insert into account values(null,?,?)");
            ps.setString(1, "王五");
            ps.setDouble(2, 100);
            int count = ps.executeUpdate();
            System.out.println(count);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(ps,conn);
        }
    }
}
