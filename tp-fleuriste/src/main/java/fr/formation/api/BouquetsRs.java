package fr.formation.api;

import java.util.List;

import javax.inject.Singleton;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import fr.formation.bll.BouquetsManager;
import fr.formation.entity.Bouquets;



@Path("/bouquets")
@Singleton
public class BouquetsRs {
	
	private BouquetsManager bouquetsmanager;
	
	public BouquetsRs() {
		bouquetsmanager = new BouquetsManager();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Bouquets> getBouquets(){
		return bouquetsmanager.listeBouquets();
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Bouquets getBouquet(@PathParam("id") int id){
		return bouquetsmanager.trouverBouquets(id);
	}
	

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void postBouquets(Bouquets b) {
		try {
			System.out.println("Ajout de " + b);
			bouquetsmanager.ajoutBouquets(b);
		} catch (Exception e) {
			throw new WebApplicationException(Response.Status.CONFLICT);
		}
	}
	

	@DELETE
	@Path("/{id}")
	public void removeBouquets(@PathParam("id") int id) {
		try {
			bouquetsmanager.supprimerBouquets(id);
		} catch (Exception e) {
			throw new WebApplicationException(Response.Status.CONFLICT);
		}
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public void putBouquets(Bouquets b, @PathParam("id") int id) {
		try {
			b.setId(id);
			bouquetsmanager.modifierBouquets(b, id);
		} catch (Exception e) {
			throw new WebApplicationException(Response.Status.CONFLICT);
		}
	}
}

