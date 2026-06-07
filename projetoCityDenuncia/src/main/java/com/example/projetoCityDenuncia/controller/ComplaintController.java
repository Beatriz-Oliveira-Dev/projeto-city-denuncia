package com.example.projetoCityDenuncia.controller;

import com.example.projetoCityDenuncia.model.Complaint;
import com.example.projetoCityDenuncia.service.ComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ComplaintController {

    @Autowired
    private ComplaintService service;

    @PostMapping("/complaints")
    @ResponseBody
    public ResponseEntity<String> save(@RequestBody Complaint complaint) {

        return service.save(complaint);
    }

    @GetMapping("/complaints")
    @ResponseBody
    public List<Complaint> list() {
        return service.list();
    }
}