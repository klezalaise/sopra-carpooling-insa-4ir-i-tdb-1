# Database initialisation #

  1. Launch EasyPHP and then go to [EasyPHP Administration Modules](http://127.0.0.1/modules/)
  1. Click on PHPMyAdmin
  1. Then, click on the "SQL" button visible at the top of the interface.
  1. Paste the following SQL queries :

```

-- Create database sopra + mysql user account
-- Last updated : 21/12/2014

CREATE DATABASE sopride DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
CREATE USER 'sopra'@'localhost' IDENTIFIED BY 'carpool';
GRANT ALL ON sopride.* TO 'sopra'@'localhost' IDENTIFIED BY 'carpool';

-- Structure de la table `address`
--

CREATE TABLE IF NOT EXISTS `address` (
  `idAddress` int(11) NOT NULL AUTO_INCREMENT,
  `postcode` int(11) NOT NULL,
  `city` varchar(50) NOT NULL,
  `street` varchar(50) NOT NULL,
  PRIMARY KEY (`idAddress`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=5 ;

--
-- Contenu de la table `address`
--


-- --------------------------------------------------------

--
-- Structure de la table `admin`
--

CREATE TABLE IF NOT EXISTS `admin` (
  `id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `car_pooling_infos`
--

CREATE TABLE IF NOT EXISTS `car_pooling_infos` (
  `id_carpooling_infos` int(11) NOT NULL AUTO_INCREMENT,
  `id_user` int(11) NOT NULL,
  `home` int(11) NOT NULL,
  `car_pooling_workplace` int(11) NOT NULL,
  `morning_hour` time NOT NULL,
  `night_hour` time NOT NULL,
  `days` int(11) NOT NULL,
  `notify` char(1) NOT NULL,
  `driver` char(1) NOT NULL,
  PRIMARY KEY (`id_carpooling_infos`),
  KEY `days` (`days`),
  KEY `car_pooling_workplace` (`car_pooling_workplace`),
  KEY `home` (`home`),
  KEY `id_user` (`id_user`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=3 ;

--
-- Contenu de la table `car_pooling_infos`
--


-- --------------------------------------------------------

--
-- Structure de la table `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` char(50) NOT NULL,
  `password` char(150) NOT NULL,
  `last_name` char(30) DEFAULT NULL,
  `first_name` char(30) DEFAULT NULL,
  `phone` int(11) DEFAULT NULL,
  `number_connections` int(11) NOT NULL,
  `last_connected_date` datetime NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`),
  KEY `password` (`password`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=2 ;

--
-- Contenu de la table `users`
--


-- --------------------------------------------------------

--
-- Structure de la table `workingdays`
--

CREATE TABLE IF NOT EXISTS `workingdays` (
  `id_workingdays` int(11) NOT NULL AUTO_INCREMENT,
  `lundi` tinyint(1) NOT NULL,
  `mardi` tinyint(1) NOT NULL,
  `mercredi` tinyint(1) NOT NULL,
  `jeudi` tinyint(1) NOT NULL,
  `vendredi` tinyint(1) NOT NULL,
  `samedi` tinyint(1) NOT NULL,
  `dimanche` tinyint(1) NOT NULL,
  PRIMARY KEY (`id_workingdays`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=6 ;

--
-- Contenu de la table `workingdays`
--


-- --------------------------------------------------------

--
-- Structure de la table `workplaces`
--

CREATE TABLE IF NOT EXISTS `workplaces` (
  `workplace_name` int(11) NOT NULL,
  PRIMARY KEY (`workplace_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `workplaces`
--


--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `admin`
--
ALTER TABLE `admin`
  ADD CONSTRAINT `userIsAdminFK` FOREIGN KEY (`id`) REFERENCES `users` (`id`) ON DELETE CASCADE;

--
-- Contraintes pour la table `workplaces`
--
ALTER TABLE `workplaces`
  ADD CONSTRAINT `workplaces_ibfk_1` FOREIGN KEY (`workplace_name`) REFERENCES `address` (`idAddress`);
 
ALTER TABLE `car_pooling_infos`
  ADD CONSTRAINT `car_pooling_infos_ibfk_1` FOREIGN KEY (`home`) REFERENCES `address` (`idAddress`),
  ADD CONSTRAINT `car_pooling_infos_ibfk_2` FOREIGN KEY (`id_user`) REFERENCES `users` (`id`),
  ADD CONSTRAINT `car_pooling_infos_ibfk_3` FOREIGN KEY (`days`) REFERENCES `workingdays` (`id_workingdays`),
  ADD CONSTRAINT `car_pooling_infos_ibfk_4` FOREIGN KEY (`car_pooling_workplace`) REFERENCES `workplaces` (`workplace_name`)

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

```