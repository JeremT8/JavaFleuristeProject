package fr.formation.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "FLEURS")
public class Fleurs  {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(length = 50, nullable = false)
	private String nom;
	
	@Column(nullable = false)
	private float tarif;
	
	@Column(nullable = false)
	private int quantite;
	
	@Lob
	private String description;
	
	@Column(length = 250, nullable = false)
	private String image;
	
	@Column(length = 50, nullable = true)
	private String couleur;
	
	@ManyToOne
	@JoinColumn(name = "idSaison")
	private Saisons saison;

	
	public Fleurs() {
		// TODO Auto-generated constructor stub
	}


	public Fleurs(String nom, float tarif, int quantite, String description, String image, String couleur,
			Saisons saison) {
		this.nom = nom;
		this.tarif = tarif;
		this.quantite = quantite;
		this.description = description;
		this.image = image;
		this.couleur = couleur;
		this.saison = saison;
	}


	public Fleurs(int id, String nom, float tarif, int quantite, String description, String image, String couleur,
			Saisons saison) {
		this.id = id;
		this.nom = nom;
		this.tarif = tarif;
		this.quantite = quantite;
		this.description = description;
		this.image = image;
		this.couleur = couleur;
		this.saison = saison;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public float getTarif() {
		return tarif;
	}


	public void setTarif(float tarif) {
		this.tarif = tarif;
	}


	public int getQuantite() {
		return quantite;
	}


	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}


	public String getCouleur() {
		return couleur;
	}


	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}


	public Saisons getSaison() {
		return saison;
	}


	public void setSaison(Saisons saison) {
		this.saison = saison;
	}


	@Override
	public String toString() {
		return "Fleurs [id=" + id + ", nom=" + nom + ", tarif=" + tarif + ", quantite=" + quantite + ", description="
				+ description + ", image=" + image + ", couleur=" + couleur + ", saison=" + saison + "]";
	}
	
	
	
	

}
