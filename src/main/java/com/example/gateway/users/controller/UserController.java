package com.example.gateway.users.controller;

import com.example.gateway.common.dto.ApiResDto;
import org.springframework.cloud.gateway.webflux.ProxyExchange;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/users")
public class UserController {

    @PostMapping
    public Mono<ResponseEntity<?>> addUser(ProxyExchange proxyExchange) {
        return proxyExchange.uri("http://localhost:770/users").post();
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<ApiResDto>> getUser(ProxyExchange<ApiResDto> proxyExchange, @PathVariable String id) {
        return proxyExchange.uri("http://localhost:770/users/" + id).get(response -> {
            ApiResDto apiResDto = ApiResDto.createApiResDto(response.getBody());
            return new ResponseEntity<>(apiResDto, response.getStatusCode());
        });
    }
}
