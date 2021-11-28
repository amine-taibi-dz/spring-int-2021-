package dz.acs.integ.demo.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class PaiementEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2692376913383336501L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nom;
	private String prenom;
	private BigDecimal montant;
	private LocalDate dateOps;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public BigDecimal getMontant() {
		return montant;
	}
	public void setMontant(BigDecimal montant) {
		this.montant = montant;
	}
	public LocalDate getDateOps() {
		return dateOps;
	}
	public void setDateOps(LocalDate dateOps) {
		this.dateOps = dateOps;
	}
	public PaiementEntity(String nom, String prenom, BigDecimal montant, LocalDate dateOps) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.montant = montant;
		this.dateOps = dateOps;
	}
	public PaiementEntity() {
		super();
	}
	
	public PaiementEntity(Paiement paiement) {
		this.nom = paiement.nom();
		this.prenom = paiement.prenom();
		this.montant = paiement.montant();
		this.dateOps = paiement.dateOps();
	}
	
	

}
