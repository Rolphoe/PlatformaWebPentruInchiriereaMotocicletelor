CREATE TABLE `employee`
(
    `id`           int NOT NULL AUTO_INCREMENT,
    `first_name`   varchar(255) DEFAULT NULL,
    `last_name`    varchar(255) DEFAULT NULL,
    `position`     varchar(255) DEFAULT NULL,
    `branch`       varchar(255) DEFAULT NULL,
    PRIMARY KEY (`id`)
);
CREATE TABLE `customer`
(
    `id`           int NOT NULL AUTO_INCREMENT,
    `first_name`   varchar(255) DEFAULT NULL,
    `last_name`    varchar(255) DEFAULT NULL,
    `email`        varchar(255) DEFAULT NULL,
    `address`      varchar(255) DEFAULT NULL,
    PRIMARY KEY (`id`)
);
CREATE TABLE `vehicle`
(
    `id`           int NOT NULL AUTO_INCREMENT,
    `vehicle_model` varchar(255) DEFAULT NULL,
    `colour`       varchar(255) DEFAULT NULL,
    `year`         varchar(255) DEFAULT NULL,
    `mileage`      varchar(255) DEFAULT NULL,
    `status`      varchar(255) DEFAULT NULL,
    `price`      varchar(255) DEFAULT NULL,
    PRIMARY KEY (`id`)
);
CREATE TABLE `rent`
(
    `id`                    int NOT NULL AUTO_INCREMENT,
    `rent_start_date_time` datetime(6) DEFAULT NULL,
    `rent_end_date_time`   datetime(6) DEFAULT NULL,
    `user_id`           int         DEFAULT NULL,
    `vehicle_id`            int         DEFAULT NULL,
    `amount`                int         DEFAULT NULL,
    PRIMARY KEY (`id`),
    KEY `FKuser` (`user_id`),
    KEY `FKvehi` (`vehicle_id`),
    CONSTRAINT `FKcust` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
    CONSTRAINT `FKvehi` FOREIGN KEY (`vehicle_id`) REFERENCES  `vehicle` (`id`)
);

CREATE TABLE `user`
(
    `id`         int         NOT NULL AUTO_INCREMENT,
    `username` varchar(30) NOT NULL,
    `password`   varchar(64) NOT NULL,
    `role`      varchar(64) NOT NULL,
    `first_name` varchar(64) NOT NULL,
    `last_name` varchar(64) NOT NULL,
    `email` varchar(64) NOT NULL,
    `address` varchar(64) NOT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE `branch`
(
    `id`         int         NOT NULL AUTO_INCREMENT,
    `name`       varchar(30) NOT NULL,
    `address`    varchar(30) NOT NULL,
    PRIMARY KEY (`id`)
);