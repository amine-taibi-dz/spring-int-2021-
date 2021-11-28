package dz.acs.integ.demo;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import dz.acs.integ.demo.model.Paiement;

@SpringBootTest
class IntegDemoApplicationRabbitMqTests {
	
	
	@Autowired
	public AmqpTemplate amqpTemplate;
	
	
	@Test
	@Order(value = 500)
	public void testSend() {
		amqpTemplate.convertAndSend("queue-paiement", 
				Paiement.builder()
					.prenom("Amine")
					.nom("TAIBI")
					.montant(new BigDecimal(50_000L))
					.dateOps(LocalDate.now())
					.build()
				);
	}
	@Test
	@Order(value = 100)
	public void testLecture() {
		
		Object p0 = amqpTemplate.receiveAndConvert("queue-paiement");
		assertNotNull(p0);
		assertInstanceOf(Paiement.class, p0); 
		//assertTrue("TAIBI".equals(((Paiement)p0).nom()),p0.toString());
		
	}

}
