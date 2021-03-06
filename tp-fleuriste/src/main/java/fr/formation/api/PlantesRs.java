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

import fr.formation.bll.PlantesManager;
import fr.formation.entity.Fleurs;
import fr.formation.entity.Plantes;



@Path("/plantes")
@Singleton
public class PlantesRs {
	
	private PlantesManager plantesmanager;
	
	public PlantesRs() {
		plantesmanager = new PlantesManager();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Plantes> getPlantes(){
		return plantesmanager.listePlantes();
	}
	

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Plantes getPlante(@PathParam("id") int id){
		return plantesmanager.trouverPlantes(id);
	}
	
	

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void postStyle(Plantes p) {
		try {
			System.out.println("Ajout de " + p);
			plantesmanager.ajoutPlantes(p);
		} catch (Exception e) {
			throw new WebApplicationException(Response.Status.CONFLICT);
		}
	}
	

	@DELETE
	@Path("/{id}")
	public void removeFleurs(@PathParam("id") int id) {
		try {
			plantesmanager.supprimerPlantes(id);
		} catch (Exception e) {
			throw new WebApplicationException(Response.Status.CONFLICT);
		}
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public void putLivre(Plantes p, @PathParam("id") int id) {
		try {
			p.setId(id);
			plantesmanager.modifierPlantes(p);
		} catch (Exception e) {
			throw new WebApplicationException(Response.Status.CONFLICT);
		}
	}
}

