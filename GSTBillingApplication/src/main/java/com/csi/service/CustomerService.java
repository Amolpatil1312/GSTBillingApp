package com.csi.service;

import com.csi.exception.RecordNotFoundExeption;
import com.csi.model.Customer;
import com.csi.repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    CustomerRepo customerRepoImpl;

    public void createGSTBill(Customer customer){
        customerRepoImpl.save(customer);
    }

    public List<Customer> viewAll(){
        return customerRepoImpl.findAll();
    }

    public Customer findById(int custId){
        return customerRepoImpl.findById(custId).orElseThrow(()->new RecordNotFoundExeption("Id Not Available..."));
    }

    public Customer updateBill(Customer customer,int empId){
        Customer customer1 = findById(empId);
        customer1.setCustGSTNumber(customer.getCustGSTNumber());
        customer1.setCustEmailId(customer.getCustEmailId());
        customer1.setBillDate(customer.getBillDate());
        customer1.setCustContactNumber(customer.getCustContactNumber());
        customer1.setCustName(customer.getCustName());
        customer1.setCustdescription(customer.getCustdescription());
        return customerRepoImpl.save(customer1);
    }

    public List<Customer> findByName(String custName){
        return customerRepoImpl.findByCustName(custName);
    }

    public void deleteById(int custId){
        customerRepoImpl.deleteById(custId);
    }

    public void deleteAll(){
        customerRepoImpl.deleteAll();
    }

}
