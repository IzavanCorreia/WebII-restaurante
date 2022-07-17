package br.recife.ifpe.restaurante.repository;

import java.util.List;

/**
 *
 * @author Izavan
 */
public interface GenericRepository<T, I> {
    
    public void create(T t);
    public void update(T t);
    public T read(I i);
    public void delete(I i);
    public List<T> readAll();
    
}