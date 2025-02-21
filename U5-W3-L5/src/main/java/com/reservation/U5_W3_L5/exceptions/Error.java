package com.reservation.U5_W3_L5.exceptions;

import lombok.Data;

@Data
public class Error {
    private String message;
    private String details;
    private String status;
}