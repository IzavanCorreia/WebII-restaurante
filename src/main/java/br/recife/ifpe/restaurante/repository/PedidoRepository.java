package br.recife.ifpe.restaurante.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.recife.ifpe.restaurante.entities.Cliente;
import br.recife.ifpe.restaurante.entities.Pagamento;
import br.recife.ifpe.restaurante.entities.Pedido;
import br.recife.ifpe.restaurante.entities.Prato;

public final class PedidoRepository implements GenericRepository<Pedido, Integer>{

	protected PedidoRepository() {
		
	}
	
	@Override
	public void create(Pedido t) {
		String sql = "insert into pedido(observacao, id_pagamento, id_prato"
                + ") values (?,?,?)";
        
        try {
            PreparedStatement pstm = br.recife.ifpe.restaurante.dao.ConnectionManager.getCurrentConnection()
                    .prepareStatement(sql);
            
            pstm.setString(1, t.getObservacao());
            pstm.setInt(2, t.getPagamento().getId());
            pstm.setInt(3, t.getPrato().getId());
          
            pstm.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(PedidoRepository.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PedidoRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        
	}

	@Override
	public void update(Pedido t) {
		String sql = "update pedido set observacao = ? where id = ? ";
        
        try {
            PreparedStatement pstm = br.recife.ifpe.restaurante.dao.ConnectionManager.getCurrentConnection()
                    .prepareStatement(sql);
            
            pstm.setLong(1, t.getDatahora());
            pstm.setDouble(2, t.getPreco());
            pstm.setString(3, t.getObservacao());
            
            pstm.setInt(4, t.getId());
            
            pstm.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(PedidoRepository.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PedidoRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
	}

	@Override
	public Pedido read(Integer i) {
	
		String sql = "select * from pedido as v join cliente as c join prato as m join pagamento as p"
                + "on (v.cpf_cliente = c.cpf and v.id_prato = m.id and v.id_pagamento = p.id) where v.id = ?";
        
        try {
            PreparedStatement pstm = br.recife.ifpe.restaurante.dao.ConnectionManager.getCurrentConnection()
                    .prepareStatement(sql);
            
            pstm.setInt(1, i);
            
            ResultSet r = pstm.executeQuery();
            
            if(r.next()){
                
                Cliente c = new Cliente();
                c.setCpf(r.getString("id"));
                c.setNome(r.getString("nome"));
                c.setTelefone(r.getString("telefone"));
                c.setEmail(r.getString("email"));
                c.setSenha(r.getString("senha"));
                
                Prato m = new Prato();
                m.setId(r.getInt("id"));
                m.setNome(r.getString("nome"));
                m.setDescricao(r.getString("descricao"));
                m.setPreco(r.getDouble("preco"));
                
                Pagamento p = new Pagamento();
                m.setId(r.getInt("id"));
                m.setDescricao(r.getString("descricao"));
                
                Pedido v = new Pedido();
                
                v.setId(r.getInt("id"));
                v.setDatahora(r.getLong("datahora"));
                v.setPreco(r.getDouble("preco"));
                v.setObservacao(r.getString("observacao"));
                
                v.setCliente(c);
                v.setPrato(m);
                v.setPagamento(p);
                
                return v;
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(PedidoRepository.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PedidoRepository.class.getName()).log(Level.SEVERE, null, ex);
        }

		return null;
	}

	@Override
	public void delete(Integer i) {
		 String sql = "delete from pedido where id = ?";
	        
	        try {
	            
	            PreparedStatement pstm = br.recife.ifpe.restaurante.dao.ConnectionManager.getCurrentConnection().prepareStatement(sql);
	            pstm.setInt(1, i);
	            
	            pstm.execute();
	            
	        } catch (SQLException ex) {
	            Logger.getLogger(PedidoRepository.class.getName()).log(Level.SEVERE, null, ex);
	        } catch (ClassNotFoundException ex) {
	            Logger.getLogger(PedidoRepository.class.getName()).log(Level.SEVERE, null, ex);
	        }
		
	}

	@Override
	public List<Pedido> readAll() {
	
        String sql = "select * from pedido";
        
        List<Pedido> pedidos = new ArrayList<>();
        
        try {
            
            PreparedStatement pstm = br.recife.ifpe.restaurante.dao.ConnectionManager.getCurrentConnection()
                    .prepareStatement(sql);
            
            ResultSet r = pstm.executeQuery();
            
            while(r.next()){
                
                Pedido v = new Pedido();
                
                v.setId(r.getInt("id"));
                v.setDatahora(r.getLong("datahora"));          
                v.setObservacao(r.getString("observacao"));
   
                ClienteRepository cliente = new ClienteRepository();           
                Cliente c = cliente.read(r.getString("id_cliente"));            
                v.setCliente(c);
                

                PagamentoRepository pagamento = new PagamentoRepository();
                Pagamento p = pagamento.read(r.getInt("id_pagamento")); 
                v.setPagamento(p);
                

                PratoRepository prato = new PratoRepository();
                Prato m = prato.read(r.getInt("id_prato")); 
                v.setPrato(m);
                
                         
                pedidos.add(v);
                
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(PedidoRepository.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PedidoRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return pedidos;
    }
    
	
}
