package dz.acs.integ.demo.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import dz.acs.integ.demo.model.Paiement;
import dz.acs.integ.demo.model.PaiementEntity;

@Service

public class DbServiceFromJMS {
	@PersistenceContext
	private EntityManager entityManager;
	 
	 @RabbitListener(queues = "queue-paiement-0")
	 @Transactional
     public void process(Paiement paie) {		 
        entityManager.persist(new PaiementEntity(paie));
     }

}
