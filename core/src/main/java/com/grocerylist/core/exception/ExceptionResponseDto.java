package com.grocerylist.core.exception;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
/**
 * @author  Adam Mendak
 * @version 1.0
 * @since   2019-12-03
 *
 *  This class invoke method to inform about exception
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExceptionResponseDto {

    @JsonProperty(value = "time_stamp")
    private LocalDateTime timeStamp;

    @JsonProperty(value = "message")
    private String message;
}
