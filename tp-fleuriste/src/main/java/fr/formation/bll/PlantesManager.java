package fr.formation.bll;

import java.util.List;

import fr.formation.dal.DaoFactory;
import fr.formation.dal.PlantesDao;
import fr.formation.entity.Plantes;
import fr.formation.exception.EntityException;

public class PlantesManager {

private PlantesDao dao;
	
	public PlantesManager(){
		dao = DaoFactory.getPlantesDao();
	}
	
	public List<Plantes> listePlantes(){
		return dao.findAll();
	}
	
	
	public Plantes trouverPlantes(int id){
		return dao.findById(id);
	}

	public void ajoutPlantes(Plantes p) throws Exception{
		
		if (p.getNom() != null && !p.getNom().trim().equals(""))
			dao.add(p);
		else
			throw new EntityException("Le style doit poss?der un libell?");
	}
	
	public void modifierPlantes(Plantes p) throws Exception{
		if (p.getNom() != null && !p.getNom().trim().equals(""))
			dao.update(p);
		else
			throw new EntityException("Le style doit poss?der un libell?");
	}
	
	public void supprimerPlantes(Plantes p) throws Exception{
		dao.delete(p);
	}
	
	public void supprimerPlantes(int id) throws Exception{
		Plantes p = dao.findById(id);
		dao.delete(p);
	}
	
	public List<Plantes> trier(String type){
		List<Plantes> liste = null;
		switch (type){
		default : liste = dao.findAll();
		}
		return liste;
	}
	
}
