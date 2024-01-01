package org.ace.eventplanning.controller;

import lombok.AllArgsConstructor;
import org.ace.eventplanning.dto.NewRegisterRequest;
import org.ace.eventplanning.entity.Register;
import org.ace.eventplanning.service.RegisterService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/registers")
@AllArgsConstructor
public class RegisterController {
    private final RegisterService registerService;

    @PostMapping
    public ResponseEntity<Register> register(@RequestBody NewRegisterRequest registerRequest){
        Register registeredRegister = registerService.register(registerRequest);
        return new ResponseEntity<>(registeredRegister, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Register>> findAllRegister(){
        List<Register> registerList = registerService.findAllRegister();
        return new ResponseEntity<>(registerList,HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteRegister(@RequestParam long registerID){
        registerService.deleteRegister(registerID);
        return new ResponseEntity<>("Deleted",HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{registerID}")
    public ResponseEntity<Register> findRegisterID (@PathVariable long registerID){
        Register register = registerService.findByRegisterID(registerID);
        return new ResponseEntity<>(register, HttpStatus.OK);
    }

    @PutMapping("/{registerID}")
    public ResponseEntity<Register> updateRegister (@PathVariable Long registerID, @RequestBody Register updatedRegisterData) {
        Register updatedRegister = registerService.updateRegister(registerID, updatedRegisterData);

        if (updatedRegister != null) {
            return ResponseEntity.ok(updatedRegister);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
