-- phpMyAdmin SQL Dump
-- version 4.0.10deb1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Dec 03, 2016 at 11:04 AM
-- Server version: 5.5.49-0ubuntu0.14.04.1
-- PHP Version: 5.5.9-1ubuntu4.20

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `cs3220stu15`
--

-- --------------------------------------------------------

--
-- Table structure for table `archives`
--

CREATE TABLE IF NOT EXISTS `archives` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `item` varchar(255) DEFAULT NULL,
  `state` varchar(10) NOT NULL DEFAULT 'NOTDONE',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=45 ;

--
-- Dumping data for table `archives`
--

INSERT INTO `archives` (`id`, `item`, `state`) VALUES
(41, 'Hi', 'archived'),
(42, 'hi', 'archived');

-- --------------------------------------------------------

--
-- Table structure for table `employees`
--

CREATE TABLE IF NOT EXISTS `employees` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `supervisor_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `employees`
--

INSERT INTO `employees` (`id`, `first_name`, `last_name`, `address`, `supervisor_id`) VALUES
(1, 'Tom', 'Smith', '123 Main St.', NULL),
(2, 'Jane', 'Doe', 'Street #711', 1);

-- --------------------------------------------------------

--
-- Table structure for table `finals`
--

CREATE TABLE IF NOT EXISTS `finals` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL,
  `link` varchar(255) NOT NULL,
  `vote` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=9 ;

--
-- Dumping data for table `finals`
--

INSERT INTO `finals` (`id`, `title`, `link`, `vote`) VALUES
(1, 'My Home Page', 'http://cs3.calstatela.edu:8080/cs3220stu15/Assignment.html', 3),
(2, 'School Website', 'http://csns.calstatela.edu/', -4),
(3, 'Testing Website/Google Hello', 'https://www.google.com/webhp?sourceid=chrome-instant&ion=1&espv=2&ie=UTF-8#q=hello', 5);

-- --------------------------------------------------------

--
-- Table structure for table `guestbook`
--

CREATE TABLE IF NOT EXISTS `guestbook` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `message` varchar(8000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `guestbook`
--

INSERT INTO `guestbook` (`id`, `name`, `message`) VALUES
(1, 'john', 'hello'),
(2, 'joe', 'hi');

-- --------------------------------------------------------

--
-- Table structure for table `items`
--

CREATE TABLE IF NOT EXISTS `items` (
  `name` varchar(32) DEFAULT NULL,
  `price` decimal(8,2) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `items`
--

INSERT INTO `items` (`name`, `price`, `quantity`) VALUES
('milk', 3.89, 2),
('beer', 6.99, 1);

-- --------------------------------------------------------

--
-- Table structure for table `online_store_items`
--

CREATE TABLE IF NOT EXISTS `online_store_items` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `price` int(11) NOT NULL DEFAULT '0',
  `detail` varchar(500) NOT NULL,
  `quantity` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=13 ;

--
-- Dumping data for table `online_store_items`
--

INSERT INTO `online_store_items` (`id`, `name`, `price`, `detail`, `quantity`) VALUES
(1, 'Harry Potter', 20, 'The Boy Who Lived', 100),
(10, 'H', 22, 'jh', 3);

-- --------------------------------------------------------

--
-- Table structure for table `order_histories`
--

CREATE TABLE IF NOT EXISTS `order_histories` (
  `order_id` varchar(255) NOT NULL,
  `product_name` varchar(255) NOT NULL,
  `quantity` int(11) NOT NULL,
  `price` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `projects`
--

CREATE TABLE IF NOT EXISTS `projects` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `leader_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Dumping data for table `projects`
--

INSERT INTO `projects` (`id`, `name`, `leader_id`) VALUES
(3, 'Firestone', 1),
(4, 'ToDO', 2);

-- --------------------------------------------------------

--
-- Table structure for table `project_members`
--

CREATE TABLE IF NOT EXISTS `project_members` (
  `project_id` int(11) DEFAULT NULL,
  `member_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `todolists`
--

CREATE TABLE IF NOT EXISTS `todolists` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `item` varchar(255) DEFAULT NULL,
  `state` varchar(10) NOT NULL DEFAULT 'NOTDONE',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=11 ;

--
-- Dumping data for table `todolists`
--

INSERT INTO `todolists` (`id`, `item`, `state`) VALUES
(10, 'h', 'done');

-- --------------------------------------------------------

--
-- Table structure for table `total_costs`
--

CREATE TABLE IF NOT EXISTS `total_costs` (
  `order_id` varchar(255) NOT NULL,
  `total` int(11) NOT NULL,
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
