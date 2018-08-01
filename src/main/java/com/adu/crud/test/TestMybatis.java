package com.adu.crud.test;

import com.adu.crud.dao.EmployeeMapper;
import com.adu.crud.entity.Employee;
import com.adu.crud.entity.EmployeePoJo;
import com.adu.crud.entity.EmployeeVo;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/appliactionContext.xml"})
public class TestMybatis {
    String uuid = UUID.randomUUID().toString();
    @Test
    public void testMbg() throws IOException, XMLParserException, InvalidConfigurationException, SQLException, InterruptedException {
        List<String> warnings = new ArrayList<String>();
        boolean overwrite = true;
        File configFile = new File("mbg.xml");
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(configFile);
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(null);
    }

    @Autowired
    private EmployeeMapper employeeMapper;

    @Autowired
    private SqlSession sqlSession;

    @Test
    public void testSpirngDao() throws Exception {
        employeeMapper.insertALL(new Employee(null,"张三","男",uuid+"@qq.com",1));
//        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
//        for (int i = 0; i < 1; i++) {
//
//            mapper.insert(new EmployeePoJo(null,"张三","男",uuid+"@qq.com",1));
//        }
//        Method[] methods = employeeMapper.getClass().getMethods();
//        for (Method method : methods) {
//            System.out.println(method.getName());
//        }
        System.out.println(employeeMapper);
    }
}
