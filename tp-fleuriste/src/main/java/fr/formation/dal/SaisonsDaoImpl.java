package fr.formation.dal;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import fr.formation.entity.Saisons;

public class SaisonsDaoImpl implements SaisonsDao {

	@Override
	public void add(Saisons ss) throws Exception{
		EntityManager em = DAOUtil.getEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		try {
			em.persist(ss);
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
	public void delete(Saisons ss) throws Exception{
		EntityManager em = DAOUtil.getEntityManager();
		EntityTransaction et = em.getTransaction();
		ss = em.find(Saisons.class, ss.getId());
		et.begin();
		try {
			em.remove(ss);
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
	public  void update(Saisons ss) throws Exception{
		EntityManager em = DAOUtil.getEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		try {
			em.merge(ss);
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
	public Saisons findById(int id){
		EntityManager em = DAOUtil.getEntityManager();
		Saisons ss = em.find(Saisons.class, id);
		em.close();
		return ss;
	}
	
	@Override
	public  List<Saisons> findAll(){
		String req = "select Object(ss) from Saisons ss";
		EntityManager em = DAOUtil.getEntityManager();
		List<Saisons> liste = em
				.createQuery(req, Saisons.class)
				.getResultList();
		em.close();
		
		return liste;
	}

}
