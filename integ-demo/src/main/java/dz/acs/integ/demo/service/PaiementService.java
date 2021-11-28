package dz.acs.integ.demo.service;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

import dz.acs.integ.demo.model.Paiement;
@Service
public class PaiementService {
	@Value("${fields.sep:#}")
	private String fieldSeparator;
	
	@ServiceActivator(inputChannel = "lines",outputChannel = "paiements")
	public Message<Paiement> process(Message<String> data){
		System.err.println(data.getPayload());
		String[] datum = data.getPayload().split("#");
		
		String prenom=datum[0];
		String nom=datum[1];
		BigDecimal montant=new BigDecimal(datum[2]);
		String[] dateInfo = datum[3].split("-");
		LocalDate dateOps = LocalDate.of(Integer.valueOf(dateInfo[0]), Integer.valueOf(dateInfo[1]), Integer.valueOf(dateInfo[2]));
		
		Paiement paie = Paiement.builder().nom(nom).prenom(prenom).montant(montant).dateOps(dateOps).build();
		Message<Paiement> message = MessageBuilder.withPayload(paie ).build();
		System.out.println(paie);
		
		return message;
	}
}
