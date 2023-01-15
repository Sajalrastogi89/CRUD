package com.example1.demo2.payloads;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Getter@Setter
@AllArgsConstructor
@NoArgsConstructor
public class APIResponse{
    private String message;
    private boolean Status;

}
