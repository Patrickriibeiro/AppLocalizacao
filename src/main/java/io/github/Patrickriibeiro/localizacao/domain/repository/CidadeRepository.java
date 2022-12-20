package io.github.Patrickriibeiro.localizacao.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.github.Patrickriibeiro.localizacao.domain.entity.Cidade;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade,Long> {

}
