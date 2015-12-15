-- phpMyAdmin SQL Dump
-- version 4.4.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Erstellungszeit: 15. Dez 2015 um 13:44
-- Server-Version: 5.6.26
-- PHP-Version: 5.6.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Datenbank: `vislab`
--
CREATE DATABASE IF NOT EXISTS `vislab` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `vislab`;

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `category`
--

DROP TABLE IF EXISTS `category`;
CREATE TABLE IF NOT EXISTS `category` (
  `LABEL` text NOT NULL,
  `DESCRIPTION` longtext,
  `category_id` bigint(20) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Daten für Tabelle `category`
--

INSERT INTO `category` (`LABEL`, `DESCRIPTION`, `category_id`) VALUES
('Normale Milch', NULL, 1),
('Seltene Milch', NULL, 2),
('Fast feste Milch', NULL, 3),
('Feste Milch', NULL, 4);

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE IF NOT EXISTS `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Daten für Tabelle `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(2);

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `product`
--

DROP TABLE IF EXISTS `product`;
CREATE TABLE IF NOT EXISTS `product` (
  `P_ID` bigint(20) unsigned NOT NULL,
  `LABEL` text NOT NULL,
  `DESCRIPTION` longtext NOT NULL,
  `PRICE` double NOT NULL,
  `STOCK` int(11) NOT NULL,
  `CATEGORY` bigint(20) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Daten für Tabelle `product`
--

INSERT INTO `product` (`P_ID`, `LABEL`, `DESCRIPTION`, `PRICE`, `STOCK`, `CATEGORY`) VALUES
(1, 'H-Milch', 'Diese Milch ist haltbarer als normale Milch.', 0.04, 200, 1),
(2, 'Bla-Milch', 'Diese Milch laber viel.', 0.4, 20, 2),
(3, 'Joghurt', 'Entwickelt(e) mehr Kultur als Amerika', 0.02, 400, 3),
(4, 'Butter', 'Frosch ist Optimist und hat gut gestrampelt', 0.01, 75, 4);

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `shopping_cart`
--

DROP TABLE IF EXISTS `shopping_cart`;
CREATE TABLE IF NOT EXISTS `shopping_cart` (
  `U_ID` bigint(20) unsigned NOT NULL,
  `P_ID` bigint(20) unsigned NOT NULL,
  `COUNT` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `U_ID` bigint(20) unsigned NOT NULL,
  `PASSWORD` varchar(30) NOT NULL,
  `FIRSTNAME` varchar(30) NOT NULL,
  `LASTNAME` varchar(30) NOT NULL,
  `ISADMIN` tinyint(1) NOT NULL DEFAULT '0',
  `EMAIL` varchar(60) NOT NULL,
  `STREET` varchar(60) NOT NULL,
  `NUMBER` varchar(7) NOT NULL,
  `ZIP` varchar(10) NOT NULL,
  `CITY` varchar(60) NOT NULL,
  `COUNTRY` varchar(60) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Daten für Tabelle `user`
--

INSERT INTO `user` (`U_ID`, `PASSWORD`, `FIRSTNAME`, `LASTNAME`, `ISADMIN`, `EMAIL`, `STREET`, `NUMBER`, `ZIP`, `CITY`, `COUNTRY`) VALUES
(1, 'admin', 'Max', 'Musteradmin', 1, 'admin', 'Musterweg', '88', '76137', 'Karlsruhe', 'Deutschland'),
(2, 'user' 'Max', 'Museruser', 0, 'user', 'Musterweg', '66', '76137', 'Karlsruhe', 'Deutschland');

--
-- Indizes der exportierten Tabellen
--

--
-- Indizes für die Tabelle `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`category_id`),
  ADD KEY `category_id` (`category_id`);

--
-- Indizes für die Tabelle `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`P_ID`),
  ADD UNIQUE KEY `P_ID` (`P_ID`),
  ADD KEY `P_ID_2` (`P_ID`);

--
-- Indizes für die Tabelle `shopping_cart`
--
ALTER TABLE `shopping_cart`
  ADD KEY `U_ID` (`U_ID`),
  ADD KEY `P_ID` (`P_ID`);

--
-- Indizes für die Tabelle `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`U_ID`),
  ADD UNIQUE KEY `U_ID` (`U_ID`);

--
-- AUTO_INCREMENT für exportierte Tabellen
--

--
-- AUTO_INCREMENT für Tabelle `category`
--
ALTER TABLE `category`
  MODIFY `category_id` bigint(20) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT für Tabelle `product`
--
ALTER TABLE `product`
  MODIFY `P_ID` bigint(20) unsigned NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT für Tabelle `user`
--
ALTER TABLE `user`
  MODIFY `U_ID` bigint(20) unsigned NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- Constraints der exportierten Tabellen
--

--
-- Constraints der Tabelle `shopping_cart`
--
ALTER TABLE `shopping_cart`
  ADD CONSTRAINT `FK_shoppingcart_product` FOREIGN KEY (`P_ID`) REFERENCES `product` (`P_ID`),
  ADD CONSTRAINT `FK_shoppingcart_user` FOREIGN KEY (`U_ID`) REFERENCES `user` (`U_ID`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
