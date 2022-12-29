package io.github.Patrickriibeiro.localizacao.domain.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import io.github.Patrickriibeiro.localizacao.domain.entity.Cidade;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade,Long>, JpaSpecificationExecutor<Cidade> {
	
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
	
	@Query(value = "select * from tb_cidade where nome like :nome",nativeQuery = true) //upper()
	Page<Map<String,Object>> findByNomeLikeIgnoreCasePageMap(@Param(value = "nome")String nome,Pageable pageable);
	
	List<Cidade> findByHabitantesLessThan(Long habitantes);
	
	List<Cidade> findByHabitantesGreaterThan(Long habitantes);
	
	List<Cidade> findByHabitantesLessThanEqual(Long habitantes);
	
	List<Cidade> findByHabitantesLessThanAndNomeLike(Long habitantes,String nome);
}
