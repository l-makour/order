package com.checkconsulting.order.utils;

import com.checkconsulting.order.utils.ResponseStatus;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CustomResponse<T> {
    T CustomDto;
    String errorMessage;
    ResponseStatus response;
}
