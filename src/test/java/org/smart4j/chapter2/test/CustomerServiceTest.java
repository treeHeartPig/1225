package org.smart4j.chapter2.test;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smart4j.chapter2.helper.DatabaseHelper;
import org.smart4j.chapter2.model.Customer;
import org.smart4j.chapter2.service.CustomerService;

import java.io.IOException;
import java.util.List;

public class CustomerServiceTest {
    private static final Logger LOGGER= LoggerFactory.getLogger(CustomerServiceTest.class);
    private final CustomerService customerService;
    public  CustomerServiceTest(){
        customerService=new CustomerService();
    }

    @Before
    public  void  init() throws IOException {

        String filePath="jsp/customer_init.sql";
       DatabaseHelper.executeSqlFile(filePath);
    }

    @Test
    public void getCustomerListTest(){
        List<Customer> customerList=customerService.getCustomerList();
        LOGGER.info("----查询出"+customerList.size()+"条数据--");
        Assert.assertEquals(2,customerList.size());
    }
    @Test
    public void getCustomerTest(){
        Customer customer=customerService.getCustomer(1);
        LOGGER.info("--查询出的结果："+customer.getName());
    }
}
