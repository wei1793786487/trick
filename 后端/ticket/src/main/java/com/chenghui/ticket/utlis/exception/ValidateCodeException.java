package com.chenghui.ticket.utlis.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * @author Devil
 * @date 2020/1/8 18:36
 */
public class ValidateCodeException extends AuthenticationException {
    public ValidateCodeException(String msg) {
        super(msg);
    }
}
