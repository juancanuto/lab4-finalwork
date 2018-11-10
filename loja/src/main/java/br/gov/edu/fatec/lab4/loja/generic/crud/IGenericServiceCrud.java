package br.gov.edu.fatec.lab4.loja.generic.crud;

import java.util.List;
import java.util.Optional;

public interface IGenericServiceCrud<T,I> {	
	public boolean save(T entity);
	public T remove(T entity);
	public boolean update(T entity,T entityUpdate);
	public Optional<T> findById(I id);
	public List<T> findAll();
};
