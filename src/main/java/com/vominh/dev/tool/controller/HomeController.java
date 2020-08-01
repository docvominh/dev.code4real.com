package com.vominh.dev.tool.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HomeController {

    private static final Logger log = LoggerFactory.getLogger(HomeController.class);


    @ModelAttribute("module")
    String module() {
        return "home";
    }


    @GetMapping("/")
    public String index(Model model, HttpServletRequest request) {
        return "home";
    }
}