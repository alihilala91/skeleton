package com.ali.skeletonV1.exception;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@AllArgsConstructor
public class ResourceException extends RuntimeException {

    private String message;
    private HttpStatus status;

}
