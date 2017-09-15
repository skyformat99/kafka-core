package com.cgtz.kafka;

import com.alibaba.fastjson.JSON;

/**
 * Created by Administrator on 2017/9/15.
 */
public class JsonUtil {

    public static String toJson(Object obj){
        return JSON.toJSONString(obj);
    }
}
