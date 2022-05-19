package fr.formation.bll;

import java.util.List;

import fr.formation.dal.DaoFactory;
import fr.formation.dal.SaisonsDao;
import fr.formation.entity.Saisons;
import fr.formation.exception.EntityException;

public class SaisonsManager {

private SaisonsDao dao;
	
	public SaisonsManager(){
		dao = DaoFactory.getSaisonsDao();
	}
	
	public List<Saisons> listeSaisons(){
		return dao.findAll();
	}
	
	
	public Saisons trouverStyle(int id){
		return dao.findById(id);
	}

	public void ajoutStyle(Saisons s) throws Exception{
		
		if (s.getLibelle() != null && !s.getLibelle().trim().equals(""))
			dao.add(s);
		else
			throw new EntityException("Le style doit posséder un libellé");
	}
	
	public void modifierStyle(Saisons s) throws Exception{
		if (s.getLibelle() != null && !s.getLibelle().trim().equals(""))
			dao.update(s);
		else
			throw new EntityException("Le style doit posséder un libellé");
	}
	
	public void supprimerStyle(Saisons s) throws Exception{
		dao.delete(s);
	}
	
	public void supprimerStyle(int id) throws Exception{
		Saisons s = dao.findById(id);
		dao.delete(s);
	}
	
	public List<Saisons> trier(String type){
		List<Saisons> liste = null;
		switch (type){
		default : liste = dao.findAll();
		}
		return liste;
	}
	
}
