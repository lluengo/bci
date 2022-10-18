package com.bci.examen.examen.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class ErrorDetail {
    private Date timeStamp;
    private int codigo;
    private String detail;
}
