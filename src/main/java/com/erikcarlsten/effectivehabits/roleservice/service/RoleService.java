package com.erikcarlsten.effectivehabits.roleservice.service;

import com.erikcarlsten.effectivehabits.roleservice.domain.Role;
import com.erikcarlsten.effectivehabits.roleservice.domain.RoleRepository;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class RoleService {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Collection<Role> findAll() {
        return Lists.newArrayList(roleRepository.findAll());
    }

    public Role findOne(long id) {
        return roleRepository.findOne(id);
    }

    public Role create(Role role) {
        return roleRepository.save(role);
    }

    public Role update(long id, Role role) {
        if (roleRepository.exists(id)) {
            return roleRepository.save(role);
        } else {
            return null;
        }
    }

    public void delete(long id) {
        roleRepository.delete(id);
    }

}
