package fr.formation.bll;

import java.util.List;

import fr.formation.dal.DaoFactory;
import fr.formation.dal.FleursDao;
import fr.formation.entity.Fleurs;
import fr.formation.exception.EntityException;

public class FleursManager {

private FleursDao dao;
	
	public FleursManager(){
		dao = DaoFactory.getFleursDao();
	}
	
	public List<Fleurs> listeFleurs(){
		return dao.findAll();
	}
	
	
	public Fleurs trouverFleurs(int id){
		return dao.findById(id);
	}

	public void ajoutFleurs(Fleurs f) throws Exception{
		
		if (f.getNom() != null && !f.getNom().trim().equals(""))
			dao.add(f);
		else
			throw new EntityException("Le style doit posséder un libellé");
	}
	
	public void modifierFleurs(Fleurs f, int id) throws Exception{
		if (f.getNom() != null && !f.getNom().trim().equals(""))
			dao.update(f);
		else
			throw new EntityException("Le style doit posséder un libellé");
	}
	
	public void supprimerFleurs(Fleurs f) throws Exception{
		dao.delete(f);
	}
	
	public void supprimerFleurs(int id) throws Exception{
		Fleurs f = dao.findById(id);
		dao.delete(f);
	}
	
	public List<Fleurs> trier(String type){
		List<Fleurs> liste = null;
		switch (type){
		default : liste = dao.findAll();
		}
		return liste;
	}
	
}
