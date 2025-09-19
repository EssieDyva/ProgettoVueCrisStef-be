-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Creato il: Set 19, 2025 alle 09:21
-- Versione del server: 10.4.32-MariaDB
-- Versione PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `fermate`
--

-- --------------------------------------------------------

--
-- Struttura della tabella `fermate`
--

CREATE TABLE `fermate` (
  `ID_FERMATA` int(11) NOT NULL,
  `NUMERO_LINEA` int(11) NOT NULL,
  `NOME_FERMATA` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dump dei dati per la tabella `fermate`
--

INSERT INTO `fermate` (`ID_FERMATA`, `NUMERO_LINEA`, `NOME_FERMATA`) VALUES
(1, 1, 'Via delle Rose'),
(2, 1, 'Piazza Luna'),
(3, 1, 'Viale dei Tigli'),
(4, 1, 'Corso Aurora'),
(5, 1, 'Largo Sole'),
(6, 2, 'Via del Mare'),
(7, 2, 'Piazza dei Fiori'),
(8, 2, 'Viale Tramonto'),
(9, 2, 'Corso Italia'),
(10, 2, 'Via Colline Verdi'),
(11, 3, 'Piazza Centrale'),
(12, 3, 'Via Lago Blu'),
(13, 3, 'Viale dei Platani'),
(14, 3, 'Largo Nuvola'),
(15, 3, 'Via Stella Alpina');

-- --------------------------------------------------------

--
-- Struttura della tabella `numeri_linea`
--

CREATE TABLE `numeri_linea` (
  `ID_LINEA` int(11) NOT NULL,
  `NUMERO_LINEA` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dump dei dati per la tabella `numeri_linea`
--

INSERT INTO `numeri_linea` (`ID_LINEA`, `NUMERO_LINEA`) VALUES
(1, 1),
(2, 2),
(3, 3);

--
-- Indici per le tabelle scaricate
--

--
-- Indici per le tabelle `fermate`
--
ALTER TABLE `fermate`
  ADD PRIMARY KEY (`ID_FERMATA`),
  ADD KEY `NUMERO_LINEA` (`NUMERO_LINEA`);

--
-- Indici per le tabelle `numeri_linea`
--
ALTER TABLE `numeri_linea`
  ADD PRIMARY KEY (`ID_LINEA`);

--
-- AUTO_INCREMENT per le tabelle scaricate
--

--
-- AUTO_INCREMENT per la tabella `fermate`
--
ALTER TABLE `fermate`
  MODIFY `ID_FERMATA` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- Limiti per le tabelle scaricate
--

--
-- Limiti per la tabella `fermate`
--
ALTER TABLE `fermate`
  ADD CONSTRAINT `fermate_ibfk_1` FOREIGN KEY (`NUMERO_LINEA`) REFERENCES `numeri_linea` (`ID_LINEA`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
