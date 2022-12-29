package io.github.Patrickriibeiro.localizacao.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.github.Patrickriibeiro.localizacao.domain.entity.Cidade;
import io.github.Patrickriibeiro.localizacao.domain.repository.CidadeRepository;

@Service
public class CidadeService {

	private CidadeRepository repository;

	public CidadeService(CidadeRepository repository) {
		this.repository = repository;
	}

	@Transactional
	private void salvarCidade() {
		var cidade = new Cidade(1L, "São Paulo", 12396372L);
		repository.save(cidade);
	}

	public void listarCidades() {
		repository.findAll().forEach(System.out::println);
	}

	public void listarCidadesPorNome() {
		repository.findByNomeContaining("Rio").forEach(System.out::println);
	}

	public void listarCidadesPorNomeSorted() {
		repository.findByNomeLikeIgnoreCaseSort("Rio", Sort.by("habitantes")).forEach(System.out::println);
	}

	public void listarCidadesPorNomePage() {
		Pageable pageable = PageRequest.of(0, 2);
		repository.findByNomeLikeIgnoreCasePage("Rio", pageable).forEach(System.out::println);
	}

	public void listarCidadesPorNomePageMap() {
		Pageable pageable = PageRequest.of(0, 2);
		repository.findByNomeLikeIgnoreCasePageMap("Rio", pageable).forEach(p -> p.get("nome").toString());
	}

	public void listarCidadesPorHabitantes() {
		repository.findByHabitantes(1000000L).forEach(System.out::println);
	}

	public void listarCidadesMenorProQuantidadeDeHabitantes() {
		repository.findByHabitantesLessThan(6000000L).forEach(System.out::println);
		;
	}

	public void listarCidadesMaiorProQuantidadeDeHabitantes() {
		repository.findByHabitantesGreaterThan(6000000L).forEach(System.out::println);
		;
	}

	public List<Cidade> filtroDinamico(Cidade cidade) {
		ExampleMatcher matcher = ExampleMatcher.matching().withIgnoreCase("nome")
				.withStringMatcher(ExampleMatcher.StringMatcher.STARTING);

		Example<Cidade> example = Example.of(cidade, matcher);
		return repository.findAll(example);
	}
}
