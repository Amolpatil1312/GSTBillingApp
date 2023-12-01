package com.csi.sevice.test;

import com.csi.model.Customer;
import com.csi.repo.CustomerRepo;
import com.csi.service.CustomerService;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CustomerServiceTest {

    @Autowired
    CustomerService customerServiceImpl;

    @MockBean
    private CustomerRepo customerRepoImpl;

    @Test
    public void findAllTest(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Customer customer1 = new Customer(101,"amol",new Date(),8793932076l,"mi Mobile","pune","amol@gmail.com",78545454544212l,48400);
         List custList = new ArrayList<>(); Customer customer2 = new Customer(101,"amol",new Date(),8793932076l,"mi Mobile","pune","amol@gmail.com",78545454544212l,48400);
        Customer customer3 = new Customer(101,"amol",new Date(),8793932076l,"mi Mobile","pune","amol@gmail.com",78545454544212l,48400);

        custList.add(customer1);
        custList.add(customer2);
        custList.add(customer3);
        Mockito.when(customerRepoImpl.findAll()).thenReturn(custList);
        Assertions.assertEquals(3,customerServiceImpl.viewAll().size());
    }

    @Test
    public void saveTest(){
        Customer customer = new Customer(101,"amol",new Date(),8793932076l,"mi Mobile","pune","amol@gmail.com",78545454544212l,48400);
        customerServiceImpl.createGSTBill(customer);

        Mockito.verify(customerRepoImpl,Mockito.times(1)).save(customer);
    }

    @Test
    public void deleteByIdTest(){
        Customer customer1 = new Customer(101,"amol",new Date(),8793932076l,"mi Mobile","pune","amol@gmail.com",78545454544212l,48400);
        Customer customer2 = new Customer(102,"amol",new Date(),8793932076l,"mi Mobile","pune","amol@gmail.com",78545454544212l,48400);
        Customer customer3 = new Customer(103,"amol",new Date(),8793932076l,"mi Mobile","pune","amol@gmail.com",78545454544212l,48400);

        customerServiceImpl.createGSTBill(customer1);
        customerServiceImpl.createGSTBill(customer2);
        customerServiceImpl.createGSTBill(customer3);
        customerServiceImpl.deleteById(101);
        customerServiceImpl.deleteById(102);
        Mockito.verify(customerRepoImpl,Mockito.times(1)).deleteById(101);
    }
    public void findById(){
        Customer customer1 = new Customer(101,"amol",new Date(),8793932076l,"mi Mobile","pune","amol@gmail.com",78545454544212l,48400);
        customerServiceImpl.createGSTBill(customer1);

    }

}
