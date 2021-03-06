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

import fr.formation.bll.SaisonsManager;
import fr.formation.entity.Saisons;



@Path("/saisons")
@Singleton
public class SaisonsRs {
	
	private SaisonsManager saisonsmanager;
	
	public SaisonsRs() {
		saisonsmanager = new SaisonsManager();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Saisons> getSaisons(){
		return saisonsmanager.listeSaisons();
	}
	
	

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void postStyle(Saisons s) {
		try {
			System.out.println("Ajout de " + s);
			saisonsmanager.ajoutStyle(s);
		} catch (Exception e) {
			throw new WebApplicationException(Response.Status.CONFLICT);
		}
	}
	

	@DELETE
	@Path("/{id}")
	public void removeStyle(@PathParam("id") int id) {
		try {
			saisonsmanager.supprimerStyle(id);
		} catch (Exception e) {
			throw new WebApplicationException(Response.Status.CONFLICT);
		}
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public void putLivre(Saisons s, @PathParam("id") int id) {
		try {
			s.setId(id);
			saisonsmanager.modifierStyle(s);
		} catch (Exception e) {
			throw new WebApplicationException(Response.Status.CONFLICT);
		}
	}
}

