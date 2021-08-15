/* ResponseDTO.java */
package com.bridgelabz.addressbookservice.dto;

import lombok.Data;

public @Data class ResponseDTO {

    private String message;
    private Object data;

    // Constructor
    public ResponseDTO(String message, Object data) {
        this.message = message;
        this.data = data;
    }
}
