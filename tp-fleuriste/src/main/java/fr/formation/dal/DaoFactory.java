package fr.formation.dal;


public class DaoFactory {

	public static StylesDao getStylesDao(){
		return new StylesDaoImpl();
	}
	
	public static SaisonsDao getSaisonsDao(){
		return new SaisonsDaoImpl();
	}
	
	public static FleursDao getFleursDao(){
		return new FleursDaoImpl();
	}
	
	public static PlantesDao getPlantesDao(){
		return new PlantesDaoImpl();
	}
	
	public static BouquetsDao getBouquetsDao(){
		return new BouquetsDaoImpl();
	}
}
