package com.motivatorapp.controller;

import com.motivatorapp.service.QoutesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QouteController {
    private final QoutesService qoutesService;

    @Autowired
    public QouteController(QoutesService qoutesService) {
        this.qoutesService = qoutesService;

    }

    @GetMapping("/quote")
    public String getQoute() {
        return qoutesService.provideQoute();
    }

    public String getQouteByName(){
        return qoutesService.provideQoute();

    }
}
