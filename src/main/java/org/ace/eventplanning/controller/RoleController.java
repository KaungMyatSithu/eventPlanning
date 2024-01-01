package org.ace.eventplanning.controller;

import lombok.AllArgsConstructor;
import org.ace.eventplanning.entity.Role;
import org.ace.eventplanning.service.RoleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roles")
@AllArgsConstructor
public class RoleController {
    private final RoleService roleService;

    @PostMapping
    public ResponseEntity<Role> registerRole(@RequestBody Role role){
        roleService.registerRole(role);
        return new ResponseEntity<>(role, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Role>> findAllRole (){
        List<Role> roleList = roleService.findAllRole();
        return new ResponseEntity<>(roleList,HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteRole(@RequestParam long roleID){
        roleService.deleteRole(roleID);
        return new ResponseEntity<>("Deleted",HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{roleID}")
    public ResponseEntity<Role > findRoleID (@PathVariable long roleID){
        Role role = roleService.findByRoleID(roleID);
        return new ResponseEntity<>(role, HttpStatus.OK);
    }

    @PutMapping("/{roleID}")
    public ResponseEntity<Role> updateRole (@PathVariable Long roleID, @RequestBody Role updatedRoleData) {
        Role updatedRole = roleService.updateRole(roleID, updatedRoleData);

        if (updatedRole != null) {
            return ResponseEntity.ok(updatedRole);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
