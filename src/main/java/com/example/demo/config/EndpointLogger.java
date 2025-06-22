package com.example.demo.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import org.springframework.beans.factory.annotation.Autowired;

@Component
public class EndpointLogger implements CommandLineRunner {

    @Autowired
    private RequestMappingHandlerMapping handlerMapping;

    @Override
    public void run(String... args) {
        handlerMapping.getHandlerMethods().forEach((requestMappingInfo, handlerMethod) -> {
            System.out.println(requestMappingInfo + " -> " + handlerMethod.getMethod().getName());
        });
    }
}

