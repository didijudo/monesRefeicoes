package br.com.mones.configuracao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

import br.com.mones.controllers.HomeController;
import br.com.mones.model.Cliente;


@SpringBootApplication
@ComponentScan(basePackageClasses={HomeController.class})
@EntityScan(basePackageClasses={Cliente.class})
public class Configuracao {

	public static void main(String[] args) {
		SpringApplication.run(Configuracao.class, args);
	}
}
