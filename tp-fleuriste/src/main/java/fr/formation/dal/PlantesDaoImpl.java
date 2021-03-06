package fr.formation.dal;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import fr.formation.entity.Plantes;


public class PlantesDaoImpl implements PlantesDao {
	
	@Override
	public void add(Plantes p) throws Exception{
		EntityManager em = DAOUtil.getEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		try {
			em.persist(p);
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
	public void delete(Plantes p) throws Exception{
		EntityManager em = DAOUtil.getEntityManager();
		EntityTransaction et = em.getTransaction();
		p = em.find(Plantes.class, p.getId());
		et.begin();
		try {
			em.remove(p);
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
	public  void update(Plantes p) throws Exception{
		EntityManager em = DAOUtil.getEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		try {
			em.merge(p);
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
	public Plantes findById(int id){
		EntityManager em = DAOUtil.getEntityManager();
		Plantes p = em.find(Plantes.class, id);
		em.close();
		return p;
	}
	
	@Override
	public List<Plantes> findAll(){
		String req = "select Object(p) from Plantes p";
		EntityManager em = DAOUtil.getEntityManager();
		List<Plantes> liste = em
				.createQuery(req, Plantes.class)
				.getResultList();
		em.close();
		
		return liste;
	}
}
