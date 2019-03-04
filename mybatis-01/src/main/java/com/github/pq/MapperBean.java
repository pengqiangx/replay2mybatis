package com.github.pq;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author xiaoniu 2019/3/3.
 */
@Getter
@Setter
public class MapperBean {

    //接口名
    private String interfaceName;
    //接口下所有方法
    private List<Function> list;

}
