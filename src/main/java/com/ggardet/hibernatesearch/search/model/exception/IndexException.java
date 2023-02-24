package com.ggardet.hibernatesearch.search.model.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class IndexException extends RuntimeException {
    public IndexException(String message, Throwable cause) {
        super(message, cause);
    }
}
