package com.testApp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.testApp.entity.UserEntity;

public class UserDAO {
	public EntityManager em;

	public UserDAO() {
		try {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("cadastro");
			em = emf.createEntityManager();
		} catch (Exception exception) {

			System.out.println(exception.toString() );
		}

	}
	
	public List<UserEntity> lista() {
		Query query = null;
		try {
			query = em.createQuery("select u from UserEntity u");
			List<UserEntity> user = query.getResultList();
		} catch (Exception exception) {
			System.out.println(exception.toString());

		}
		return query.getResultList();
	}
	
	public boolean cadastraUsuario(UserEntity usuarioCadastro)  {
			try {
				
				em.getTransaction().begin();
				System.out.println("Salvando a pessoa.");
				if (usuarioCadastro.getId() == null) {
					em.persist(usuarioCadastro);
				} else {
					usuarioCadastro = em.merge(usuarioCadastro);
				}
				em.getTransaction().commit();
			} finally {
				em.close();
			}
		
		return true;
	}
	
	public boolean deletar(UserEntity usuarioCadastro) {

		boolean ok = true;

	   try {
			em.getTransaction().begin();
			System.out.println("deletando a pessoa.");
			usuarioCadastro = em.find(UserEntity.class, usuarioCadastro.getId());
			em.remove(usuarioCadastro);
			em.getTransaction().commit();
		} catch (Exception e) {
			ok = false;
		} finally {
			em.close();
		}

		return ok;
	}	
	 

}
