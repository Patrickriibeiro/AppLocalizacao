package io.github.Patrickriibeiro.localizacao.domain.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import io.github.Patrickriibeiro.localizacao.domain.entity.Cidade;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade,Long> {
	
	List<Cidade> findByNome(String nome);
	
	List<Cidade> findByHabitantes(Long habitantes);
	
	List<Cidade> findByNomeStartingWith(String nome);
	
	List<Cidade> findByNomeEndingWith(String nome);
	
	List<Cidade> findByNomeContaining(String nome);
	
	List<Cidade> findByNomeLike(String nome);
	
	@Query("select c from Cidade c where lower(c.nome) like lower(?1)") //upper()
	List<Cidade> findByNomeLikeIgnoreCaseSort(String nome,Sort sort);
	
	@Query("select c from Cidade c where lower(c.nome) like lower(?1)") //upper()
	Page<Cidade> findByNomeLikeIgnoreCasePage(String nome,Pageable pageable);
	
	List<Cidade> findByHabitantesLessThan(Long habitantes);
	
	List<Cidade> findByHabitantesGreaterThan(Long habitantes);
	
	List<Cidade> findByHabitantesLessThanEqual(Long habitantes);
	
	List<Cidade> findByHabitantesLessThanAndNomeLike(Long habitantes,String nome);
}
