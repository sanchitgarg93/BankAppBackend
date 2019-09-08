-- phpMyAdmin SQL Dump
-- version 4.3.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Sep 08, 2019 at 11:56 PM
-- Server version: 5.6.24
-- PHP Version: 5.6.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `bankapp`
--

-- --------------------------------------------------------

--
-- Table structure for table `appointment`
--

CREATE TABLE IF NOT EXISTS `appointment` (
  `id` bigint(20) NOT NULL,
  `date` date DEFAULT NULL,
  `purpose` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `sub_purpose` varchar(255) DEFAULT NULL,
  `branch_id` bigint(20) DEFAULT NULL,
  `customer_phone` varchar(255) DEFAULT NULL,
  `staff_user_name` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `appointment`
--

INSERT INTO `appointment` (`id`, `date`, `purpose`, `status`, `sub_purpose`, `branch_id`, `customer_phone`, `staff_user_name`) VALUES
(6, '2019-09-09', 'Account', 0, 'Account Creation', 1, '9873797189', 'staff1@gmail.com'),
(7, '2019-09-22', 'Digital Banking services', 0, 'Internet Banking Activate', 1, '9999209435', 'staff2@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `branch`
--

CREATE TABLE IF NOT EXISTS `branch` (
  `id` bigint(20) NOT NULL,
  `city` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `pincode` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `branch`
--

INSERT INTO `branch` (`id`, `city`, `name`, `pincode`, `state`) VALUES
(1, 'BANGALORE', 'Chickpet', '560053', 'KARNATAKA'),
(2, 'BANGALORE', 'Wilson Garden', '560027', 'KARNATAKA'),
(3, 'BANGALORE', 'J P Nagar', '560076', 'KARNATAKA'),
(4, 'BANGALORE', 'Cantonment', '560042', 'KARNATAKA'),
(5, 'DELHI', 'Pitampura', '110088', 'DELHI');

-- --------------------------------------------------------

--
-- Table structure for table `branch_head_policy`
--

CREATE TABLE IF NOT EXISTS `branch_head_policy` (
  `id` bigint(20) NOT NULL,
  `is_enable_mail_notification` bit(1) NOT NULL,
  `is_enablesmsnotification` bit(1) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE IF NOT EXISTS `customer` (
  `phone` varchar(255) NOT NULL,
  `ishni` bit(1) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`phone`, `ishni`, `name`) VALUES
('9873797189', b'0', 'Customer 1'),
('9999209435', b'1', 'Dan');

-- --------------------------------------------------------

--
-- Table structure for table `hibernate_sequence`
--

CREATE TABLE IF NOT EXISTS `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(8),
(8),
(8);

-- --------------------------------------------------------

--
-- Table structure for table `staff_customer_appointment`
--

CREATE TABLE IF NOT EXISTS `staff_customer_appointment` (
  `id` bigint(20) NOT NULL,
  `user_name` varchar(255) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `staff_customer_appointment`
--

INSERT INTO `staff_customer_appointment` (`id`, `user_name`) VALUES
(7, 'staff1@mail.com');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `dtype` varchar(31) NOT NULL,
  `user_name` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `role` int(11) DEFAULT NULL,
  `branch_id` bigint(20) DEFAULT NULL,
  `policy_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`dtype`, `user_name`, `name`, `password`, `phone`, `role`, `branch_id`, `policy_id`) VALUES
('BranchHead', 'sanchitgarg2012@gmail.com', 'Branch Head 1', '1234', NULL, 0, NULL, NULL),
('BranchHead', 'branchhead2@gmail.com', 'Branch Head 2', '1234', NULL, 0, NULL, NULL),
('BranchHead', 'branchhead3@gmail.com', 'Branch Head 3', '1234', NULL, 0, NULL, NULL),
('BranchHead', 'branchhead4@gmail.com', 'Branch Head 2', '1234', NULL, 0, NULL, NULL),
('BranchHead', 'branchhead5@gmail.com', 'Branch Head 5', '1234', NULL, 0, NULL, NULL),
('Staff', 'staff1@gmail.com', 'Staff 1', '1234', NULL, 1, NULL, NULL),
('Staff', 'staff2@gmail.com', 'Staff 2', '1234', NULL, 1, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `user_appointment_reservation`
--

CREATE TABLE IF NOT EXISTS `user_appointment_reservation` (
  `staff_user_name` varchar(255) NOT NULL,
  `appointment_reservation_id` bigint(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `user_owned_braches`
--

CREATE TABLE IF NOT EXISTS `user_owned_braches` (
  `branch_head_user_name` varchar(255) NOT NULL,
  `owned_braches_id` bigint(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_owned_braches`
--

INSERT INTO `user_owned_braches` (`branch_head_user_name`, `owned_braches_id`) VALUES
('sanchitgarg2012@gmail.com', 1);

-- --------------------------------------------------------

--
-- Table structure for table `user_owned_branches`
--

CREATE TABLE IF NOT EXISTS `user_owned_branches` (
  `branch_head_user_name` varchar(255) NOT NULL,
  `owned_branches_id` bigint(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_owned_branches`
--

INSERT INTO `user_owned_branches` (`branch_head_user_name`, `owned_branches_id`) VALUES
('sanchitgarg2012@gmail.com', 1),
('branchhead2@gmail.com', 2),
('branchhead3@gmail.com', 3),
('branchhead4@gmail.com', 4),
('branchhead5@gmail.com', 5);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `appointment`
--
ALTER TABLE `appointment`
  ADD PRIMARY KEY (`id`), ADD KEY `FKirq7r526btqxyk1gsuq4wa2h3` (`branch_id`), ADD KEY `FKc1pbww2pyk8a91w5s6pva37sc` (`customer_phone`), ADD KEY `FKa99gramufm8t0q0b01xhnotuw` (`staff_user_name`);

--
-- Indexes for table `branch`
--
ALTER TABLE `branch`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `branch_head_policy`
--
ALTER TABLE `branch_head_policy`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`phone`);

--
-- Indexes for table `staff_customer_appointment`
--
ALTER TABLE `staff_customer_appointment`
  ADD KEY `FKq0sub5h7vcyaeq4pabffiektd` (`user_name`), ADD KEY `FK2qeny82848j892x5jwsv9wdhf` (`id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`user_name`), ADD KEY `FK9yy0ya980j002yvtxi9r7kv6b` (`branch_id`), ADD KEY `FKcpa04x9ru6x2fgd56q8lckt2y` (`policy_id`);

--
-- Indexes for table `user_appointment_reservation`
--
ALTER TABLE `user_appointment_reservation`
  ADD UNIQUE KEY `UK_k8vb6edc9jomf3apk32ovwhdy` (`appointment_reservation_id`), ADD KEY `FKhnj8yxkif8b8u8t9a009qidot` (`staff_user_name`);

--
-- Indexes for table `user_owned_braches`
--
ALTER TABLE `user_owned_braches`
  ADD KEY `FKih3lfdl3ooexod1456lgby3dr` (`owned_braches_id`), ADD KEY `FK9ty2pkc7odb0ftjtymadg2wdj` (`branch_head_user_name`);

--
-- Indexes for table `user_owned_branches`
--
ALTER TABLE `user_owned_branches`
  ADD KEY `FK7ul81miafvniewvq41jov0hro` (`owned_branches_id`), ADD KEY `FKj5jiq8nxn174313srlot4gnfp` (`branch_head_user_name`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
