package com.example.demo.controller;

import com.example.demo.service.ExternalApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import tools.jackson.databind.JsonNode;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
public class UploadController {

    @Autowired
    ExternalApiService externalApiService;

    @GetMapping("/product/list")
    public ResponseEntity<JsonNode> getProductList() {
        try {
            JsonNode data = externalApiService.fetchDataFromExternalApi("https://dummyjson.com/products");
            return new ResponseEntity<>(data, HttpStatus.OK);
        } catch (Exception e){
            JsonNode JsonNode = null;
            return new ResponseEntity<>(JsonNode, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/product/upload_image")
    public ResponseEntity<String> uploadProductImage(@RequestParam("file") MultipartFile file) {
        final String UPLOAD_DIR = "src/main/resources/static/uploads/";
        if (file.isEmpty()) {
            return new ResponseEntity<>("Missing file", HttpStatus.BAD_REQUEST);
        }

        try {
            Path uploadPath = Paths.get(UPLOAD_DIR);
            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }
            Path filePath = uploadPath.resolve(file.getOriginalFilename());
            Files.copy(file.getInputStream(), filePath);
            return new ResponseEntity<>(filePath.toUri().toString(), HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
