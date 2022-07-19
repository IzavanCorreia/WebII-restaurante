package br.recife.ifpe.restaurante.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import br.recife.ifpe.restaurante.entities.Adm;
import br.recife.ifpe.restaurante.entities.Cliente;
import br.recife.ifpe.restaurante.entities.Pagamento;
import br.recife.ifpe.restaurante.entities.Prato;
import br.recife.ifpe.restaurante.repository.AdmRepository;
import br.recife.ifpe.restaurante.repository.Facade;

@Controller
@RequestMapping("/")
public class AdmController {
	
	@RequestMapping("/adm/telaCadastro")
	public String telaCadastro(Model m) {
		
		return "adm/cadastro";
	}
	
	@RequestMapping("/adm/cadastro")
	public String cadastro(Model m, Adm a) {
		
		Facade.getCurrentInstance().create(a);
		
		m.addAttribute("msg","Administrador cadastrado com sucesso!");
		
		return "index";
		
	}
	
	
	@RequestMapping("/adm/telaLogin")
	public String telaLogin(Model m) {
		return "adm/login";
	}
	
	
	@RequestMapping("/adm/login")
	public String login (Model m, String email, String senha) {
	
	Adm teste = AdmRepository.Login(email, senha);
	
	if(teste != null) {	
		m.addAttribute("msg2","Login com sucesso!");
		return "adm/inicio";	
	}
	
	else {
	m.addAttribute("msg3","E-mail ou senha incorretos!");
	return "/adm/login";
	}
}
	
	@RequestMapping("/adm/telaAdms")
	public String listar(Model m) {
		
		List<Adm> adms = Facade.getCurrentInstance().readAllAdm();
		
		m.addAttribute("adm", adms);
		
		return "adm/adms";
	
	}
	
	@RequestMapping("/adm/visualiza/{cpf}")
	public String visualiza(Model m, @PathVariable("cpf") String cpf) {
		
		Adm a = Facade.getCurrentInstance().readAdm(cpf);
		
		m.addAttribute("adm", a);
		
		return "adm/adm";
		
	}
	
	@RequestMapping("/adm/telaPratos")
	public String telaCadastroPratos(Model m) {
		
		return "adm/cadPratos";
	}
	
	@RequestMapping("adm/cadPratos")
	public String CadastroPratos(Model m, Prato p) {
		
		Facade.getCurrentInstance().create(p);
		
		m.addAttribute("msg4","Prato cadastrado com sucesso!");
		
		return "adm/inicio";
	}
	
	@RequestMapping("/adm/telaClientes")
	public String visualizarClientes(Model m) {
		
		List<Cliente> cliente1 = Facade.getCurrentInstance().readAllCliente();
		
		
		m.addAttribute("cliente", cliente1);
		
		return "adm/visualizarClientes";
	
	}
	
	@RequestMapping("/adm/visualizaClienteCpf/{cpf}")
	public String visualizaClienteCpf(Model m, @PathVariable("cpf") String cpf) {
		
		Cliente c = Facade.getCurrentInstance().readCliente(cpf);
		
		m.addAttribute("cliente", c);
		
		return "adm/visualizaCliente";
		
	}
	
	@RequestMapping("/adm/telaPagamentos")
	public String telaCadastroPagamentos(Model m) {
		
		return "adm/cadPagamentos";
	}
	
	@RequestMapping("adm/cadPagamentos")
	public String CadastroPagamentos(Model m, Pagamento p) {
		
		Facade.getCurrentInstance().create(p);
		
		m.addAttribute("msg5","Pagamento cadastrado com sucesso!");
		
		return "adm/inicio";
	}
	
}
