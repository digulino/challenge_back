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

    public void create(Pessoa pessoa) {
        repository.save(pessoa);
    }

    public void update(Pessoa updatedPessoa) {
        Pessoa pessoaToBeUpdated = repository.findById(updatedPessoa.getId()).get();
        pessoaToBeUpdated.setNome(updatedPessoa.getNome());
        pessoaToBeUpdated.setDtNascimento(updatedPessoa.getDtNascimento());
        repository.save(pessoaToBeUpdated);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }


}