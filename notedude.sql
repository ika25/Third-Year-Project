-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Apr 18, 2018 at 02:36 PM
-- Server version: 5.7.19
-- PHP Version: 5.6.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `notedude`
--

-- --------------------------------------------------------

--
-- Table structure for table `subjects`
--

DROP TABLE IF EXISTS `subjects`;
CREATE TABLE IF NOT EXISTS `subjects` (
  `id` int(3) NOT NULL,
  `name` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `subjects`
--

INSERT INTO `subjects` (`id`, `name`) VALUES
(1, 'Sports'),
(2, 'Software'),
(3, 'Science'),
(4, 'Maths'),
(5, 'English'),
(6, 'Technology'),
(7, 'French'),
(8, 'German'),
(9, 'Spanish'),
(10, 'Business Studies'),
(11, 'Medicine'),
(12, 'Engineering'),
(13, 'Music'),
(14, 'Business');

-- --------------------------------------------------------

--
-- Table structure for table `subject_topics`
--

DROP TABLE IF EXISTS `subject_topics`;
CREATE TABLE IF NOT EXISTS `subject_topics` (
  `subjectID` int(3) NOT NULL,
  `topicID` int(11) NOT NULL,
  PRIMARY KEY (`subjectID`,`topicID`),
  KEY `topicID` (`topicID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `subject_topics`
--

INSERT INTO `subject_topics` (`subjectID`, `topicID`) VALUES
(1, 1000),
(1, 1001);

-- --------------------------------------------------------

--
-- Table structure for table `topics`
--

DROP TABLE IF EXISTS `topics`;
CREATE TABLE IF NOT EXISTS `topics` (
  `topicID` int(11) NOT NULL,
  `topicName` text NOT NULL,
  `details` mediumtext NOT NULL,
  PRIMARY KEY (`topicID`),
  KEY `topicID` (`topicID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `topics`
--

INSERT INTO `topics` (`topicID`, `topicName`, `details`) VALUES
(1000, 'Soccer', 'Association football, more commonly known as football or soccer,[a] is a team sport played between two teams of eleven players with a spherical ball. It is played by 250 million players in over 200 countries and dependencies, making it the world\'s most popular sport. The game is played on a rectangular field with a goal at each end. The object of the game is to score by moving the ball beyond the goal line into the opposing goal.'),
(1001, 'Basketball', 'Basketball is a limited-contact sport played on a rectangular court. While most often played as a team sport with five players on each side, three-on-three, two-on-two, and one-on-one competitions are also common. The objective is to shoot a basketball (approximately 9.4 inches (24 cm) in diameter) through a hoop 18 inches (46 cm) in diameter and 10 feet (3.048 m) high that is mounted to a backboard at each end of the court. The game was invented in 1891 by Dr. James Naismith.');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `subject_topics`
--
ALTER TABLE `subject_topics`
  ADD CONSTRAINT `subject_topics_ibfk_1` FOREIGN KEY (`subjectID`) REFERENCES `subjects` (`id`),
  ADD CONSTRAINT `subject_topics_ibfk_2` FOREIGN KEY (`topicID`) REFERENCES `topics` (`topicID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
