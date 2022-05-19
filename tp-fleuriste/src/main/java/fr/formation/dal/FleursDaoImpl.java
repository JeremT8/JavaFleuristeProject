package fr.formation.dal;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import fr.formation.entity.Fleurs;

public class FleursDaoImpl implements FleursDao {

	@Override
	public void add(Fleurs f) throws Exception{
		EntityManager em = DAOUtil.getEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		try {
			em.persist(f);
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
	public void delete(Fleurs f) throws Exception{
		EntityManager em = DAOUtil.getEntityManager();
		EntityTransaction et = em.getTransaction();
		f = em.find(Fleurs.class, f.getId());
		et.begin();
		try {
			em.remove(f);
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
	public  void update(Fleurs f) throws Exception{
		EntityManager em = DAOUtil.getEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		try {
			em.merge(f);
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
	public Fleurs findById(int id){
		EntityManager em = DAOUtil.getEntityManager();
		Fleurs f = em.find(Fleurs.class, id);
		em.close();
		return f;
	}
	
	@Override
	public List<Fleurs> findAll(){
		String req = "select Object(f) from Fleurs f";
		EntityManager em = DAOUtil.getEntityManager();
		List<Fleurs> liste = em
				.createQuery(req, Fleurs.class)
				.getResultList();
		em.close();
		
		return liste;
	}
}
