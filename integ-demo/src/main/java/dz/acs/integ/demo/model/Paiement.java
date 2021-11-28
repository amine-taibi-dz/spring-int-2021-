package dz.acs.integ.demo.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.Builder;
@Builder
public record Paiement(String prenom,String nom,BigDecimal montant,LocalDate dateOps) implements Serializable{}
