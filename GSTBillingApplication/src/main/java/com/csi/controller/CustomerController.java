package com.csi.controller;

import com.csi.model.Customer;
import com.csi.service.CustomerService;
import jakarta.validation.Valid;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CustomerController {
    @Autowired
    CustomerService customerServiceImpl;
    @PostMapping("/createbill")
    public ResponseEntity<String> createBii(@Valid @RequestBody Customer customer){
        customerServiceImpl.createGSTBill(customer);
        return ResponseEntity.ok("Bill created Successfully...");
    }
    @GetMapping("/viewall")
    public ResponseEntity<List<Customer>> viewAll(){
        return ResponseEntity.ok(customerServiceImpl.viewAll());
    }

    @GetMapping("/findbyid/{custId}")
    public ResponseEntity<Customer> findById(@PathVariable int custId){
        return ResponseEntity.ok(customerServiceImpl.findById(custId));
    }

    @GetMapping("/findbyany/{anyInput}")
    public ResponseEntity<List<Customer>> findByAnyInput(@PathVariable String anyInput){
        return ResponseEntity.ok(customerServiceImpl.viewAll().stream().filter(emp->String.valueOf(emp.getCustId()).equals(anyInput)
                ||emp.getCustName().equals(anyInput)
                || String.valueOf(emp.getCustGSTNumber()).equals(anyInput)
                || String.valueOf(emp.getCustName()).equals(anyInput) || emp.getCustEmailId().equals(anyInput)).toList());
    }

    @GetMapping("/findbyname/{custName}")
    public ResponseEntity<List<Customer>> findByName(@PathVariable String custName){
        return ResponseEntity.ok(customerServiceImpl.findByName(custName));
    }

    @GetMapping("/sortbyid")
    public ResponseEntity<List<Customer>> sortById(){
        return ResponseEntity.ok(customerServiceImpl.viewAll().stream().sorted(Comparator.comparing(Customer::getCustName)).toList());
    }

    @GetMapping("/sortbyname")
    public ResponseEntity<List<Customer>> sortByName(){
        return ResponseEntity.ok(customerServiceImpl.viewAll().stream().sorted(Comparator.comparing(Customer::getCustName)).toList());
    }

    @GetMapping("/sortbybilldate")
    public ResponseEntity<List<Customer>> sortByBillDate(){
        return ResponseEntity.ok(customerServiceImpl.viewAll().stream().sorted(Comparator.comparing(Customer::getBillDate)).toList());
    }

    @DeleteMapping("/deletebyid/{custId}")
    public ResponseEntity<String> deleteById(@PathVariable int custId){
        customerServiceImpl.deleteById(custId);
        return ResponseEntity.ok("Data Deleted Successfully");
    }

    @DeleteMapping("/deleteall")
    public ResponseEntity<String> deleteall(){
        customerServiceImpl.deleteAll();
        return ResponseEntity.ok("All Data Deleted Successfully");
    }

    @PutMapping("/update/{custId}")
    public ResponseEntity<Customer> update(@RequestBody Customer customer,@PathVariable int custId){
        return ResponseEntity.ok(customerServiceImpl.updateBill(customer, custId));
    }
    @GetMapping("/findbydate/{billDate}")
    public ResponseEntity<List<Customer>> findByBillDate(@PathVariable String billDate){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        return ResponseEntity.ok(customerServiceImpl.viewAll().stream().filter(emp->dateFormat.format(emp.getBillDate()).equals(billDate)).toList());
    }


}
