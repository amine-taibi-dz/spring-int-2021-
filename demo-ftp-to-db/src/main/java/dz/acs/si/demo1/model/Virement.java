package dz.acs.si.demo1.model;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * Virement
 * @author ataibi
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Virement implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3370076483577554380L;
	public final static Virement NULL = new Virement();
	public final static Virement ERROR = new Virement();
	private String nom;
	private String prenom;
	private String idContrat;
	private String numFacture;
	private String montant;
	private String dateHeure;
	private String etat;
	private String comments;
		
	
}
