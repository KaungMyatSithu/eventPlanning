package org.ace.eventplanning.service.impl;

import lombok.AllArgsConstructor;
import org.ace.eventplanning.dto.NewRegisterRequest;
import org.ace.eventplanning.entity.Customer;
import org.ace.eventplanning.entity.Event;
import org.ace.eventplanning.entity.Register;
import org.ace.eventplanning.repo.CustomerRepo;
import org.ace.eventplanning.repo.EventRepo;
import org.ace.eventplanning.repo.RegisterRepo;
import org.ace.eventplanning.service.RegisterService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RegisterServiceImpl implements RegisterService {
    private final RegisterRepo registerRepo;
    private final CustomerRepo customerRepo;
    private final EventRepo eventRepo;
    @Override
    public List<Register> findAllRegister() {
        return registerRepo.findAll();
    }

    @Override
    public Register register(NewRegisterRequest registerRequest) {
        Customer customer = customerRepo.findById(registerRequest.getCustomerID())
                .orElseThrow(() -> new RuntimeException("Register not found"));
        Event event = eventRepo.findById(registerRequest.getEventID())
                .orElseThrow(()-> new RuntimeException("Register not found"));

        Register register = Register.of(registerRequest);
        register.setCustomer(customer);
        register.setEvent(event);
        return registerRepo.save(register);
    }


    @Override
    public Register findByRegisterID(long registerID) {
        return registerRepo.findById(registerID).orElseThrow(() -> new RuntimeException("Invalid ID" + registerID));
    }

    @Override
    public void deleteRegister(long registerID) {
        if (registerRepo.existsById(registerID));
        registerRepo.findById(registerID);
    }

    @Override
    public Register updateRegister(long registerID, Register updateRegisterData) {
        Optional<Register> optionalRegister= registerRepo.findById(registerID);
        if (optionalRegister.isPresent()) {
            Register existingRegister = optionalRegister.get();
            existingRegister.setRegisterDate(updateRegisterData.getRegisterDate());
            return registerRepo.save(existingRegister);
        }
        return null;
    }
}
