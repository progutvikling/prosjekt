--
-- Put in the create table statements here...
--

delimiter $$

CREATE DATABASE `PictureBrowser` /*!40100 DEFAULT CHARACTER SET latin1 */$$

CREATE TABLE `images` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `url` varchar(64) DEFAULT NULL,
  `blocked` tinyint(1) DEFAULT NULL,
  `external_id` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1$$
