package fr.formation.dal;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import fr.formation.entity.Bouquets;

public class BouquetsDaoImpl implements BouquetsDao {
	@Override
	public void add(Bouquets b) throws Exception{
		EntityManager em = DAOUtil.getEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		try {
			em.persist(b);
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
	public void delete(Bouquets b) throws Exception{
		EntityManager em = DAOUtil.getEntityManager();
		EntityTransaction et = em.getTransaction();
		b = em.find(Bouquets.class, b.getId());
		et.begin();
		try {
			em.remove(b);
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
	public  void update(Bouquets b) throws Exception{
		EntityManager em = DAOUtil.getEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		try {
			em.merge(b);
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
	public Bouquets findById(int id){
		EntityManager em = DAOUtil.getEntityManager();
		Bouquets b = em.find(Bouquets.class, id);
		em.close();
		return b;
	}
	
	@Override
	public List<Bouquets> findAll(){
		String req = "select Object(b) from Bouquets b";
		EntityManager em = DAOUtil.getEntityManager();
		List<Bouquets> liste = em
				.createQuery(req, Bouquets.class)
				.getResultList();
		em.close();
		
		return liste;
	}
}
