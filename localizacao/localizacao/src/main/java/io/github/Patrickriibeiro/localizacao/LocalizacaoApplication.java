package io.github.Patrickriibeiro.localizacao;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import io.github.Patrickriibeiro.localizacao.service.CidadeService;

@ComponentScan(basePackages =  "io.github.Patrickriibeiro.localizacao")
@SpringBootApplication
public class LocalizacaoApplication implements CommandLineRunner {

	@Autowired
	private CidadeService service;

	public static void main(String[] args) {
		SpringApplication.run(LocalizacaoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//service.listarCidades();
		//service.listarCidadesPorNome();
		//service.listarCidadesMenorProQuantidadeDeHabitantes();
		//service.listarCidadesMaiorProQuantidadeDeHabitantes(); 
	    //service.listarCidadesPorNomePage();
		//service.listarCidadesPorNomePageMap();
		service.listarCidadesByNomeSpec();
		System.out.println("Data : " + LocalDate.now());
	}
}