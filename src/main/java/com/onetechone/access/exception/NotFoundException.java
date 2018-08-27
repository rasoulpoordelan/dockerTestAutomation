package com.onetechone.access.exception;


public class NotFoundException extends CustomException {
    public NotFoundException() {
        super("not_found");
    }
}

