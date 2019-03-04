package com.github.pq;

import com.github.pq.mapper.SubjectMapper;
import com.github.pq.pojo.MySubject;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * @author xiaoniu 2019/3/3.
 */
public class MyBatisTest {

    @Before
    public void setUp() throws Exception {
        Connection connection = null;
        Class.forName("org.hsqldb.jdbcDriver");
        //内存计算
        connection = DriverManager.getConnection("jdbc:hsqldb:mem","sa","");
        //支持持久存储
        //connection = DriverManager.getConnection("jdbc:hsqldb:file:hsql.db");
        Statement statement = connection.createStatement();
        statement.setQueryTimeout(30);  // set timeout to 30 sec.
        statement.executeUpdate("drop table if exists subject ");
        //statement.executeUpdate("drop table person ");
        statement.executeUpdate("CREATE TABLE subject (\n" +
                "  id     INT NOT NULL,\n" +
                "  name   VARCHAR(20),\n" +
                "  age    INT NOT NULL,\n" +
                "  height INT,\n" +
                "  weight INT,\n" +
                "  active BIT,\n" +
                "  dt     TIMESTAMP\n" +
                ");");
        statement.executeUpdate("INSERT INTO subject VALUES\n" +
                "  (1, 'a', 10, 100, 45, 1, CURRENT_TIMESTAMP),\n" +
                "  (2, 'b', 10, NULL, 45, 1, CURRENT_TIMESTAMP),\n" +
                "  (2, 'c', 10, NULL, NULL, 0, CURRENT_TIMESTAMP);");
        /**
        ResultSet rs = statement.executeQuery("select * from subject order by id ");
        while(rs.next()){
            System.out.println("id: "+rs.getInt("id")+"   name: " + rs.getString("name"));
        }
        rs.close();**/
        statement.close();
        connection.close();

    }

    @Test
    public void test01(){

    }

    @Test
    public void test02(){
        MySqlSession sqlsession = new MySqlSession();
        SubjectMapper mapper = sqlsession.getMapper(SubjectMapper.class);
        MySubject user =mapper.getSubject(2);
        System.out.println(user);
    }
}
