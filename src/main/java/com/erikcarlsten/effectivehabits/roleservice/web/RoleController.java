package com.erikcarlsten.effectivehabits.roleservice.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/roles")
public class RoleController {

    @RequestMapping("/")
    public String getAllRoles() {
        return "All Roles";
    }

}
