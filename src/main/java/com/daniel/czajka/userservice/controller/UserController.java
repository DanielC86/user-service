package com.daniel.czajka.userservice.controller;

import com.daniel.czajka.userservice.entity.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RefreshScope
@RestController
@RequestMapping("/user-app")
public class UserController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/messages")
    public List<Messages> findAll(){
        Messages[] messages = restTemplate.getForObject("http://user-data-service/api/messages", Messages[].class);

        return Arrays.asList(messages);
    }

}
