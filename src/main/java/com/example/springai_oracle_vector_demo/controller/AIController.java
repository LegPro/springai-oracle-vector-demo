package com.example.springai_oracle_vector_demo.controller;

import com.example.springai_oracle_vector_demo.service.OracleAIVectorService;
import org.springframework.ai.document.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class AIController {

    @Autowired
    OracleAIVectorService oracleAIVectorService;

    @GetMapping("/load")
    public void loadDocuments() {
        oracleAIVectorService.getDocuments();
    }

    @GetMapping("/search")
    public List<String> searchDocuments(@RequestParam(value = "query", defaultValue = "The world is big") String query) {
        List<Document> results = oracleAIVectorService.searchDocuments(query);
        List<String> contents = results.stream()
                .map(Document::getContent)
                .collect(Collectors.toList());
        return contents;
    }
}
