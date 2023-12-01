package com.csi.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Customer {

    @Id
    @GeneratedValue
    private int custId;
    @NotNull
    @Size(min = 5,max = 15,message = "Name must be between 5 to 15 chars")
    private String custName;

    @JsonFormat(pattern = "dd-MM-yyyy")
    @Temporal(TemporalType.DATE)

    private Date billDate;

    @Column(unique = true)
    @NotNull
    private long custContactNumber;

    @NotNull
    private String custdescription;

    @NotNull
    private String custAddress;

    @NotNull
    @Email
    @Column(unique = true)
    private String custEmailId;

    @Column(unique = true)
    @NotNull
    private long custGSTNumber;

    private double totalAmount;
}
