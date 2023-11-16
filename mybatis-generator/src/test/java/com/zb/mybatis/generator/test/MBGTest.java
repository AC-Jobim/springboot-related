package com.zb.mybatis.generator.test;

import com.zb.mybatis.generator.MybatisGeneratorApplication;
import com.zb.mybatis.generator.mapper.EmpMapper;
import com.zb.mybatis.generator.pojo.Emp;
import com.zb.mybatis.generator.pojo.EmpExample;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.servlet.AsyncHandlerInterceptor;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @description: TODO
 * @author: ZB
 * @create: 2022-07-17 18:20
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class MBGTest {

    @Autowired
    EmpMapper mapper;

    @Test
    public void test(){

        // 查询所有数据
        System.out.println("\n--------->查询所有数据");
        List<Emp> emps = mapper.selectByExample(null); // 没有查询条件就相当于查询所有数据
//        emps.forEach(emp -> System.out.println(emp));

        // 根据条件查询 QBC: Query by Criteria
        EmpExample example = new EmpExample();

        // 名字叫a1的
        System.out.println("\n--------->根据条件查询");
        example.createCriteria().andEmpNameEqualTo("a1");
        example.or().andAgeGreaterThanOrEqualTo(20);
        List<Emp> emps1 = mapper.selectByExample(example);
        emps1.forEach(System.out::println);


//        mapper.updateByPrimaryKey(new Emp(1, "admin", 22, null));
//        mapper.updateByPrimaryKeySelective(new Emp(2, "admin", 22, null));

//        try {
//            //根据条件查询 QBC: Query by Criteria
//            EmpExample example = new EmpExample();
//
//            //名字叫Bela的
//            System.out.println("\n--------->根据条件查询");
//            example.createCriteria().andEmpNameEqualTo("Bela");
//            List<Emp> emps1 = mapper.selectByExample(example);
//            emps1.forEach(emp -> System.out.println(emp));
//
//            //链式添加条件
//            System.out.println("\n--------->链式添加条件");
//            example.createCriteria().andEmpNameEqualTo("Bela").andAgeEqualTo(33);
//            List<Emp> emps2 = mapper.selectByExample(example);
//            emps2.forEach(emp -> System.out.println(emp));
//
//            //两个条件用or连接
//            System.out.println("\n--------->两个条件用or连接");
//            example.createCriteria().andAgeLessThan(30);
//            example.or().andDidIsNotNull();
//            List<Emp> emps3 = mapper.selectByExample(example);
//            emps3.forEach(emp -> System.out.println(emp));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @Test
    public void testBatch() {

        Emp empTemp = new Emp();
        empTemp.setAge(1);
        empTemp.setEmpName("名字" + 1);
        mapper.insert(empTemp);

        List<Emp> empList = new ArrayList<>();
        for (int i = 0;i < 5;i ++) {
            Emp emp = new Emp();
            emp.setAge(i);
            emp.setEmpName("名字" + i);
            empList.add(emp);

        }

        long startTime = System.currentTimeMillis();
        mapper.insertBatch(empList);
        System.out.println("时间2:" + (System.currentTimeMillis() - startTime));
        startTime = System.currentTimeMillis();
        empList.forEach(c -> mapper.insert(c));
        System.out.println("时间1:" + (System.currentTimeMillis() - startTime));

        startTime = System.currentTimeMillis();
        SqlSession sqlSession = sqlSessionFactory.openSession(ExecutorType.BATCH, false);
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        empList.stream().forEach(c -> mapper.insertSelective(c));
        sqlSession.commit();
        sqlSession.close();
        System.out.println("时间3:" + (System.currentTimeMillis() - startTime));

    }



}
