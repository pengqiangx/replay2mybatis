package com.github.pq;

import lombok.Getter;
import lombok.Setter;

/**
 * @author xiaoniu 2019/3/3.
 */
@Getter
@Setter
public class Function {
    /**
     * sql的类型,计划在xml读取有四种情况
     */
    private String sqlType;
    /**
     * 方法名
     */
    private String funcName;
    /**
     * 执行的sql语句
     */
    private String sql;
    /**
     * 返回类型
     */
    private Object resultType;
    /**
     * 参数类型
     */
    private String parameterType;
}
