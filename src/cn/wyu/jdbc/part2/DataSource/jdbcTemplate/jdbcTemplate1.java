package cn.wyu.jdbc.part2.DataSource.jdbcTemplate;

import cn.wyu.jdbc.Utils.JDBCUtils;
import org.springframework.jdbc.core.JdbcTemplate;

public class jdbcTemplate1 {
    public static void main(String[] args) {
        //1.导入jar包
        //2.创建对象
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
        String sql = "update account set balance=5000 where id=?";
        int count = template.update(sql, 3);
        System.out.println(count);
    }
}
