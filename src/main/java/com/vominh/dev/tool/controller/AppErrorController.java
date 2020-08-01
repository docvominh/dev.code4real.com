package com.vominh.dev.tool.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

@Controller
public class AppErrorController implements ErrorController {

    @Override
    public String getErrorPath() {
        return "/error";
    }

    @RequestMapping("/error")
    public String handleError(HttpServletRequest request, Model model) {
//        LogService.error((String) request.getAttribute(RequestDispatcher.ERROR_MESSAGE));
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        Integer statusCode = Integer.valueOf(status.toString());
        model.addAttribute("code", statusCode);

//        if (status != null) {
//            if (statusCode == HttpStatus.NOT_FOUND.value()) {
//                model.addAttribute("code",HttpStatus.NOT_FOUND.value());
//            } else if (statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
//                model.addAttribute("code",HttpStatus.INTERNAL_SERVER_ERROR.value());
//            }
//        }
        return "error";
    }
}
