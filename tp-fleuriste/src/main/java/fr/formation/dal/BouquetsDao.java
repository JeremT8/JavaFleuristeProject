package fr.formation.dal;

import java.util.List;

import fr.formation.entity.Bouquets;

public interface BouquetsDao {

	void add(Bouquets b) throws Exception;

	void delete(Bouquets b) throws Exception;

	void update(Bouquets b) throws Exception;

	Bouquets findById(int id);

	List<Bouquets> findAll();

}