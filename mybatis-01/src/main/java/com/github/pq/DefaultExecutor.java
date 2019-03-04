package com.github.pq;

import com.github.pq.pojo.MySubject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author xiaoniu 2019/3/3.
 */
public class DefaultExecutor implements Executor {

    private MyConfiguration xmlConfiguration = new MyConfiguration();

    @Override
    public <E> E query(String sql, Object parameter) {
        Connection connection=getConnection();
        ResultSet set =null;
        PreparedStatement pre =null;
        try {
            pre = connection.prepareStatement(sql);
            //设置参数
            pre.setString(1, parameter.toString());
            set = pre.executeQuery();
            MySubject u = new MySubject();
            //遍历结果集
            while(set.next()){
                u.setId(set.getInt(1));
                u.setName(set.getString(2));
                u.setAge(set.getInt(3));
                u.setHeight(set.getInt(4));
                u.setWeight(set.getInt(5));
            }
            return (E) u;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            try{
                if(set!=null){
                    set.close();
                }if(pre!=null){
                    pre.close();
                }if(connection!=null){
                    connection.close();
                }
            }catch(Exception e2){
                e2.printStackTrace();
            }
        }
        return null;
    }

    private Connection getConnection() {
        try {
            Connection connection =xmlConfiguration.build("config.xml");
            return connection;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
