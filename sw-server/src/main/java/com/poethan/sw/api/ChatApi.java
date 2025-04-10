package com.poethan.sw.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chat")
public class ChatApi {
    @GetMapping("/hw")
    public String helloworld() {
        return "hello world!";
    }
}
