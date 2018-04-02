package com.challenge.back.service;

import com.challenge.back.dao.Pessoa;
import com.challenge.back.repository.PessoaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    private final PessoaRepository repository;

    public PessoaService(PessoaRepository repository) {
        this.repository = repository;
    }

    public Optional<Pessoa> findById(Long id) {
        return repository.findById(id);
    }

    public List<Pessoa> getAll() {
        return repository.findAll();
    }

    public Pessoa createOrUpdate(Pessoa pessoa) {
        if (pessoa.getNome() == null) {
            throw new IllegalArgumentException("Nome deve ser informado.");
        } else if (pessoa.getNome().length() < 3) {
            throw new IllegalArgumentException("Nome deve conter pelo menos 3 caracteres.");
        }

        if (pessoa.getDtNascimento() == null) {
            throw new IllegalArgumentException("Dt. Nascimento deve ser informada.");
        }

        return repository.save(pessoa);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }


}