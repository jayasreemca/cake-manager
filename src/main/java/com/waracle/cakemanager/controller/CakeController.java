package com.waracle.cakemanager.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.waracle.cakemanager.domain.Cake;
import com.waracle.cakemanager.service.CakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("/cakes")
public class CakeController {
    private CakeService cakeService;

    @Autowired
    public CakeController(CakeService cakeService) {
        this.cakeService = cakeService;
    }

    @GetMapping("/list")
    public Iterable<Cake> list() {
        return cakeService.list();
    }

    @PostMapping("")
    public Cake add(@RequestBody Cake cake){
        cakeService.addCake(cake);
        return cake;
    }
}
