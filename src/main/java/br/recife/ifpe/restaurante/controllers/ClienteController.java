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
import br.recife.ifpe.restaurante.entities.Pagamento;
import br.recife.ifpe.restaurante.entities.Pedido;
import br.recife.ifpe.restaurante.entities.Prato;

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
	
	
	@RequestMapping("/cliente/telaLogin")
	public String telaLogin(Model m) {
		
		
		return "cliente/login";
	}
	
	
	@RequestMapping("/cliente/login")
	public String login (Model m, String email, String senha) {
	
		Cliente teste = new Cliente();
	    teste = ClienteRepository.Login(email, senha);
	
	if(teste != null) {	
		m.addAttribute("msg2","Login com sucesso!");
		
		List<Cliente> clientes = Facade.getCurrentInstance().readAllCliente();
		m.addAttribute("cliente", clientes);
		
		List<Prato> pratos = Facade.getCurrentInstance().readAllPrato();
		m.addAttribute("prato", pratos);
		
		return "cliente/inicio";	
	}
	
	else {
	m.addAttribute("msg3","E-mail ou senha incorretos!");
	return "/cliente/login";
	}
	
}		
	
	@RequestMapping("/cliente/inicio")
	public String telaSelecionaPrato(Model m, Cliente clientes) {
		
			
		return "cliente/pedido";
		
	}	
	
	@RequestMapping("/cliente/pedidohelp")
	public String fazPedido(Model m, Prato c) {
		
		Pedido p = new Pedido();
		p.setPrato(Facade.getCurrentInstance().readPrato(c.getId()));
		
		List <Pagamento> pagamentos = Facade.getCurrentInstance().readAllPagamento();
		m.addAttribute("pagamento", pagamentos);
		
		List <Prato> pratos = Facade.getCurrentInstance().readAllPrato();
		m.addAttribute("prato", pratos);
		
		List <Cliente> clientes = Facade.getCurrentInstance().readAllCliente();
		m.addAttribute("cliente", clientes);
		
		m.addAttribute("pedido", p);
		
	return "cliente/pedido";
	}
	
	@RequestMapping("/cliente/pedido")
	public String helpPedido(Model m, Pedido p) {
		
		m.addAttribute("pedido", p);
		
	return "cliente/cadastroPedidos";
	}
	
	@RequestMapping("/cliente/cadastroPedidos")
	public String fazPedido(Model m, Pedido p, Pagamento x, Prato c, int id2) {
		
		
		p.setPrato(Facade.getCurrentInstance().readPrato(id2));
		p.setPagamento(Facade.getCurrentInstance().readPagamento(x.getId()));
		Facade.getCurrentInstance().create(p);
		m.addAttribute("msg6","Pedido realizado sucesso!");
		
		List <Pedido> pedidos = Facade.getCurrentInstance().readAllPedido();
		m.addAttribute("pedido", pedidos);
		
	return "cliente/visualizarPedidos";
	}	
	
	@RequestMapping("/cliente/visualizarPedidos")
	public String visualizarPedidos(Model m) {
		
		List <Pedido> pedidos = Facade.getCurrentInstance().readAllPedido();
		m.addAttribute("pedido", pedidos);
		
	return "cliente/visualizarPedidos";
	}	
	
}
