package fr.formation.bll;

import java.util.List;

import fr.formation.dal.DaoFactory;
import fr.formation.dal.BouquetsDao;
import fr.formation.entity.Bouquets;
import fr.formation.exception.EntityException;

public class BouquetsManager {

private BouquetsDao dao;
	
	public BouquetsManager(){
		dao = DaoFactory.getBouquetsDao();
	}
	
	public List<Bouquets> listeBouquets(){
		return dao.findAll();
	}
	
	
	public Bouquets trouverBouquets(int id){
		return dao.findById(id);
	}

	public void ajoutBouquets(Bouquets b) throws Exception{
		
		if (b.getNom() != null && !b.getNom().trim().equals(""))
			dao.add(b);
		else
			throw new EntityException("Le bouquet doit posséder un nom");
	}
	
	public void modifierBouquets(Bouquets b, int id) throws Exception{
		if (b.getNom() != null && !b.getNom().trim().equals(""))
			dao.update(b);
		else
			throw new EntityException("Le bouquet doit posséder un nom");
	}
	
	public void supprimerBouquets(Bouquets b) throws Exception{
		dao.delete(b);
	}
	
	public void supprimerBouquets(int id) throws Exception{
		Bouquets b = dao.findById(id);
		dao.delete(b);
	}
	
	public List<Bouquets> trier(String type){
		List<Bouquets> liste = null;
		switch (type){
		default : liste = dao.findAll();
		}
		return liste;
	}
	
}
