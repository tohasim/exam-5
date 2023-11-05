package com.example.exam5syncandasync.api;

import com.example.exam5syncandasync.dtos.Response;
import com.example.exam5syncandasync.service.NameProbabilityService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NameProbabilityController {

    NameProbabilityService service;

    public NameProbabilityController(NameProbabilityService service) {
        this.service = service;
    }

    @GetMapping("")
    public Response getProbabilitiesFromName(@RequestParam String name){
        return service.getProbabilities(name);
    }
}
