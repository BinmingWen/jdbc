package cn.wyu.jdbc.part2.DataSource.jdbcTemplate;

import cn.wyu.jdbc.Utils.JDBCUtils;
import cn.wyu.jdbc.domain.Student;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class JdbcTemplate2 {
    private JdbcTemplate jt = new JdbcTemplate(JDBCUtils.getDataSource());
    @Test
    //1. 修改1号数据的 gender 为 0
    public void test1(){
        String sql = "update student set gender = 0 where id = ?";
        int count = jt.update(sql, 1);
        System.out.println(count);
    }
    //2. 添加一条记录
    @Test
    public void test2(){
        String sql = "insert into student values(null,?,?,?)";
        int count = jt.update(sql,"温名斌",1,"1997-09-26");
        System.out.println(count);

    }

    //3. 删除刚才添加的记录
    @Test
    public void test03(){

        String sql = "delete from student where name=?";
        int count = jt.update(sql, "温名斌");
        System.out.println(count);
    }
    //	4. 查询id为1的记录，将其封装为Map集合
    @Test
    public void test04(){
        String sql = "select * from student where id = ? or id =?";
        Map<String, Object> map = jt.queryForMap(sql, 1,5);
        System.out.println(map);
    }

    //5. 查询所有记录，将其封装为List
    @Test
    public void test05(){
        String sql = "select * from student";
        List<Map<String, Object>> list = jt.queryForList(sql);
        list.forEach((obj)->{
            System.out.println(obj);
        });
    }
    //6. 查询所有记录，将其封装为Emp对象的List集合
    @Test
    public void test06(){
        String sql = "select * from student";
        List<Student> list = jt.query(sql, new RowMapper<Student>() {
            @Override
            public Student mapRow(ResultSet resultSet, int i) throws SQLException {
                Student s = new Student();
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                boolean gender = resultSet.getBoolean("gender");
                Date birthday = resultSet.getDate("birthday");

                s.setId(id);
                s.setName(name);
                s.setGender(gender);
                s.setBirthday(birthday);
                return s;
            }
        });
        list.forEach((obj)-> System.out.println(obj));
    }
    //6. 查询所有记录，将其封装为Emp对象的List集合
    @Test
    public void test07(){
        String sql = "select * from student";
        List<Student> list = jt.query(sql, new BeanPropertyRowMapper<Student>(Student.class));
        list.forEach((obj)-> System.out.println(obj));
    }
    //7. 查询总记录数
    @Test
    public void test08(){
        String sql = "select count(*) from student";
        Long total = jt.queryForObject(sql, Long.class);
        System.out.println(total);
    }
}
