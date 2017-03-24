package com.erikcarlsten.effectivehabits.roleservice.web;

import com.erikcarlsten.effectivehabits.roleservice.domain.Role;
import com.erikcarlsten.effectivehabits.roleservice.exception.RoleNotFoundException;
import com.erikcarlsten.effectivehabits.roleservice.service.RoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/roles")
public class RoleController {

    private static final Logger logger = LoggerFactory.getLogger(RoleController.class);

    private RoleService roleService;

    @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<Role>> getAllRoles() {
        return new ResponseEntity<>(roleService.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Role> createRole(@RequestBody Role role) {
        Role createdRole = roleService.create(role);
        return new ResponseEntity<>(createdRole, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Role> getRole(@PathVariable("id") long id) throws RoleNotFoundException {
        Role role = roleService.findOne(id);

        if (role == null) {
            logger.info("Role with id: {} not found.", id);
            throw new RoleNotFoundException("Role with id: " + id + " not found.");
        }

        return new ResponseEntity<>(role, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Role> updateRole(@PathVariable("id") long id, @RequestBody Role role) {
        Role updatedRole = roleService.update(id, role);
        HttpStatus httpStatus = updatedRole == null ? HttpStatus.NOT_FOUND : HttpStatus.OK;
        return new ResponseEntity<>(updatedRole, httpStatus);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Role> deleteRole(@PathVariable("id") long id) {
        roleService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
