package com.challenge.back.controller;

import com.challenge.back.dao.Pessoa;
import com.challenge.back.repository.PessoaRepository;
import com.challenge.back.service.PessoaService;
import com.challenge.back.util.ConversionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class PessoaController {

    @Autowired
    private PessoaRepository repository;

    @Autowired
    private PessoaService service;

    @GetMapping("/pessoa/list")
    public Collection<Map<String, String>> list() {
        return repository
                .findAll()
                .stream()
                .map(ConversionUtils::genericToMap)
                .collect(Collectors.toList());
    }

    @GetMapping("/pessoas")
    public List<Pessoa> getPessoas() {
        return repository.findAll();
    }

    @GetMapping("/pessoa/{id}")
    public Optional<Pessoa> getPessoa(@PathVariable Long id) {
        return repository.findById(id);
    }

    @DeleteMapping("/pessoa/{id}")
    public boolean deletePessoa(@PathVariable Long id) {
        repository.deleteById(id);
        return true;
    }

    @PostMapping("/pessoa")
    public Pessoa createPessoa(@RequestBody Pessoa pessoa) {
        Pessoa _pessoa = repository.save(pessoa);
        System.out.println(_pessoa);
        return _pessoa;
    }

    @PutMapping("/pessoa")
    public Pessoa updatePessoa(@RequestBody Pessoa pessoa) {
        Pessoa _pessoa = repository.save(pessoa);
        System.out.println(_pessoa);
        return _pessoa;
    }
}

