package com.example.gateway.common.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.*;
import org.springframework.http.HttpStatus;
import org.springframework.util.ObjectUtils;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class ApiResDto<T> {

    @JsonIgnore
    private HttpStatus status;
    private String code;
    private String message;
    @JsonUnwrapped
    @JsonInclude(value= NON_NULL)
    private T result;

    public static ApiResDto createApiResDto(ApiResDto apiResDto) {
        return ApiResDto.builder()
                .status(apiResDto.getStatus())
                .code(apiResDto.getCode())
                .message(apiResDto.getMessage())
                .result(apiResDto.getResult())
                .build();
    }
}
