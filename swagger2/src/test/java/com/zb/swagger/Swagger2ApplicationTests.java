package com.zb.swagger;

import com.alibaba.fastjson.JSONObject;
import com.zb.swagger.pojo.Filter;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class Swagger2ApplicationTests {

    @Test
    void contextLoads() {
    }



    @Test
    public void test1() {

        Filter filter = new Filter();
        filter.setCompare("like");
        String jsonStr = JSONObject.toJSONString(filter);

        Map<String, Object> map = (Map<String, Object>) JSONObject.parse(jsonStr);
        Object compare = map.get("compare");
        System.out.println(compare);
        System.out.println(map);
    }


}
