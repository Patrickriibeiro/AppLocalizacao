package io.github.Patrickriibeiro.localizacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.Transactional;

import io.github.Patrickriibeiro.localizacao.domain.entity.Cidade;
import io.github.Patrickriibeiro.localizacao.domain.repository.CidadeRepository;

@ComponentScan(basePackages =  "io.github.Patrickriibeiro.localizacao")
@SpringBootApplication
public class LocalizacaoApplication implements CommandLineRunner {

	@Autowired
	private CidadeRepository cidadeRepository;

	public static void main(String[] args) {
		SpringApplication.run(LocalizacaoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		listarCidades();
		listarCidadesPorNome();
	}

	@Transactional
	private void salvarCidade() {
		var cidade = new Cidade(1L, "São Paulo", 12396372L);
		cidadeRepository.save(cidade);
	}

	void listarCidades() {
		cidadeRepository.findAll().forEach(System.out::println);
	}
	
	void listarCidadesPorNome() {
		cidadeRepository.findByNomeContaining("Rio").forEach(System.out::println);
	}
	
	void listarCidadesPorHabitantes() {
		cidadeRepository.findByHabitantes(1000000L).forEach(System.out::println);
	}
	
	

}