package br.recife.ifpe.restaurante.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.recife.ifpe.restaurante.entities.Prato;

public final class PratoRepository implements GenericRepository<Prato, Integer>{
	
	protected PratoRepository() {
		
	}

	@Override
	public void create(Prato t) {
		String sql = "insert into prato(id, nome, descricao, preco) values (?,?,?,?)";
        
        try {
            PreparedStatement pstm = br.recife.ifpe.restaurante.dao.ConnectionManager.getCurrentConnection()
                    .prepareStatement(sql);
            
            pstm.setInt(1, t.getId());
            pstm.setString(2, t.getNome());
            pstm.setString(3, t.getDescricao());
            pstm.setDouble(4, t.getPreco());
            
            pstm.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(PratoRepository.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PratoRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
	}

	@Override
	public void update(Prato t) {
String sql = "update prato set nome = ?, descricao = ?, preco = ? where id = ?";
        
        try {
            PreparedStatement pstm = br.recife.ifpe.restaurante.dao.ConnectionManager.getCurrentConnection()
                    .prepareStatement(sql);
            
            pstm.setString(1, t.getNome());
            pstm.setString(2, t.getDescricao());
            pstm.setDouble(3, t.getPreco());
            pstm.setInt(4, t.getId());
            
            pstm.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(PratoRepository.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PratoRepository.class.getName()).log(Level.SEVERE, null, ex);
        }	
		
	}

	@Override
	public Prato read(Integer i) {
		String sql = "select * from prato where id = ?";
        
        try {
            PreparedStatement pstm = br.recife.ifpe.restaurante.dao.ConnectionManager.getCurrentConnection()
                    .prepareStatement(sql);
            
            pstm.setInt(1, i);
            
            ResultSet r = pstm.executeQuery();
            
            if(r.next()){
           	                
                Prato m = new Prato();
                
                m.setId(r.getInt("id"));
                m.setNome(r.getString("nome"));
                m.setDescricao(r.getString("descricao"));
                m.setPreco(r.getDouble("preco"));
                               
                return m;
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(PratoRepository.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PratoRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
		return null;
	}

	@Override
	public void delete(Integer i) {
		 String sql = "delete from prato where id = ?";
	        
	        try {
	            
	            PreparedStatement pstm = br.recife.ifpe.restaurante.dao.ConnectionManager.getCurrentConnection().prepareStatement(sql);
	            pstm.setInt(1, i);      
	            pstm.execute();
	            
	        } catch (SQLException ex) {
	            Logger.getLogger(PratoRepository.class.getName()).log(Level.SEVERE, null, ex);
	        } catch (ClassNotFoundException ex) {
	            Logger.getLogger(PratoRepository.class.getName()).log(Level.SEVERE, null, ex);
	        }
	}

	@Override
	public List<Prato> readAll() {
		 String sql = "select * from prato";
	        
	        List<Prato> pratos = new ArrayList<>();
	        
	        try {
	            
	            PreparedStatement pstm = br.recife.ifpe.restaurante.dao.ConnectionManager.getCurrentConnection()
	                    .prepareStatement(sql);
	            
	            ResultSet r = pstm.executeQuery();
	            
	            while(r.next()){
	                
	                Prato m = new Prato();

	                m.setId(r.getInt("id"));
	                m.setNome(r.getString("nome"));
	                m.setDescricao(r.getString("descricao"));
	                m.setPreco(r.getDouble("preco"));
	                
	                pratos.add(m);	                
	            }
	            
	        } catch (SQLException ex) {
	            Logger.getLogger(PratoRepository.class.getName()).log(Level.SEVERE, null, ex);
	        } catch (ClassNotFoundException ex) {
	            Logger.getLogger(PratoRepository.class.getName()).log(Level.SEVERE, null, ex);
	        }
	        
	        
	        return pratos;
	}

}
