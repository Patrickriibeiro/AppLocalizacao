package io.github.Patrickriibeiro.localizacao.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.github.Patrickriibeiro.localizacao.domain.entity.Cidade;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade,Long> {
	
	List<Cidade> findByNome(String nome);
	
	List<Cidade> findByHabitantes(Long habitantes);
	
	List<Cidade> findByNomeStartingWith(String nome);
	
	List<Cidade> findByNomeEndingWith(String nome);
	
	List<Cidade> findByNomeContaining(String nome);
}
