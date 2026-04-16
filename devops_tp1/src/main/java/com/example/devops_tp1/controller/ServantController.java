package com.example.devops_tp1.controller;

import com.example.devops_tp1.model.Servant;
import com.example.devops_tp1.service.ServantService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/servants")
public class ServantController {

    private final ServantService servantService;

    public ServantController(ServantService servantService) {
        this.servantService = servantService;
    }

    @GetMapping
    public List<Servant> getAllServants() {
        return servantService.getAllServants();
    }

    @GetMapping("/{name}")
    public ResponseEntity<Servant> getServantByName(@PathVariable String name) {
        Optional<Servant> servant = servantService.getServantByName(name);
        return servant.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Servant> createServant(@RequestBody Servant servant) {
        Servant created = servantService.addServant(servant);
        return ResponseEntity.ok(created);
    }
}
