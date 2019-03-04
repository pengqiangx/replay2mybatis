package com.github.pq;

/**
 * @author xiaoniu 2019/3/3.
 */
public interface Executor {
    /**
     *
     * @param statement
     * @param parameter
     * @param <E>
     * @return
     */
    <E> E query(String statement,Object parameter);
}
