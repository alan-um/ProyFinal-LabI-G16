-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 31-05-2024 a las 22:39:54
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `gimnasiog16`
--
CREATE DATABASE IF NOT EXISTS `gimnasiog16` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `gimnasiog16`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `asistencia`
--

CREATE TABLE `asistencia` (
  `idAsistencia` int(11) NOT NULL,
  `idSocio` int(11) NOT NULL,
  `idClase` int(11) NOT NULL,
  `fAsistencia` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clase`
--

CREATE TABLE `clase` (
  `idClase` int(11) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `idEntrenador` int(11) NOT NULL,
  `horario` time NOT NULL,
  `capacidad` int(11) NOT NULL,
  `estado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Volcado de datos para la tabla `clase`
--

INSERT INTO `clase` (`idClase`, `nombre`, `idEntrenador`, `horario`, `capacidad`, `estado`) VALUES
(1, 'Spinning', 1, '15:00:00', 7, 1),
(2, 'CrossFit', 2, '18:00:00', 10, 1),
(3, 'Running', 2, '08:00:00', 15, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `entrenador`
--

CREATE TABLE `entrenador` (
  `idEntrenador` int(11) NOT NULL,
  `dni` int(11) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `apellido` varchar(30) NOT NULL,
  `especialidad` varchar(30) NOT NULL,
  `estado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Volcado de datos para la tabla `entrenador`
--

INSERT INTO `entrenador` (`idEntrenador`, `dni`, `nombre`, `apellido`, `especialidad`, `estado`) VALUES
(1, 37123654, 'Roberto', 'Musloduro', 'Spinning, Musculación, Indoor', 1),
(2, 41654123, 'Fernanda', 'Correa', 'Running, CrossFit', 1),
(3, 32999555, 'Jose', 'Picapiedra', 'Musculación', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `membresia`
--

CREATE TABLE `membresia` (
  `idMembresia` int(11) NOT NULL,
  `idSocio` int(11) NOT NULL,
  `cantPases` int(11) NOT NULL,
  `fInicio` date NOT NULL,
  `fFin` date NOT NULL,
  `costo` double NOT NULL,
  `estado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `socio`
--

CREATE TABLE `socio` (
  `idSocio` int(11) NOT NULL,
  `dni` int(11) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `apellido` varchar(30) NOT NULL,
  `edad` int(11) NOT NULL,
  `correo` varchar(50) NOT NULL,
  `telefono` varchar(30) NOT NULL,
  `estado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Volcado de datos para la tabla `socio`
--

INSERT INTO `socio` (`idSocio`, `dni`, `nombre`, `apellido`, `edad`, `correo`, `telefono`, `estado`) VALUES
(1, 25333555, 'Maximiliano', 'Balestrieri', 41, 'maxi@gmail.com', '1122334455', 1),
(2, 39666444, 'Nahir', 'Ramos Molina', 27, 'nanahir@gmail.com', '2664445555', 1),
(3, 34777999, 'Alan', 'Urquiza Manzanelli', 35, 'alan@gmail.com', '2664343434', 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `asistencia`
--
ALTER TABLE `asistencia`
  ADD PRIMARY KEY (`idAsistencia`),
  ADD KEY `idSocio` (`idSocio`),
  ADD KEY `idClase` (`idClase`);

--
-- Indices de la tabla `clase`
--
ALTER TABLE `clase`
  ADD PRIMARY KEY (`idClase`),
  ADD KEY `idEntrenador` (`idEntrenador`);

--
-- Indices de la tabla `entrenador`
--
ALTER TABLE `entrenador`
  ADD PRIMARY KEY (`idEntrenador`),
  ADD UNIQUE KEY `dni` (`dni`);

--
-- Indices de la tabla `membresia`
--
ALTER TABLE `membresia`
  ADD PRIMARY KEY (`idMembresia`),
  ADD KEY `idSocio` (`idSocio`);

--
-- Indices de la tabla `socio`
--
ALTER TABLE `socio`
  ADD PRIMARY KEY (`idSocio`),
  ADD UNIQUE KEY `dni` (`dni`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `asistencia`
--
ALTER TABLE `asistencia`
  MODIFY `idAsistencia` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `clase`
--
ALTER TABLE `clase`
  MODIFY `idClase` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `entrenador`
--
ALTER TABLE `entrenador`
  MODIFY `idEntrenador` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `membresia`
--
ALTER TABLE `membresia`
  MODIFY `idMembresia` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `socio`
--
ALTER TABLE `socio`
  MODIFY `idSocio` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `asistencia`
--
ALTER TABLE `asistencia`
  ADD CONSTRAINT `asistencia_ibfk_1` FOREIGN KEY (`idSocio`) REFERENCES `socio` (`idSocio`),
  ADD CONSTRAINT `asistencia_ibfk_2` FOREIGN KEY (`idClase`) REFERENCES `clase` (`idClase`);

--
-- Filtros para la tabla `clase`
--
ALTER TABLE `clase`
  ADD CONSTRAINT `clase_ibfk_1` FOREIGN KEY (`idEntrenador`) REFERENCES `entrenador` (`idEntrenador`);

--
-- Filtros para la tabla `membresia`
--
ALTER TABLE `membresia`
  ADD CONSTRAINT `membresia_ibfk_1` FOREIGN KEY (`idSocio`) REFERENCES `socio` (`idSocio`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
