package br.recife.ifpe.restaurante.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.recife.ifpe.restaurante.repository.ClienteRepository;
import br.recife.ifpe.restaurante.repository.Facade;

import br.recife.ifpe.restaurante.entities.Cliente;

@Controller
public class ClienteController {
	

	@RequestMapping("/")
	public String index(Model m) {
		
		return "index";
		
	}
	
	@RequestMapping("/cliente/telaCadastro")
	public String telaCadastro(Model m) {
		
		return "cliente/cadastro";
	}
	
	@RequestMapping("/cliente/cadastro")
	public String cadastro(Model m, Cliente c) {
		
		Facade.getCurrentInstance().create(c);
		
		m.addAttribute("msg","Cliente cadastrado com sucesso!");
		
		return "index";
		
	}
	
	@RequestMapping("/cliente/list")
	public String listar(Model m) {
		
		List<Cliente> clientes = Facade.getCurrentInstance().readAllCliente();
		
		m.addAttribute("cliente", clientes);
		
		return "cliente/clientes";
	
	}
	
	@RequestMapping("/cliente/visualiza/{cpf}")
	public String visualiza(Model m, @PathVariable("cpf") String cpf) {
		
		Cliente c = Facade.getCurrentInstance().readCliente(cpf);
		
		m.addAttribute("cliente", c);
		
		return "cliente/cliente";
		
	}
	
	@RequestMapping("/cliente/telaLogin")
	public String telaLogin(Model m) {
		return "cliente/login";
	}
	
	
	@RequestMapping("/cliente/login")
	public String login (Model m, String email, String senha) {
	
	Cliente teste = ClienteRepository.Login(email, senha);
	
	
	if(teste != null) {	
		m.addAttribute("msg2","Login com sucesso!");
		return "cliente/inicio";	
	}
	
	else {
	m.addAttribute("msg3","E-mail ou senha incorretos!");
	return "/cliente/login";
	}
}
	
}
