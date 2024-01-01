package org.ace.eventplanning.service.impl;

import lombok.AllArgsConstructor;
import org.ace.eventplanning.entity.Role;
import org.ace.eventplanning.repo.RoleRepo;
import org.ace.eventplanning.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepo roleRepo;
    @Override
    public List<Role> findAllRole() {
        return roleRepo.findAll();
    }

    @Override
    public void registerRole(Role role) {
        roleRepo.save(role);
    }

    @Override
    public Role findByRoleID(long roleID) {
        return roleRepo.findById(roleID).orElseThrow(() -> new RuntimeException("Invalid ID" + roleID));
    }

    @Override
    public void deleteRole(long roleID) {
        if (roleRepo.existsById(roleID));
        roleRepo.deleteById(roleID);
    }

    @Override
    public Role updateRole(long roleID, Role updateRoleData) {
        Optional<Role> optionalRole = roleRepo.findById(roleID);
        if (optionalRole.isPresent()) {
            Role existingRole = optionalRole.get();
            existingRole.setRoleName(updateRoleData.getRoleName());
            return roleRepo.save(existingRole);
        } else {
            return null;
        }
    }
}
