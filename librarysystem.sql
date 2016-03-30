-- phpMyAdmin SQL Dump
-- version 3.4.5
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Jan 09, 2015 at 08:48 PM
-- Server version: 5.5.16
-- PHP Version: 5.3.8

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `librarysystem`
--

-- --------------------------------------------------------

--
-- Table structure for table `books`
--

CREATE TABLE IF NOT EXISTS `books` (
  `BookID` int(11) NOT NULL,
  `Title` varchar(22) NOT NULL,
  `Author` varchar(33) NOT NULL,
  `Publisher` varchar(33) NOT NULL,
  `Copyright` int(33) NOT NULL,
  `Edition` int(22) NOT NULL,
  `Pages` int(123) NOT NULL,
  `ISBN` varchar(21) NOT NULL,
  `NumberOfBooks` int(123) NOT NULL,
  `NumberOfAvailbleBooks` int(22) NOT NULL,
  `NumberOfBorrowedBooks` int(10) NOT NULL,
  `Availble` tinyint(1) NOT NULL,
  `ShelfNo` int(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `books`
--

INSERT INTO `books` (`BookID`, `Title`, `Author`, `Publisher`, `Copyright`, `Edition`, `Pages`, `ISBN`, `NumberOfBooks`, `NumberOfAvailbleBooks`, `NumberOfBorrowedBooks`, `Availble`, `ShelfNo`) VALUES
(1, 'test', 'test', 'test', 2014, 3, 321, 'test', 4, 4, 3, 1, 87);

-- --------------------------------------------------------

--
-- Table structure for table `borrow`
--

CREATE TABLE IF NOT EXISTS `borrow` (
  `BookID` int(10) NOT NULL,
  `MemberID` int(10) NOT NULL,
  `DayOfBorrowed` date NOT NULL,
  `DayOfReturn` date NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `members`
--

CREATE TABLE IF NOT EXISTS `members` (
  `MemberID` int(10) NOT NULL,
  `Password` varchar(11) NOT NULL,
  `Name` varchar(21) NOT NULL,
  `EMail` varchar(11) NOT NULL,
  `Major` varchar(12) NOT NULL,
  `Expired` date NOT NULL,
  `NumberOfBooks` int(10) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `members`
--

INSERT INTO `members` (`MemberID`, `Password`, `Name`, `EMail`, `Major`, `Expired`, `NumberOfBooks`) VALUES
(1, '2341', 'test', 'test', 'test', '2015-01-10', 0);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
