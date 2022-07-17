package br.recife.ifpe.restaurante.repository;

import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.recife.ifpe.restaurante.entities.Cliente;

public final class ClienteRepository implements GenericRepository<Cliente, String> {
	
 protected ClienteRepository(){
		 
	 }

	@Override
	public void create(Cliente t) {
		
		String sql = "insert into cliente(cpf,nome,telefone,email,senha) values(?,?,?,?,?)";
          
        try {
            
            PreparedStatement pstm = br.recife.ifpe.restaurante.dao.ConnectionManager.getCurrentConnection().prepareStatement(sql);
            pstm.setString(1, t.getCpf());
            pstm.setString(2, t.getNome());
            pstm.setString(3, t.getTelefone());
            pstm.setString(4, t.getEmail());
            pstm.setString(5, t.getSenha());         
            
            pstm.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(ClienteRepository.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClienteRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    
	}

	@Override
	public void update(Cliente t) {
		
		 String sql = "update cliente set nome = ? , telefone = ? , email = ? , senha = ?"
	                + "where cpf = ? ";

	        try {
	            
	            PreparedStatement pstm = br.recife.ifpe.restaurante.dao.ConnectionManager.getCurrentConnection().prepareStatement(sql);
	            
	            pstm.setString(1, t.getNome());
	            pstm.setString(2, t.getTelefone());
	            pstm.setString(3, t.getEmail());
	            pstm.setString(4, t.getSenha());  
	            pstm.setString(5, t.getCpf());  
	            
	            pstm.execute();
	            
	        } catch (SQLException ex) {
	            Logger.getLogger(ClienteRepository.class.getName()).log(Level.SEVERE, null, ex);
	        } catch (ClassNotFoundException ex) {
	            Logger.getLogger(ClienteRepository.class.getName()).log(Level.SEVERE, null, ex);
	        }
	}

	@Override
	public Cliente read(String i) {
		 String sql = "select * from cliente where cpf=?";
	        
	        try {
	            
	            PreparedStatement pstm = br.recife.ifpe.restaurante.dao.ConnectionManager.getCurrentConnection().prepareStatement(sql);
	            
	            pstm.setString(1, i);
	            
	            ResultSet result = pstm.executeQuery();
	            
	            if(result.next()){
	            	Cliente c =  new Cliente();
	                c.setCpf(i);
	                c.setNome(result.getString("nome"));
	                c.setTelefone(result.getString("telefone"));
	                c.setEmail(result.getString("email"));
	                c.setSenha(result.getString("senha"));
	                
	                return c;
	            }
	            
	            
	            
	        } catch (SQLException ex) {
	            Logger.getLogger(ClienteRepository.class.getName()).log(Level.SEVERE, null, ex);
	        } catch (ClassNotFoundException ex) {
	            Logger.getLogger(ClienteRepository.class.getName()).log(Level.SEVERE, null, ex);
	        }
	        
	        return null;
	}

	@Override
	public void delete(String i) {
		 String sql = "delete from cliente where cpf = ?";
	        
	        try {
	            
	            PreparedStatement pstm = br.recife.ifpe.restaurante.dao.ConnectionManager.getCurrentConnection().prepareStatement(sql);
	            pstm.setString(1, i);      
	            pstm.execute();
	            
	        } catch (SQLException ex) {
	            Logger.getLogger(ClienteRepository.class.getName()).log(Level.SEVERE, null, ex);
	        } catch (ClassNotFoundException ex) {
	            Logger.getLogger(ClienteRepository.class.getName()).log(Level.SEVERE, null, ex);
	        }
	        
	}

	@Override
	public List<Cliente> readAll() {
		String sql = "select * from cliente";
        
        List<Cliente> clientes = new ArrayList<>();
        
        try {
            
            PreparedStatement pstm = br.recife.ifpe.restaurante.dao.ConnectionManager.getCurrentConnection().prepareStatement(sql);
            
            ResultSet result = pstm.executeQuery();
            
            
           while(result.next()){
        	   Cliente c =  new Cliente();
                c.setCpf(result.getString("cpf"));
                c.setNome(result.getString("nome"));
                c.setTelefone(result.getString("telefone"));
                c.setEmail(result.getString("email"));
                c.setSenha(result.getString("Senha"));
                
                clientes.add(c);
            }
                    
            
        } catch (SQLException ex) {
            Logger.getLogger(ClienteRepository.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClienteRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return clientes;
            
	}
	
	
	public static Cliente Login(String email, String senha) {
		 String sql = "select * from cliente where email = ? and senha = ?";
	        
	        try {
	            
	            PreparedStatement pstm = br.recife.ifpe.restaurante.dao.ConnectionManager.getCurrentConnection().prepareStatement(sql);
	            
	            pstm.setString(1, email);
	            pstm.setString(2, senha);
	            
	            ResultSet result = pstm.executeQuery();
	            
	            if(result.next()){
	            	Cliente c =  new Cliente();
	                c.setEmail(result.getString("email"));
	                c.setSenha(result.getString("senha"));                
	                return c;
	               
	            }
	                      
	          
	        } catch (SQLException ex) {
	            Logger.getLogger(ClienteRepository.class.getName()).log(Level.SEVERE, null, ex);
	        } catch (ClassNotFoundException ex) {
	            Logger.getLogger(ClienteRepository.class.getName()).log(Level.SEVERE, null, ex);
	        }
	        
	        return null;		
	}
	
	 
}
