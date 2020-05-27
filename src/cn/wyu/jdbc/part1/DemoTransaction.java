package cn.wyu.jdbc.part1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DemoTransaction {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = jdbcUtils.getConnection();
            conn.setAutoCommit(false);
            ps = conn.prepareStatement("update account set balance = balance-? where name=?");
            ps.setInt(1, 500);
            ps.setString(2, "jack");
            ps.executeUpdate();
            //出现异常
            System.out.println(100 / 0);
            ps = conn.prepareStatement("update account set balance = balance+? where name=?");
            ps.setInt(1, 500);
            ps.setString(2, "rose");
            ps.executeUpdate();
            //提交事务
            conn.commit();
            System.out.println("转账成功！");
        } catch (Exception e) {
            e.printStackTrace();
            //事务回滚
            try {
                conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            System.out.println("转账失败！");
        }finally {
            //关闭资源
            jdbcUtils.close(ps,conn);
        }
    }
}
