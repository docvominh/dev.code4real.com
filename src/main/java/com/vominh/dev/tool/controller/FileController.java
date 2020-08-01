package com.vominh.dev.tool.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;

@Controller
@RequestMapping("file")
public class FileController {
    private static final Logger log = LoggerFactory.getLogger(FileController.class);

    @GetMapping("/convert-base-64")
    public String convertBase64(Model model, HttpServletRequest request) {
        return "file/convert-base-64";
    }

    @PostMapping("/file-to-base-64")
    @ResponseBody
    public String fileToBase64(@RequestParam("file") MultipartFile file) {
        byte[] fileData = new byte[(int) file.getSize()];
        try (InputStream stream = file.getInputStream()) {
            stream.read(fileData, 0, fileData.length);
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }

        if (fileData.length != 0) {
            return Base64.getEncoder().encodeToString(fileData);
        }

        return "error";
    }
}
