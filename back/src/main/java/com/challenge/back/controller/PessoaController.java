package com.challenge.back.controller;

import com.challenge.back.dao.Pessoa;
import com.challenge.back.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class PessoaController {

    @Autowired
    private PessoaService service;

    @GetMapping("/pessoas")
    public List<Pessoa> getPessoas() {
        return service.getAll();
    }

    @GetMapping("/pessoa/{id}")
    public Optional<Pessoa> getPessoa(@PathVariable Long id) {
        return service.findById(id);
    }

    @DeleteMapping("/pessoa/{id}")
    public boolean deletePessoa(@PathVariable Long id) {
        service.delete(id);
        return true;
    }

    @PostMapping("/pessoa")
    public Pessoa createOrUpdatePessoa(@RequestBody Pessoa pessoa) {
        Pessoa _pessoa = service.createOrUpdate(pessoa);
        System.out.println(_pessoa);
        return _pessoa;
    }
}

