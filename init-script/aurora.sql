-- Create database
CREATE DATABASE aurora;

-- Create user
CREATE USER 'aurora'@'%' IDENTIFIED BY 'password';

-- Grant privileges for the identity database
GRANT ALL PRIVILEGES ON aurora.* TO 'aurora'@'%';

-- Apply the changes
FLUSH PRIVILEGES;

-- Connect to the newly created database
USE aurora;

-- --------------------------------------------------------

--
-- Structure of the songs table
--

CREATE TABLE `songs` (
  `song_id` varchar(22) PRIMARY KEY,
  `song_name` varchar(194),
  `billboard` varchar(112),
  `artists` text,
  `popularity` tinyint,
  `explicit` varchar(5),
  `song_type` varchar(13)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Structure of the acoustic_features table
--

CREATE TABLE `acoustic_features` (
  `song_id` varchar(22) PRIMARY KEY,
  `duration_ms` MEDIUMINT UNSIGNED,
  `key` TINYINT,
  `mode` TINYINT,
  `time_signature` TINYINT,
  `acousticness` decimal(11,6),
  `danceability` decimal(4,3),
  `energy` decimal(6,5),
  `instrumentalness` decimal(12,7),
  `liveness` decimal(5,4),
  `loudness` decimal(6,3),
  `speechiness` decimal(6,4),
  `valence` decimal(5,4),
  `tempo` decimal(6,3),
  FOREIGN KEY (`song_id`) REFERENCES `songs` (`song_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


--
-- Structure of the song_chart table
--

CREATE TABLE `song_chart` (
  `song_id` varchar(22),
  `rank_score` SMALLINT,
  `peak_position` SMALLINT,
  `weeks_on_chart` tinyint(2),
  `week` date
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Structure of the song_pop table
--

CREATE TABLE `song_pop` (
  `song_id` varchar(22),
  `year_end_score` MEDIUMINT,
  `year` SMALLINT,
  PRIMARY KEY (`song_id`, `year`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Structure of the lyrics table
--

CREATE TABLE `lyrics` (
  `song_id` varchar(22) PRIMARY KEY,
  `lyrics` mediumtext COLLATE utf8_general_mysql500_ci
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_mysql500_ci;


--
-- Structure of the album table
--

CREATE TABLE `albums` (
  `album_id` varchar(22) PRIMARY KEY,
  `name` varchar(292),
  `billboard` varchar(75),
  `artists` text,
  `popularity` TINYINT,
  `total_tracks` SMALLINT,
  `album_type` varchar(11),
  `image_url` varchar(64)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure of the album_chart table
--

CREATE TABLE `album_chart` (
  `album_id` varchar(22),
  `rank_score` SMALLINT,
  `peak_position` SMALLINT,
  `weeks_on_chart` SMALLINT,
  `week` date
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure of the album_pop table
--

CREATE TABLE `album_pop` (
  `album_id` varchar(22),
  `year_end_score` MEDIUMINT,
  `is_pop` varchar(5),
  `year` SMALLINT,
  PRIMARY KEY (`album_id`, `year`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------
--
-- Structure of the artist table
--

CREATE TABLE `artists` (
  `artist_id` varchar(22) PRIMARY KEY,
  `name` varchar(91),
  `followers` varchar(8),
  `popularity` SMALLINT,
  `artist_type` varchar(6),
  `main_genre` varchar(33),
  `genres` varchar(401),
  `image_url` varchar(64)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure of the artist_chart table
--

CREATE TABLE `artist_chart` (
  `artist_id` varchar(22),
  `rank_score` SMALLINT,
  `peak_position` SMALLINT,
  `weeks_on_chart` SMALLINT,
  `week` date
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


--
-- Structure of the artist_pop table
--

CREATE TABLE `artist_pop` (
  `artist_id` varchar(22),
  `year_end_score` MEDIUMINT,
  `year` SMALLINT,
   PRIMARY KEY (`artist_id`, `year`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



--
-- Structure of the releases table
--

CREATE TABLE `releases` (
  `artist_id` varchar(22),
  `album_id` varchar(22),
  `release_date` varchar(10),
  `release_date_precision` varchar(5),
  PRIMARY KEY (`artist_id`, `album_id`)
--  FOREIGN KEY (`artist_id`) REFERENCES `artists` (`artist_id`),
--  FOREIGN KEY (`album_id`) REFERENCES `albums` (`album_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



--
-- Structure of the tracks table
--

CREATE TABLE `tracks` (
  `song_id` varchar(22),
  `album_id` varchar(22),
  `track_number` SMALLINT,
  `release_date` varchar(10),
  `release_date_precision` varchar(5),
   PRIMARY KEY (`song_id`, `album_id`)
--    FOREIGN KEY (`song_id`) REFERENCES `songs` (`song_id`),
--    FOREIGN KEY (`album_id`) REFERENCES `albums` (`album_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;