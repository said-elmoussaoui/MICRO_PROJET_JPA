-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Apr 26, 2021 at 06:53 PM
-- Server version: 10.4.18-MariaDB
-- PHP Version: 8.0.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `microproj`
--

-- --------------------------------------------------------

--
-- Table structure for table `articles`
--

CREATE TABLE `articles` (
  `CodeArticle` int(11) NOT NULL,
  `titre` varchar(20) DEFAULT NULL,
  `prix` float DEFAULT NULL,
  `stock` int(11) DEFAULT NULL,
  `Categorie` varchar(20) DEFAULT NULL,
  `photo` varchar(20) DEFAULT NULL,
  `auteur` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `articles`
--

INSERT INTO `articles` (`CodeArticle`, `titre`, `prix`, `stock`, `Categorie`, `photo`, `auteur`) VALUES
(1, 'Tutu', 1200000, 4, 'JAZZ', 'milD.jpg', 'Miles Davies'),
(2, 'Travel', 100000, 10, 'JAZZ', 'pat.jpg', 'Pat Metheny'),
(3, 'One', 99000, 20, 'JAZZ', 'brad.jpg', 'Brad Meldhau'),
(4, 'FILM', 10000, 8, 'FILM', 'film.jpg', 'Auteur Film'),
(5, 'FOOTBALL', 10000, 4, 'FOOT', 'zidan.jpg', 'ZIDANE'),
(6, 'FOOTBALL', 12000, 10, 'FOOT', 'ronal.jpg', 'Ronaldinho');

-- --------------------------------------------------------

--
-- Table structure for table `categories`
--

CREATE TABLE `categories` (
  `RefCat` int(11) NOT NULL,
  `cat` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `categories`
--

INSERT INTO `categories` (`RefCat`, `cat`) VALUES
(1, 'FILM'),
(2, 'JAZZ'),
(3, 'FOOT');

-- --------------------------------------------------------

--
-- Table structure for table `clients`
--

CREATE TABLE `clients` (
  `id` int(11) NOT NULL,
  `Email` varchar(100) DEFAULT NULL,
  `Nom` varchar(20) DEFAULT NULL,
  `prenom` varchar(20) DEFAULT NULL,
  `adresse` varchar(20) DEFAULT NULL,
  `CodePostal` int(11) DEFAULT NULL,
  `ville` varchar(100) DEFAULT NULL,
  `Tel` varchar(100) DEFAULT NULL,
  `MotPasse` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `clients`
--

INSERT INTO `clients` (`id`, `Email`, `Nom`, `prenom`, `adresse`, `CodePostal`, `ville`, `Tel`, `MotPasse`) VALUES
(6, 'saidelmoussaoui19@gmail.com', 'MOUSSAOUI', 'SAID', '1234abcd', 1234, 'marrakech', '0656666667', '1234abcd'),
(7, 'toto@gmail.com', 'toto', 'tutu', 'azert', 4321, 'casa', '0600000000', 'azert'),
(8, 'nom@gmail.com', 'nom', 'prenom', 'password', 4321, 'ville', '06566666', 'password');

-- --------------------------------------------------------

--
-- Table structure for table `commandes`
--

CREATE TABLE `commandes` (
  `NumCommande` int(11) NOT NULL,
  `CodeClient` int(11) DEFAULT NULL,
  `DateCommande` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `commandes`
--

INSERT INTO `commandes` (`NumCommande`, `CodeClient`, `DateCommande`) VALUES
(21, 6, '2021-04-26 11:49:21'),
(42, 7, '10/3/2021  18::12'),
(43, 7, '10/4/2021  18::14');

-- --------------------------------------------------------

--
-- Table structure for table `lignecommandes`
--

CREATE TABLE `lignecommandes` (
  `NumCommande` int(11) NOT NULL,
  `CodeArticle` int(11) NOT NULL,
  `QteCde` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `lignecommandes`
--

INSERT INTO `lignecommandes` (`NumCommande`, `CodeArticle`, `QteCde`) VALUES
(42, 4, 2),
(43, 4, 2);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `articles`
--
ALTER TABLE `articles`
  ADD PRIMARY KEY (`CodeArticle`);

--
-- Indexes for table `categories`
--
ALTER TABLE `categories`
  ADD PRIMARY KEY (`RefCat`);

--
-- Indexes for table `clients`
--
ALTER TABLE `clients`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `con01` (`Email`);

--
-- Indexes for table `commandes`
--
ALTER TABLE `commandes`
  ADD PRIMARY KEY (`NumCommande`),
  ADD KEY `CodeClient` (`CodeClient`);

--
-- Indexes for table `lignecommandes`
--
ALTER TABLE `lignecommandes`
  ADD PRIMARY KEY (`NumCommande`,`CodeArticle`),
  ADD KEY `CodeArticle` (`CodeArticle`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `articles`
--
ALTER TABLE `articles`
  MODIFY `CodeArticle` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `clients`
--
ALTER TABLE `clients`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `commandes`
--
ALTER TABLE `commandes`
  MODIFY `NumCommande` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=44;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `commandes`
--
ALTER TABLE `commandes`
  ADD CONSTRAINT `commandes_ibfk_1` FOREIGN KEY (`CodeClient`) REFERENCES `clients` (`id`);

--
-- Constraints for table `lignecommandes`
--
ALTER TABLE `lignecommandes`
  ADD CONSTRAINT `lignecommandes_ibfk_1` FOREIGN KEY (`CodeArticle`) REFERENCES `articles` (`CodeArticle`),
  ADD CONSTRAINT `lignecommandes_ibfk_2` FOREIGN KEY (`NumCommande`) REFERENCES `commandes` (`NumCommande`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
