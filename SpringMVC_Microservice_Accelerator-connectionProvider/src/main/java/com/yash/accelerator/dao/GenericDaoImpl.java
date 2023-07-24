package com.yash.accelerator.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public abstract class GenericDaoImpl<E, K extends Serializable> implements GenericDao<E, K> {
	@Autowired
	SessionFactory sessionFactory;
	
	protected Class<? extends E> type;

	/**
	 * By defining this class as abstract, we prevent Spring from creating 
	 * instance of this class If not defined as abstract, 
	 * getClass().getGenericSuperClass() would return Object. There would be 
	 * exception because Object class does not hava constructor with parameters.
	 */
	@SuppressWarnings("unchecked")
	public GenericDaoImpl() {
		Type t = getClass().getGenericSuperclass();
		ParameterizedType pt = (ParameterizedType) t;
		type = (Class<? extends E>) pt.getActualTypeArguments()[0];
	}

	protected Session currentSession() {
		return sessionFactory.getCurrentSession();
	}

	public void add(E entity) {
		currentSession().save(entity);
	}

	public void saveOrUpdate(E entity) {
		currentSession().saveOrUpdate(entity);
	}

	public void update(E entity) {
		currentSession().saveOrUpdate(entity);
	}

	public void remove(E entity) {
		currentSession().delete(entity);
	}

	@SuppressWarnings("unchecked")
	public E find(K key) {
		return (E) currentSession().get(type, key);
	}

	@SuppressWarnings("unchecked")
	public List<E> getAll() {
		return currentSession().createCriteria(type).list();
	}

}

