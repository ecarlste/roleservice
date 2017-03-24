package com.erikcarlsten.effectivehabits.roleservice.exception;

public class RoleNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 3952887612019340395L;

    public RoleNotFoundException(String message) {
        super(message);
    }

}
