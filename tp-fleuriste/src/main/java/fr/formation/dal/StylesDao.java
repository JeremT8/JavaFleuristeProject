package fr.formation.dal;

import java.util.List;

import fr.formation.entity.Styles;

public interface StylesDao {

	public void add(Styles s) throws Exception;

	public void delete(Styles s) throws Exception;

	public void update(Styles s) throws Exception;

	public Styles findById(int id);

	public List<Styles> findAll();
}
