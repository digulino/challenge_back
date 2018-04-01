package com.challenge.back;

import com.challenge.back.dao.Pessoa;
import com.challenge.back.repository.PessoaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

@Component
public class PessoaCommandLineRunner implements CommandLineRunner {

    private final PessoaRepository repository;

    public PessoaCommandLineRunner(PessoaRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) throws Exception {
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

        repository.save(new Pessoa("João", dateFormat.parse("02-08-1990")));
        repository.save(new Pessoa("Maria", dateFormat.parse("05-10-1995")));
        repository.findAll().forEach(System.out::println);
    }
}
