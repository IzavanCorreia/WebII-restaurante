package br.recife.ifpe.restaurante.repository;


import java.util.List;

import br.recife.ifpe.restaurante.entities.Adm;
import br.recife.ifpe.restaurante.entities.Cliente;
import br.recife.ifpe.restaurante.entities.Pagamento;
import br.recife.ifpe.restaurante.entities.Pedido;
import br.recife.ifpe.restaurante.entities.Prato;

public class Facade {
	
private static Facade myself = null;
    
    private GenericRepository<Cliente, String> rCliente = null; 
    private GenericRepository<Adm, String> rAdm = null;
    private GenericRepository<Pedido, Integer> rPedidos = null;
    private GenericRepository<Prato, Integer> rPratos = null;
    private GenericRepository<Pagamento, Integer> rPagamentos = null;
    
    
    private Facade(){
        
        this.rCliente = new ClienteRepository();
        this.rAdm = new AdmRepository();
        this.rPedidos = new PedidoRepository();
        this.rPratos = new PratoRepository();
        this.rPagamentos = new PagamentoRepository();
        
    }
    
    public static Facade getCurrentInstance(){
        
        if(myself == null){
            myself = new Facade();
        }
        
        return myself;
        
    }
    public void create(Cliente c){
        this.rCliente.create(c);
    }
    
    public void update(Cliente c){
        this.rCliente.update(c);
    }
    
    public Cliente readCliente(String cpf){
    	
       return this.rCliente.read(cpf);
    }
    
    public void deleteCliente(String cpf){
        this.rCliente.delete(cpf);
    }
    
    public List<Cliente> readAllCliente(){
        return this.rCliente.readAll();
    }
    
    
    public void create(Adm a){
        this.rAdm.create(a);
    }
    
    public void update(Adm a){
        this.rAdm.update(a);
    }
    
    public Adm readAdm(String cpf){
    	
       return this.rAdm.read(cpf);
    }
    
    public void deleteAdm(String Adm){
        this.rAdm.delete(Adm);
    }
    
    public List<Adm> readAllAdm(){
        return this.rAdm.readAll();
    }
    
    public void create(Pedido p){
        this.rPedidos.create(p);
    }
    
    public void update(Pedido p){
        this.rPedidos.update(p);
    }
    
    public Pedido readPedido(int id){
    	
       return this.rPedidos.read(id);
    }
    
    public void deletePedido(int id){
        this.rPedidos.delete(id);
    }
    
    public List<Pedido> readAllPedido(){
        return this.rPedidos.readAll();
    }
    
    public void create(Prato p){
        this.rPratos.create(p);
    }
    
    public void update(Prato p){
        this.rPratos.update(p);
    }
    
    public Prato readPrato(int id){
    	
       return this.rPratos.read(id);
    }
    
    public void deletePrato(int id){
        this.rPratos.delete(id);
    }
    
    public List<Prato> readAllPrato(){
        return this.rPratos.readAll();
    }
    
    public void create(Pagamento p){
        this.rPagamentos.create(p);
    }
    
    public void update(Pagamento p){
        this.rPagamentos.update(p);
    }
    
    public Pagamento readPagamento(int id){
    	
       return this.rPagamentos.read(id);
    }
    
    public void deletePagamento(int id){
        this.rPagamentos.delete(id);
    }
    
    public List<Pagamento> readAllPagamento(){
        return this.rPagamentos.readAll();
    }
}
