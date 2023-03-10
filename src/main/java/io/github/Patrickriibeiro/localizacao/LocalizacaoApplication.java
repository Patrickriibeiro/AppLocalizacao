package io.github.Patrickriibeiro.localizacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import io.github.Patrickriibeiro.localizacao.domain.entity.Cidade;
import io.github.Patrickriibeiro.localizacao.domain.repository.CidadeRepository;
import jakarta.transaction.Transactional;

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
	}

	@Transactional
	private void salvarCidade() {
		var cidade = new Cidade(1L, "São Paulo", 12396372L);
		cidadeRepository.save(cidade);
	}

	void listarCidades() {
		cidadeRepository.findAll().forEach(System.out::println);
	}

}
