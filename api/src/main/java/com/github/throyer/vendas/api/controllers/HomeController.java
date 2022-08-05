package com.github.throyer.vendas.api.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.throyer.vendas.api.utils.Hello;

@RestController
@RequestMapping("/")
public class HomeController {

    @GetMapping
    void index(HttpServletResponse response) throws IOException {
      response.sendRedirect("/api");
    }

    @GetMapping("/api")
    public Hello api() {
        return () -> "Is a live!";
    }
}
