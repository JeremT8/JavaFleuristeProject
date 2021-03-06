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

import fr.formation.bll.FleursManager;
import fr.formation.entity.Fleurs;



@Path("/fleurs")
@Singleton
public class FleursRs {
	
	private FleursManager fleursmanager;
	
	public FleursRs() {
		fleursmanager = new FleursManager();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Fleurs> getFleurs(){
		return fleursmanager.listeFleurs();
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Fleurs getFleur(@PathParam("id") int id){
		return fleursmanager.trouverFleurs(id);
	}
	
	

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void postFleurs(Fleurs f) {
		try {
			System.out.println("Ajout de " + f);
			fleursmanager.ajoutFleurs(f);
		} catch (Exception e) {
			throw new WebApplicationException(Response.Status.CONFLICT);
		}
	}
	

	@DELETE
	@Path("/{id}")
	public void removeFleurs(@PathParam("id") int id) {
		try {
			fleursmanager.supprimerFleurs(id);
		} catch (Exception e) {
			throw new WebApplicationException(Response.Status.CONFLICT);
		}
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public void putFleurs(Fleurs f, @PathParam("id") int id) {
		try {
			f.setId(id);
			fleursmanager.modifierFleurs(f, id);
		} catch (Exception e) {
			throw new WebApplicationException(Response.Status.CONFLICT);
		}
	}
}

