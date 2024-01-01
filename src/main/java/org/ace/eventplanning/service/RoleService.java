package org.ace.eventplanning.service;

import org.ace.eventplanning.entity.Role;

import java.util.List;

public interface RoleService {
    //Find All Method
    List<Role> findAllRole();




    //Register Method
    void registerRole(Role role);




    //Find By ID Method
    Role findByRoleID(long roleID);



    //Delete Method
    void deleteRole(long roleID);


    //Update Method
    Role updateRole(long roleID, Role updateRoleData);
}
