package com.github.pq;

import java.lang.reflect.Proxy;

/**
 * @author xiaoniu 2019/3/3.
 */
public class MySqlSession {
    private Executor excutor= new DefaultExecutor();

    private MyConfiguration myConfiguration = new MyConfiguration();

    public <T> T selectOne(String statement,Object parameter){
        return excutor.query(statement, parameter);
    }

    @SuppressWarnings("unchecked")
    public <T> T getMapper(Class<T> clas){
        //动态代理调用
        return (T)Proxy.newProxyInstance(clas.getClassLoader(),new Class[]{clas},
                new DefaultMapperProxy(myConfiguration,this));
    }
}
