-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 22-02-2024 a las 17:03:55
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `booking`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `flight`
--

CREATE TABLE `flight` (
  `id` bigint(20) NOT NULL,
  `date` date DEFAULT NULL,
  `destination` varchar(255) DEFAULT NULL,
  `flight_number` varchar(255) DEFAULT NULL,
  `flight_price` double DEFAULT NULL,
  `is_booked` bit(1) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `origin` varchar(255) DEFAULT NULL,
  `seat_type` varchar(255) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `flight`
--

INSERT INTO `flight` (`id`, `date`, `destination`, `flight_number`, `flight_price`, `is_booked`, `name`, `origin`, `seat_type`, `user_id`) VALUES
(1, '2024-03-10', 'Miami', 'BAMI-1235', 650, b'1', 'Iberia', 'Barcelona', 'Economy', 1),
(2, '2024-02-10', 'Madrid', 'MIMA1420', 4320, b'0', 'Iberia', 'Miami', 'Business', NULL),
(3, '2024-02-10', 'Madrid', 'MIMA-1420', 2573, b'0', 'Iberia', 'Miami', 'Economy', NULL),
(4, '2024-02-10', 'Buenos Aires', 'BABU-5536', 732, b'0', 'Iberia', 'Barcelona', 'Economy', NULL),
(5, '2024-02-12', 'Barcelona', 'BUBA-3369', 1253, b'0', 'Iberia', 'Buenos Aires', 'Business', NULL),
(6, '2024-01-02', 'Barcelona', 'IGBA-3369', 540, b'1', 'Iberia', 'Iguazú', 'Economy', 2),
(7, '2024-01-23', 'Cartagena', 'BOCA-4213', 800, b'0', 'Iberia', 'Bogotá', 'Economy', NULL),
(8, '2024-02-15', 'Iguazú', 'BOCA-4213', 570, b'0', 'Iberia', 'Bogotá', 'Business', NULL),
(9, '2024-01-23', 'Medellín', 'CAME-0321', 780, b'0', 'Iberia', 'Cartagena', 'Economy', NULL),
(10, '2024-03-01', 'Buenos Aires', 'BOBA-6567', 398, b'0', 'Iberia', 'Bogotá', 'Economy', NULL),
(11, '2024-02-10', 'Madrid', 'BOMA-4442', 1100, b'0', 'Iberia', 'Bogotá', 'Economy', NULL),
(12, '2024-02-17', 'Miami', 'MEMI-9986', 1164, b'0', 'Iberia', 'Medellín', 'Business', NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `hotel`
--

CREATE TABLE `hotel` (
  `id` bigint(20) NOT NULL,
  `city` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `hotel`
--

INSERT INTO `hotel` (`id`, `city`, `code`, `name`) VALUES
(1, 'Miami', 'AR-0002', 'Atlantis Resort'),
(2, 'Miami', 'AR-0003', 'Atlantis Resort 2'),
(3, 'Buenos Aires', 'RC-0001', 'Ritz-Carlton'),
(4, 'Medellín', 'RC-0002', 'Ritz-Carlton 2'),
(5, 'Madrid', 'GH-0002', 'Grand Hyatt'),
(6, 'Buenos Aires', 'GH-0001', 'Grand Hyatt 2'),
(7, 'Barcelona', 'HL-0001', 'Hilton'),
(8, 'Barcelona', 'HL-0002', 'Hilton 2'),
(9, 'Barcelona', 'MT-0003', 'Marriott'),
(10, 'Madrid', 'SH-0004', 'Sheraton'),
(11, 'Iguazú', 'SH-0002', 'Sheraton 2'),
(12, 'Cartagena', 'IR-0004', 'InterContinental');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `room`
--

CREATE TABLE `room` (
  `id` bigint(20) NOT NULL,
  `booked` bit(1) DEFAULT NULL,
  `check_in` date DEFAULT NULL,
  `check_out` date DEFAULT NULL,
  `price` double DEFAULT NULL,
  `room_number` int(11) NOT NULL,
  `type` int(11) NOT NULL,
  `hotel_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `room`
--

INSERT INTO `room` (`id`, `booked`, `check_in`, `check_out`, `price`, `room_number`, `type`, `hotel_id`, `user_id`) VALUES
(1, b'0', '2024-02-10', '2024-03-20', 630, 85, 2, 1, NULL),
(2, b'0', '2024-02-10', '2024-03-23', 820, 85, 3, 2, NULL),
(3, b'0', '2024-02-10', '2024-03-19', 543, 5, 1, 3, NULL),
(4, b'0', '2024-02-12', '2024-04-17', 720, 15, 2, 4, NULL),
(5, b'0', '2024-04-17', '2024-05-23', 579, 15, 2, 5, NULL),
(6, b'0', '2024-01-02', '2024-02-19', 415, 2, 1, 6, NULL),
(7, b'0', '2024-01-23', '2024-11-23', 390, 29, 1, 7, NULL),
(8, b'0', '2024-01-23', '2024-10-15', 584, 29, 2, 8, NULL),
(9, b'0', '2024-02-15', '2024-03-27', 702, 29, 2, 9, NULL),
(10, b'0', '2024-03-01', '2024-04-17', 860, 29, 3, 10, NULL),
(11, b'0', '2024-02-10', '2024-03-20', 640, 229, 2, 11, NULL),
(12, b'1', '2024-04-17', '2024-06-12', 937, 229, 3, 12, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `user`
--

CREATE TABLE `user` (
  `id` bigint(20) NOT NULL,
  `age` int(11) NOT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `user`
--

INSERT INTO `user` (`id`, `age`, `last_name`, `name`) VALUES
(1, 0, 'LastNameII', 'UserII'),
(2, 0, 'LastNameI', 'UserI'),
(3, 0, 'LastNameI', 'UserI'),
(4, 0, 'LastNameI', 'UserI'),
(5, 0, 'LastNameI', 'UserI'),
(6, 0, 'LastNameI', 'UserI'),
(7, 0, 'LastNameI', 'UserI');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `flight`
--
ALTER TABLE `flight`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKsybl41p362b1vsb506td0led2` (`user_id`);

--
-- Indices de la tabla `hotel`
--
ALTER TABLE `hotel`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `room`
--
ALTER TABLE `room`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKdosq3ww4h9m2osim6o0lugng8` (`hotel_id`),
  ADD KEY `FKj8a5tk6wghd3x2sxgksj2fv3o` (`user_id`);

--
-- Indices de la tabla `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `flight`
--
ALTER TABLE `flight`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT de la tabla `hotel`
--
ALTER TABLE `hotel`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT de la tabla `room`
--
ALTER TABLE `room`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT de la tabla `user`
--
ALTER TABLE `user`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `flight`
--
ALTER TABLE `flight`
  ADD CONSTRAINT `FKsybl41p362b1vsb506td0led2` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);

--
-- Filtros para la tabla `room`
--
ALTER TABLE `room`
  ADD CONSTRAINT `FKdosq3ww4h9m2osim6o0lugng8` FOREIGN KEY (`hotel_id`) REFERENCES `hotel` (`id`),
  ADD CONSTRAINT `FKj8a5tk6wghd3x2sxgksj2fv3o` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
