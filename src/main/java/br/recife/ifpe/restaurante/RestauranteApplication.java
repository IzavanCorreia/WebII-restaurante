package br.recife.ifpe.restaurante;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.recife.ifpe.restaurante.entities.Adm;
import br.recife.ifpe.restaurante.entities.Cliente;
import br.recife.ifpe.restaurante.entities.Pagamento;
import br.recife.ifpe.restaurante.entities.Pedido;
import br.recife.ifpe.restaurante.entities.Prato;
import br.recife.ifpe.restaurante.repository.Facade;

@SpringBootApplication
public class RestauranteApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestauranteApplication.class, args);
		
	}

}
