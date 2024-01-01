package org.ace.eventplanning.service;

import org.ace.eventplanning.dto.NewRegisterRequest;
import org.ace.eventplanning.entity.Register;

import java.util.List;

public interface RegisterService {
    //Find All Method
    List<Register> findAllRegister();

    //Register Method
    Register register(NewRegisterRequest registerRequest);

    //Find By ID Method
    Register findByRegisterID(long registerID);

    //Delete Method
    void deleteRegister(long registerID);

    //Update Method
    Register updateRegister(long registerID, Register updateRegisterData);
}
