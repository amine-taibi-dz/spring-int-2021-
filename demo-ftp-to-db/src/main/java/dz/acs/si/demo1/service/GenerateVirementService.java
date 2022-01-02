package dz.acs.si.demo1.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import dz.acs.si.demo1.model.Virement;
import lombok.Getter;

@Component("generateVirementService")
public class GenerateVirementService {

	@Getter
	@Value("${virement.sep.val}")
	public String separ;
	
	@Getter
	@Value("${virement.date.format}")
	public String dateFormat;
	
	
	@Getter
	@Value("${virement.ignore.char}")
	public String ignorChar;
	
	@Getter
	@Value("${virement.format.size}")
	public int size;

	/**
	 * generate
	 * @param line
	 * @return
	 */
	public Virement generate(String line) {
		Virement v = Virement.NULL;
		//id, name, gender, dateOfBirth
		//String[] res = StringUtils.split(test, separ);
		String[] res = line.split("\\|");
		if(res.length<size) {
			return  Virement.NULL;
		}
		int i =0;
		try {
			v = Virement.builder()
		    .nom(res[i++].trim())
			.prenom(res[i++].trim())
			.idContrat(res[i++].trim())
			.numFacture(res[i++].trim())
			.montant(res[i++].trim())
			.dateHeure(res[i++].trim())
			.etat(res[i++].trim())
			.comments(res[i++].trim())
			.build();
			
		} catch (Exception e) {
			return  Virement.ERROR;
		}
		System.out.println("ACTIVATOR!!! "+v);
		return v;
	}

	/**
	 * log ...
	 * @param test
	 */
	public void out(Virement test) {
		System.out.println(test);
	}
	
	/**
	 * log ...
	 * @param test
	 */
	public void outCancel(String test) {
		System.out.println("CANCEL == > ##"+test+"##");
	}


	/**
	 * filter lines 
	 * @param message
	 * @return
	 */
	public boolean filter(String message) {
		return !( message.trim().isEmpty() || 
			message.startsWith(ignorChar));
	}

	/**
	 * split ..
	 * @param message
	 * @return
	 */
	public String[] split(String message) {
		return message.split("\\n");
	}
}
