package fr.formation.dal;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import fr.formation.entity.Styles;

public class StylesDaoImpl implements StylesDao {

	@Override
	public void add(Styles s) throws Exception{
		EntityManager em = DAOUtil.getEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		try {
			em.persist(s);
			et.commit();
		} catch (Exception e) {
			et.rollback();
			throw e;
		}
		finally {
			em.close();
		}
	}

	@Override
	public void delete(Styles s) throws Exception{
		EntityManager em = DAOUtil.getEntityManager();
		EntityTransaction et = em.getTransaction();
		s = em.find(Styles.class, s.getId());
		et.begin();
		try {
			em.remove(s);
			et.commit();
		} catch (Exception e) {
			et.rollback();
			throw e;
		}
		finally {
			em.close();
		}
	}

	@Override
	public  void update(Styles s) throws Exception{
		EntityManager em = DAOUtil.getEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		try {
			em.merge(s);
			et.commit();
		} catch (Exception e) {
			et.rollback();
			throw e;
		}
		finally {
			em.close();
		}
	}
	


	@Override
	public Styles findById(int id){
		EntityManager em = DAOUtil.getEntityManager();
		Styles s = em.find(Styles.class, id);
		em.close();
		return s;
	}
	
	@Override
	public  List<Styles> findAll(){
		String req = "select Object(s) from Styles s";
		EntityManager em = DAOUtil.getEntityManager();
		List<Styles> liste = em
				.createQuery(req, Styles.class)
				.getResultList();
		em.close();
		
		return liste;
	}
}
