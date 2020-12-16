-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 16-12-2020 a las 19:46:16
-- Versión del servidor: 10.4.14-MariaDB
-- Versión de PHP: 7.4.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `libreria`
--

DELIMITER $$
--
-- Procedimientos
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `modificarLibro` (IN `myISBN` VARCHAR(13), IN `myAutor` VARCHAR(50), IN `myTitulo` VARCHAR(50), IN `myEditorial` VARCHAR(50), IN `myCantidad` INT(11), IN `myPrecio` FLOAT, IN `myTematica` TINYINT(126), OUT `message` BOOLEAN)  NO SQL
BEGIN

UPDATE `libro` SET `autor`=myAutor,`titulo`=myTitulo,`editorial`=myEditorial,`cantidad`=myCantidad,`precio`=myPrecio,`tematica`=myTematica WHERE `isbn` = myISBN;

SET message=true;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `registrarLibro` (IN `myISBN` VARCHAR(13), IN `myAutor` VARCHAR(50), IN `myTitulo` VARCHAR(50), IN `myEditorial` VARCHAR(50), IN `myTematica` TINYINT(126), IN `myEstado` TINYINT(126), IN `myFormato` TINYINT(126), IN `myCantidad` INT(11), IN `myPrecio` FLOAT, OUT `message` BOOLEAN)  NO SQL
BEGIN
INSERT INTO `libro`(`isbn`, `autor`, `titulo`, `editorial`, `tematica`, `estado`, `formato`, `cantidad`, `precio`) VALUES (myISBN,myAutor,myTitulo,myEditorial,myTematica,myEstado,myFormato,myCantidad,myPrecio);
END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estado`
--

CREATE TABLE `estado` (
  `id` tinyint(126) NOT NULL,
  `nombre` varchar(50) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `estado`
--

INSERT INTO `estado` (`id`, `nombre`) VALUES
(2, 'Novedad'),
(1, 'Reedición');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `formato`
--

CREATE TABLE `formato` (
  `id` tinyint(126) NOT NULL,
  `nombre` varchar(50) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `formato`
--

INSERT INTO `formato` (`id`, `nombre`) VALUES
(1, 'Cartoné'),
(2, 'Rústica'),
(3, 'Grapada'),
(4, 'Espiral');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `libro`
--

CREATE TABLE `libro` (
  `id` int(11) NOT NULL,
  `isbn` varchar(13) COLLATE utf8_unicode_ci NOT NULL,
  `autor` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `titulo` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `editorial` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `tematica` tinyint(126) NOT NULL,
  `estado` tinyint(126) NOT NULL,
  `formato` tinyint(126) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `precio` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `libro`
--

INSERT INTO `libro` (`id`, `isbn`, `autor`, `titulo`, `editorial`, `tematica`, `estado`, `formato`, `cantidad`, `precio`) VALUES
(18, '1111111111111', 'asda', 'asdasd', 'sasd', 1, 1, 1, 3, 15),
(20, '2222222222222', 'sadad', 'asdasd', 'asda', 3, 1, 1, 2, 188),
(21, '3333333333333', 'asda', 'asdas', 'sad', 6, 2, 2, 1, 14.25),
(23, '8888888888888', 'asda', 'sadas', 'asda', 4, 1, 1, 2, 17),
(24, '9999999999999', 'sdffffff', 'cinco', 'sdfs', 1, 2, 2, 6, 123);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tematica`
--

CREATE TABLE `tematica` (
  `id` tinyint(126) NOT NULL,
  `nombre` varchar(50) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `tematica`
--

INSERT INTO `tematica` (`id`, `nombre`) VALUES
(8, 'Biografía'),
(5, 'Ciencia'),
(6, 'Historia'),
(3, 'Misterio'),
(7, 'Música'),
(9, 'Poesía'),
(4, 'Romance'),
(1, 'Suspense'),
(2, 'Terror');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `estado`
--
ALTER TABLE `estado`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `nombre` (`nombre`);

--
-- Indices de la tabla `formato`
--
ALTER TABLE `formato`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `libro`
--
ALTER TABLE `libro`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `isbn` (`isbn`),
  ADD KEY `tematica` (`tematica`),
  ADD KEY `estado` (`estado`),
  ADD KEY `formato` (`formato`);

--
-- Indices de la tabla `tematica`
--
ALTER TABLE `tematica`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `nombre` (`nombre`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `estado`
--
ALTER TABLE `estado`
  MODIFY `id` tinyint(126) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `formato`
--
ALTER TABLE `formato`
  MODIFY `id` tinyint(126) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `libro`
--
ALTER TABLE `libro`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;

--
-- AUTO_INCREMENT de la tabla `tematica`
--
ALTER TABLE `tematica`
  MODIFY `id` tinyint(126) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `libro`
--
ALTER TABLE `libro`
  ADD CONSTRAINT `libro_ibfk_1` FOREIGN KEY (`estado`) REFERENCES `estado` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `libro_ibfk_2` FOREIGN KEY (`formato`) REFERENCES `formato` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `libro_ibfk_3` FOREIGN KEY (`tematica`) REFERENCES `tematica` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
