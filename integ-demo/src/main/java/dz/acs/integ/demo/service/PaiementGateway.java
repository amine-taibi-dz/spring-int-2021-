package dz.acs.integ.demo.service;

import org.springframework.integration.annotation.MessagingGateway;

@MessagingGateway(name = "paiementGateway", defaultRequestChannel = "filesIn")
public interface PaiementGateway {
	String operatePaiement(String input);

}
