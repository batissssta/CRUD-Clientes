-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 03-Dez-2018 às 04:49
-- Versão do servidor: 5.6.17
-- PHP Version: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `ecomerce`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `tb_cartao_credito`
--

CREATE TABLE IF NOT EXISTS `tb_cartao_credito` (
  `crt_id` int(11) NOT NULL AUTO_INCREMENT,
  `crt_codigo_seguranca` varchar(20) DEFAULT NULL,
  `crt_numero_cartao` varchar(20) DEFAULT NULL,
  `crt_validade` date DEFAULT NULL,
  `crt_preferido` varchar(20) DEFAULT NULL,
  `crt_nome_impresso` varchar(100) DEFAULT NULL,
  `crt_bandeira` varchar(20) DEFAULT NULL,
  `crt_cli_id` int(11) NOT NULL,
  PRIMARY KEY (`crt_id`),
  KEY `ctr_cli_id` (`crt_cli_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Extraindo dados da tabela `tb_cartao_credito`
--

INSERT INTO `tb_cartao_credito` (`crt_id`, `crt_codigo_seguranca`, `crt_numero_cartao`, `crt_validade`, `crt_preferido`, `crt_nome_impresso`, `crt_bandeira`, `crt_cli_id`) VALUES
(1, '808', '8980970709890', '1969-12-31', '1', 'LUCAS BATISTA DA SILVA', 'MASTER', 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `tb_cliente`
--

CREATE TABLE IF NOT EXISTS `tb_cliente` (
  `cli_id` int(11) NOT NULL AUTO_INCREMENT,
  `cli_genero` varchar(20) DEFAULT NULL,
  `cli_data_nascimento` date DEFAULT NULL,
  `cli_email` varchar(100) DEFAULT NULL,
  `cli_status` varchar(30) DEFAULT NULL,
  `cli_cpf` varchar(15) DEFAULT NULL,
  `cli_nome` varchar(100) DEFAULT NULL,
  `cli_senha` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`cli_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Extraindo dados da tabela `tb_cliente`
--

INSERT INTO `tb_cliente` (`cli_id`, `cli_genero`, `cli_data_nascimento`, `cli_email`, `cli_status`, `cli_cpf`, `cli_nome`, `cli_senha`) VALUES
(1, 'Masculino', '1969-12-31', 'lucas.bsilva09@outlook.com', 'ATIVO', '44362907866', 'Lucas Batista da Silva', '[B@10f6c7f');

-- --------------------------------------------------------

--
-- Estrutura da tabela `tb_endereco`
--

CREATE TABLE IF NOT EXISTS `tb_endereco` (
  `end_id` int(11) NOT NULL AUTO_INCREMENT,
  `end_logradouro` varchar(100) DEFAULT NULL,
  `end_numero` varchar(10) DEFAULT NULL,
  `end_cep` varchar(10) DEFAULT NULL,
  `end_tipo_logradouro` varchar(20) DEFAULT NULL,
  `end_tipo_residencia` varchar(20) DEFAULT NULL,
  `end_tipo_endereco` varchar(20) DEFAULT NULL,
  `end_bairro` varchar(50) DEFAULT NULL,
  `end_cidade` varchar(50) DEFAULT NULL,
  `end_estado` varchar(2) DEFAULT NULL,
  `end_pais` varchar(50) DEFAULT NULL,
  `end_cli_id` int(11) NOT NULL,
  PRIMARY KEY (`end_id`),
  KEY `cli_id` (`end_cli_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Extraindo dados da tabela `tb_endereco`
--

INSERT INTO `tb_endereco` (`end_id`, `end_logradouro`, `end_numero`, `end_cep`, `end_tipo_logradouro`, `end_tipo_residencia`, `end_tipo_endereco`, `end_bairro`, `end_cidade`, `end_estado`, `end_pais`, `end_cli_id`) VALUES
(1, 'Rua Luiz Alvares de Espinha', '82', '08451310', 'OUTRO', 'CASA', 'COBRANCA', 'Guaianases', 'SÃ£o Paulo', 'SP', 'Brasil', 1),
(2, 'Rua Luiz Alvares de Espinha', '82', '08451310', 'OUTRO', 'OUTRO', 'ENTREGA', 'Guaianases', 'SÃ£o Paulo', 'SP', 'Brasil', 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `tb_telefone`
--

CREATE TABLE IF NOT EXISTS `tb_telefone` (
  `tel_id` int(11) NOT NULL AUTO_INCREMENT,
  `tel_tipo` varchar(30) DEFAULT NULL,
  `tel_ddd` varchar(4) DEFAULT NULL,
  `tel_numero` varchar(12) DEFAULT NULL,
  `tel_cli_id` int(11) NOT NULL,
  UNIQUE KEY `tel_id` (`tel_id`),
  KEY `cli_id` (`tel_cli_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Extraindo dados da tabela `tb_telefone`
--

INSERT INTO `tb_telefone` (`tel_id`, `tel_tipo`, `tel_ddd`, `tel_numero`, `tel_cli_id`) VALUES
(1, 'CELULAR', '11', '960636413', 1);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
