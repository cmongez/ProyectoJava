-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 26, 2023 at 10:00 PM
-- Server version: 10.4.27-MariaDB
-- PHP Version: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ficticia`
--

-- --------------------------------------------------------

--
-- Table structure for table `cargo`
--

CREATE TABLE `cargo` (
  `ID_CARGO` int(11) NOT NULL,
  `ID_TIPO_CARGO` int(11) NOT NULL,
  `NOMBRE_CARGO` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `cargo`
--

INSERT INTO `cargo` (`ID_CARGO`, `ID_TIPO_CARGO`, `NOMBRE_CARGO`) VALUES
(1, 1, 'Full Stack'),
(2, 1, 'Frontend'),
(3, 1, 'Backend'),
(4, 2, 'Cloud Engineer');

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `ID_ADMIN` int(11) NOT NULL,
  `CORREO` varchar(45) NOT NULL,
  `CONTRASENIA` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`ID_ADMIN`, `CORREO`, `CONTRASENIA`) VALUES
(1, 'admin@admin.com', '1234');

-- --------------------------------------------------------

--
-- Table structure for table `tipo_cargo`
--

CREATE TABLE `tipo_cargo` (
  `ID_TIPO_CARGO` int(11) NOT NULL,
  `NOMBRE_TIPO_CARGO` varchar(45) NOT NULL,
  `DESCRIPCION_TIPO_CARGO` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tipo_cargo`
--

INSERT INTO `tipo_cargo` (`ID_TIPO_CARGO`, `NOMBRE_TIPO_CARGO`, `DESCRIPCION_TIPO_CARGO`) VALUES
(1, 'Developer', 'Desarrolladores '),
(2, 'SRE / DevOps', 'Nube');

-- --------------------------------------------------------

--
-- Table structure for table `usuario`
--

CREATE TABLE `usuario` (
  `RUT` varchar(12) NOT NULL,
  `DV` char(1) NOT NULL,
  `NOMBRES` varchar(25) NOT NULL,
  `APELLIDOS` varchar(25) NOT NULL,
  `CORREO` varchar(45) NOT NULL,
  `FECHA_NACIMIENTO` varchar(10) NOT NULL,
  `GENERO` varchar(25) NOT NULL,
  `FECHA_CONTRATACION` varchar(10) NOT NULL,
  `TELEFONO_USUARIO` varchar(12) DEFAULT NULL,
  `ID_CARGO` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `usuario`
--

INSERT INTO `usuario` (`RUT`, `DV`, `NOMBRES`, `APELLIDOS`, `CORREO`, `FECHA_NACIMIENTO`, `GENERO`, `FECHA_CONTRATACION`, `TELEFONO_USUARIO`, `ID_CARGO`) VALUES
('122', '2', 'Bad', 'Bunny', 'a2222@admin.com', '1996-06-28', 'Masculino', '2023-06-27', '951545421', 1),
('222225', '2', 'Maria', 'Perez', 'usuario2@example.com', '1990-02-02', 'Femenino', '2023-01-01', '23456789', 1),
('26579154', '9', 'César', 'Mongez', '33@admin.com', '1996-28-06', 'Masculino', '2023-06-14', '3332525', 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `cargo`
--
ALTER TABLE `cargo`
  ADD PRIMARY KEY (`ID_CARGO`),
  ADD KEY `cargo_ibfk_1` (`ID_TIPO_CARGO`);

--
-- Indexes for table `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`ID_ADMIN`);

--
-- Indexes for table `tipo_cargo`
--
ALTER TABLE `tipo_cargo`
  ADD PRIMARY KEY (`ID_TIPO_CARGO`);

--
-- Indexes for table `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`RUT`),
  ADD KEY `usuario_ibfk_1` (`ID_CARGO`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `cargo`
--
ALTER TABLE `cargo`
  MODIFY `ID_CARGO` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=177;

--
-- AUTO_INCREMENT for table `login`
--
ALTER TABLE `login`
  MODIFY `ID_ADMIN` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `tipo_cargo`
--
ALTER TABLE `tipo_cargo`
  MODIFY `ID_TIPO_CARGO` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=651;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `cargo`
--
ALTER TABLE `cargo`
  ADD CONSTRAINT `cargo_ibfk_1` FOREIGN KEY (`ID_TIPO_CARGO`) REFERENCES `tipo_cargo` (`ID_TIPO_CARGO`);

--
-- Constraints for table `usuario`
--
ALTER TABLE `usuario`
  ADD CONSTRAINT `usuario_ibfk_1` FOREIGN KEY (`ID_CARGO`) REFERENCES `cargo` (`ID_CARGO`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
