package fr.formation.dal;

import java.util.List;

import fr.formation.entity.Plantes;

public interface PlantesDao {

	void add(Plantes p) throws Exception;

	void delete(Plantes p) throws Exception;

	void update(Plantes p) throws Exception;

	Plantes findById(int id);

	List<Plantes> findAll();

}