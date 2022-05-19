package fr.formation.bll;

import java.util.List;

import fr.formation.dal.DaoFactory;
import fr.formation.dal.StylesDao;
import fr.formation.entity.Styles;
import fr.formation.exception.EntityException;

public class StylesManager {

private StylesDao dao;
	
	public StylesManager(){
		dao = DaoFactory.getStylesDao();
	}
	
	public List<Styles> listeStyles(){
		return dao.findAll();
	}
	
	
	public Styles trouverStyle(int id){
		return dao.findById(id);
	}

	public void ajoutStyle(Styles s) throws Exception{
		
		if (s.getLibelle() != null && !s.getLibelle().trim().equals(""))
			dao.add(s);
		else
			throw new EntityException("Le style doit posséder un libellé");
	}
	
	public void modifierStyle(Styles s) throws Exception{
		if (s.getLibelle() != null && !s.getLibelle().trim().equals(""))
			dao.update(s);
		else
			throw new EntityException("Le style doit posséder un libellé");
	}
	
	public void supprimerStyle(Styles s) throws Exception{
		dao.delete(s);
	}
	
	public void supprimerStyle(int id) throws Exception{
		Styles s = dao.findById(id);
		dao.delete(s);
	}
	
	public List<Styles> trier(String type){
		List<Styles> liste = null;
		switch (type){
		default : liste = dao.findAll();
		}
		return liste;
	}
	
}
