CREATE TABLE `virement` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(45) NOT NULL,
  `prenom` varchar(45) NOT NULL,
  `idContrat` varchar(45) DEFAULT NULL,
  `numFacture` varchar(45) NOT NULL,
  `montant` varchar(45) DEFAULT NULL,
  `dateHeure` varchar(45) DEFAULT NULL,
  `etat` varchar(45) DEFAULT NULL,
  `comments` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `numFactur_UNIQUE` (`numFacture`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8;