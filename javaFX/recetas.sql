-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 06-01-2022 a las 20:35:26
-- Versión del servidor: 10.4.22-MariaDB
-- Versión de PHP: 8.1.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `recetas`
--

CREATE DATABASE 'recetas';
use recetas;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `recetacomida`
--

CREATE TABLE `recetacomida` (
  `Titulo` varchar(255) NOT NULL,
  `Autor` varchar(255) NOT NULL,
  `Tipo` varchar(255) NOT NULL,
  `Ingrediente` varchar(255) NOT NULL,
  `Pasos` int(10) NOT NULL,
  `NumeroComensales` int(10) NOT NULL,
  `Tiempo` int(10) NOT NULL,
  `Calorias` int(10) NOT NULL,
  `Imagen` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `recetacomida`
--

INSERT INTO `recetacomida` (`Titulo`, `Autor`, `Tipo`, `Ingrediente`, `Pasos`, `NumeroComensales`, `Tiempo`, `Calorias`, `Imagen`) VALUES
('Pollo', 'Jesus', 'Segundo', 'Pollo,Limon,Aceite,Papas,Cebolla', 8, 4, 100, 450, 'pollo.jpg'),
('Merluza', 'Jesus', 'Segundo', 'Merluza,Aceite,Pimientos,Cebolla,Tomate', 6, 4, 110, 300, 'merluza.jpg'),
('Sopa', 'Ana', 'Primero', 'Pollo,Fideos,Puerro,Papas,Cebolla', 8, 8, 120, 300, 'sopa.jpg'),
('Tortilla', 'Ana', 'Entrante', 'Papas,Cebollas,Aceite,Huevos,Perejil', 4, 8, 30, 450, 'tortilla.jpg'),
('Ensaladilla', 'Carlos', 'Entrante', 'Mayonesa,Papas,Huevo,Cebolla,Aceituna,Atun', 6, 10, 30, 300, 'ensaladilla.jpg'),
('Flan', 'Ana', 'Postre', 'Nata,Canela,Vainilla,Cafe,Leche,Azucar', 8, 4, 120, 450, 'flan.jpg'),
('Mouse de chocolate', 'Carlos', 'Postre', 'Chocolate,Yogur,Nata', 6, 14, 60, 300, 'mousechocolate.jpg'),
('Paella', 'Jesus', 'Segundo', 'Arroz,Pollo,Aceitunas,Cebolla,Conejo,Guisantes', 6, 4, 140, 500, 'paella.jpg'),
('Judias', 'Jesus', 'Primero', 'Judias,Chorizo,Pimiento,Papas,Cebolla', 10, 6, 120, 450, 'judias.jpg'),
('Papas brava', 'Jesus', 'Entrante', 'Papas,Mayonesa,Aceite,Pimenton,Salsa brava,Perejil', 6, 4, 60, 400, 'papasbravas.jpg'),
('Fabada', 'Juan', 'Primero', 'Fabada,Pimientos,Chorizo', 6, 4, 160, 450, 'food-fork-drink.png'),
('Lentejas', 'Juan', 'Primero', 'Lentejas,Zanahoria,Cebolla,Chorizo', 4, 4, 150, 500, 'food-fork-drink.png');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `users`
--

CREATE TABLE `users` (
  `nick` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `role` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `users`
--

INSERT INTO `users` (`nick`, `password`, `role`) VALUES
('admin', 'admin', 'Profesor'),
('alumno', 'alumno', 'Alumno'),
('ana', 'ana', 'Alumno'),
('daniel', 'daniel', 'Profesor'),
('juan', 'juan', 'Alumno'),
('pepe', 'pepe', 'Alumno'),
('profesor', 'profesor', 'Profesor');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`nick`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
