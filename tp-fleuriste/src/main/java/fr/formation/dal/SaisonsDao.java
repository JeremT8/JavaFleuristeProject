package fr.formation.dal;

import java.util.List;

import fr.formation.entity.Saisons;

public interface SaisonsDao {

	public void add(Saisons ss) throws Exception;

	public void delete(Saisons ss) throws Exception;

	public void update(Saisons ss) throws Exception;

	public Saisons findById(int id);

	public List<Saisons> findAll();
}
