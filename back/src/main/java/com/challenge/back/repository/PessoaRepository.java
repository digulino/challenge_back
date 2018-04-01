package com.challenge.back.repository;

import com.challenge.back.dao.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
