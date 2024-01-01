package org.ace.eventplanning.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Customer")
public class Customer {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long customerID;
    private String customerName;
    private int customerAge;
    private String customerAddress;
    private String customerPhoneNumber;
    private String customerEmail;
    private String customerPassword;

//    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
//    @JsonIgnore
//    private List<Register> registerList;
//
//    public void addRegister(Register register){
//        register.setCustomer(this);
//        this.registerList.add(register);
//    }
}
