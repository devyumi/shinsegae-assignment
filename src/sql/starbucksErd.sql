CREATE TABLE `allergy` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `category` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(30) NOT NULL,
  `parent_category_id` INT DEFAULT NULL,
  `description` LONGTEXT,
  PRIMARY KEY (`id`)
);

CREATE TABLE `image` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `product_id` INT NOT NULL,
  `type` VARCHAR(20) NOT NULL,
  `name` VARCHAR(100) NOT NULL,
  `url` LONGTEXT NOT NULL,
  `reg_date` DATETIME NOT NULL,
  `mod_date` DATETIME DEFAULT NULL,
  `del_flag` TINYINT(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_image_product_id_idx` (`product_id`),
  CONSTRAINT `fk_image_product_id` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`)
);

CREATE TABLE `like` (
  `member_id` INT NOT NULL AUTO_INCREMENT,
  `product_id` INT NOT NULL,
  `reg_date` DATETIME NOT NULL,
  PRIMARY KEY (`member_id`,`product_id`),
  KEY `fk_like_product_id_idx` (`product_id`),
  CONSTRAINT `fk_like_member_id` FOREIGN KEY (`member_id`) REFERENCES `member` (`id`),
  CONSTRAINT `fk_like_product_id` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`)
);

CREATE TABLE `member` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `account_id` VARCHAR(30) NOT NULL,
  `password` VARCHAR(100) NOT NULL,
  `name` VARCHAR(5) NOT NULL,
  `gender` ENUM('male','female') NOT NULL DEFAULT 'male',
  `birth` DATE NOT NULL,
  `birth_type` ENUM('solar','lunar') NOT NULL DEFAULT 'solar',
  `phone` CHAR(13) NOT NULL,
  `email` VARCHAR(30) NOT NULL,
  `status` TINYINT(1) NOT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `nutrient` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `product_id` INT NOT NULL,
  `size_id` INT NOT NULL,
  `kcal` DECIMAL(6,2) NOT NULL,
  `sodium` DECIMAL(6,2) NOT NULL,
  `saturated_fat` DECIMAL(6,2) NOT NULL,
  `sugar` DECIMAL(6,2) NOT NULL,
  `protein` DECIMAL(6,2) NOT NULL,
  `caffeine` DECIMAL(6,2) NOT NULL,
  `reg_date` DATETIME NOT NULL,
  `mod_date` DATETIME DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_nutrient_product_id_idx` (`product_id`),
  KEY `fk_nutrient_size_id_idx` (`size_id`),
  CONSTRAINT `fk_nutrient_product_id` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`),
  CONSTRAINT `fk_nutrient_size_id` FOREIGN KEY (`size_id`) REFERENCES `size` (`id`)
);

CREATE TABLE `product` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `category_id` INT NOT NULL,
  `name` VARCHAR(30) NOT NULL,
  `en_name` VARCHAR(50) NOT NULL,
  `description` LONGTEXT NOT NULL,
  `reg_date` DATETIME NOT NULL,
  `mod_date` DATETIME DEFAULT NULL,
  `del_flag` TINYINT(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_product_category_id_idx` (`category_id`),
  CONSTRAINT `fk_product_category_id` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`)
);

CREATE TABLE `product_allergy` (
  `product_id` INT NOT NULL,
  `allergy_id` INT NOT NULL,
  PRIMARY KEY (`product_id`,`allergy_id`),
  KEY `fk_product_allergy_allergy_id_idx` (`allergy_id`),
  CONSTRAINT `fk_product_allergy_allergy_id` FOREIGN KEY (`allergy_id`) REFERENCES `allergy` (`id`),
  CONSTRAINT `fk_product_allergy_product_id` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`)
);

CREATE TABLE `size` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(5) NOT NULL,
  `en_name` VARCHAR(10) NOT NULL,
  `ml` DECIMAL(6,1) NOT NULL,
  `oz` DECIMAL(6,1) NOT NULL,
  PRIMARY KEY (`id`)
);
