package br.recife.ifpe.restaurante.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


import br.recife.ifpe.restaurante.entities.Pagamento;

public final class PagamentoRepository implements GenericRepository<Pagamento, Integer>{
	
	protected PagamentoRepository() {
		
	}

	@Override
	public void create(Pagamento t) {
		String sql = "insert into pagamento(id, descricao) values (?,?)";
        
        try {
            PreparedStatement pstm = br.recife.ifpe.restaurante.dao.ConnectionManager.getCurrentConnection()
                    .prepareStatement(sql);
              
            pstm.setInt(1, t.getId());
            pstm.setString(2, t.getDescricao());
     
            pstm.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(PagamentoRepository.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PagamentoRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
		
	}

	@Override
	public void update(Pagamento t) {
		String sql = "update pagamento set descricao = ? where id = ?";
        
        try {
            PreparedStatement pstm = br.recife.ifpe.restaurante.dao.ConnectionManager.getCurrentConnection()
                    .prepareStatement(sql);
            
            pstm.setString(1, t.getDescricao()); 
            pstm.setInt(2, t.getId());
      
            pstm.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(PagamentoRepository.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PagamentoRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
		
	}

	@Override
	public Pagamento read(Integer i) {
		 String sql = "select * from pagamento where id = ?";
	        
	        try {
	            PreparedStatement pstm = br.recife.ifpe.restaurante.dao.ConnectionManager.getCurrentConnection()
	                    .prepareStatement(sql);
	            
	            pstm.setInt(1, i);
	            
	            ResultSet r = pstm.executeQuery();
	            
	            if(r.next()){
	           	                
	                Pagamento v = new Pagamento();
	                
	                v.setId(r.getInt("id"));
	                v.setDescricao(r.getString("descricao"));
	                               
	                return v;
	                
	            }
	            
	        } catch (SQLException ex) {
	            Logger.getLogger(PagamentoRepository.class.getName()).log(Level.SEVERE, null, ex);
	        } catch (ClassNotFoundException ex) {
	            Logger.getLogger(PagamentoRepository.class.getName()).log(Level.SEVERE, null, ex);
	        }
		return null;
	}

	@Override
	public void delete(Integer i) {
		 String sql = "delete from pagamento where id = ?";
	        
	        try {
	            
	            PreparedStatement pstm = br.recife.ifpe.restaurante.dao.ConnectionManager.getCurrentConnection().prepareStatement(sql);
	            pstm.setInt(1, i);      
	            pstm.execute();
	            
	        } catch (SQLException ex) {
	            Logger.getLogger(PagamentoRepository.class.getName()).log(Level.SEVERE, null, ex);
	        } catch (ClassNotFoundException ex) {
	            Logger.getLogger(PagamentoRepository.class.getName()).log(Level.SEVERE, null, ex);
	        }
	}

	@Override
	public List<Pagamento> readAll() {
		   String sql = "select * from pagamento";
	        
	        List<Pagamento> pagamentos = new ArrayList<>();
	        
	        try {
	            
	            PreparedStatement pstm = br.recife.ifpe.restaurante.dao.ConnectionManager.getCurrentConnection()
	                    .prepareStatement(sql);
	            
	            ResultSet r = pstm.executeQuery();
	            
	            while(r.next()){
	                
	                Pagamento v = new Pagamento();
 
	                v.setId(r.getInt("id"));
	                v.setDescricao(r.getString("descricao"));
	                
	                pagamentos.add(v);	                
	            }
	            
	        } catch (SQLException ex) {
	            Logger.getLogger(PagamentoRepository.class.getName()).log(Level.SEVERE, null, ex);
	        } catch (ClassNotFoundException ex) {
	            Logger.getLogger(PagamentoRepository.class.getName()).log(Level.SEVERE, null, ex);
	        }
	        
	        
	        return pagamentos;
	    }
	
	}


