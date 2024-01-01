package org.ace.eventplanning.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.ace.eventplanning.dto.NewRegisterRequest;

import java.time.LocalDate;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table (name = "register")
public class Register {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long registerID;
    private LocalDate registerDate;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customerID")
    private Customer customer;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "eventID")
    private Event event;

    public static Register of(NewRegisterRequest registerRequest){
        Register register = new Register();
        register.setRegisterDate(registerRequest.getRegisterDate());
        return register;
    }
}
