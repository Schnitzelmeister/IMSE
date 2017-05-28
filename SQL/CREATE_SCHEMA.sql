

use imse;

CREATE TABLE `Address` (
  `addressId` int(11) NOT NULL AUTO_INCREMENT,
  `streetName` varchar(45) NOT NULL,
  `streetNumber` varchar(45) NOT NULL,
  `additionalInfo` varchar(45) DEFAULT NULL,
  `city` varchar(45) NOT NULL,
  `postCode` varchar(45) NOT NULL,
  `country` varchar(45) NOT NULL,
  PRIMARY KEY (`addressId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE `CreditCard` (
  `cardNumber` varchar(20) NOT NULL,
  `firstName` varchar(45) NOT NULL,
  `lastName` varchar(45) NOT NULL,
  `type` varchar(45) NOT NULL,
  `cvv` varchar(45) NOT NULL,
  `expiryMonth` int(11) NOT NULL,
  `expiryYear` int(11) NOT NULL,
  PRIMARY KEY (`cardNumber`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE `Customer` (
  `emailAddress` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `firstName` varchar(45) NOT NULL,
  `lastName` varchar(45) NOT NULL,
  `phoneNumber` varchar(45) DEFAULT NULL,
  `creditCardNumber` varchar(20) DEFAULT NULL,
  `shippingAddressId` int(11) DEFAULT NULL,
  `billingAddressId` int(11) DEFAULT NULL,
  PRIMARY KEY (`emailAddress`),
  KEY `FK-ShippingAddressId` (`shippingAddressId`),
  KEY `FK-BillingAddressId` (`billingAddressId`),
  KEY `FK-CreditCard` (`creditCardNumber`),
  CONSTRAINT `FK-BillingAddressId` FOREIGN KEY (`billingAddressId`) REFERENCES `Address` (`addressId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK-ShippingAddressId` FOREIGN KEY (`shippingAddressId`) REFERENCES `Address` (`addressId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK-CreditCard` FOREIGN KEY (`creditCardNumber`) REFERENCES `CreditCard` (`cardNumber`) ON DELETE CASCADE ON UPDATE CASCADE

) ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE `Admin` (
  `emailAddress` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `firstName` varchar(45) NOT NULL,
  `lastName` varchar(45) NOT NULL,
  `verified` varchar(45) NOT NULL,
  `managerEmailAddress` varchar(45) NOT NULL,
  PRIMARY KEY (`emailAddress`),
  KEY `FK_ManagerEmailAddress_idx` (`managerEmailAddress`),
  CONSTRAINT `FK_ManagerEmailAddress` FOREIGN KEY (`managerEmailAddress`) REFERENCES `Admin` (`emailAddress`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE `Product` (
  `productId` int(11) NOT NULL AUTO_INCREMENT,
  `productName` varchar(45) NOT NULL,
  `price` decimal(7,2) NOT NULL,
  `description` varchar(45) DEFAULT NULL,
  `quantity` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`productId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



CREATE TABLE `Image` (
  `imageId` int(11) NOT NULL AUTO_INCREMENT,
  `productId` int(11) NOT NULL,
  `image` varchar(1000) NOT NULL,
  PRIMARY KEY (`imageId`,`productId`),
  KEY `FK_ProductId_idx` (`productId`),
  CONSTRAINT `FK_ProductId` FOREIGN KEY (`productId`) REFERENCES `Product` (`productId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE `Category` (
  `categoryId` int(11) NOT NULL AUTO_INCREMENT,
  `categoryName` varchar(45) NOT NULL,
  PRIMARY KEY (`categoryId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `ProductBelongsCategory` (
  `productId` int(11) NOT NULL,
  `categoryId` int(11) NOT NULL,
  PRIMARY KEY (`productId`,`categoryId`),
  KEY `FK_CategoryId_idx` (`categoryId`),
  CONSTRAINT `FK_CategoryId` FOREIGN KEY (`categoryId`) REFERENCES `Category` (`categoryId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_ProductBelongs` FOREIGN KEY (`productId`) REFERENCES `Product` (`productId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE `CustomerOrder` (
  `orderId` int(11) NOT NULL AUTO_INCREMENT,
  `dateCreated` varchar(10) NOT NULL,
  `dateShipped` varchar(10) DEFAULT NULL,
  `CustomerEmail` varchar(45) NOT NULL,
  `ordered` tinyint(4) NOT NULL,
  PRIMARY KEY (`orderId`),
  KEY `FK_CustomerEmail_idx` (`CustomerEmail`),
  CONSTRAINT `FK_CustomerEmail` FOREIGN KEY (`CustomerEmail`) REFERENCES `Customer` (`emailAddress`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE `OrderDetail` (
  `orderDetailId` int(11) NOT NULL AUTO_INCREMENT,
  `orderId` int(11) NOT NULL,
  `quantity` int(11) NOT NULL,
  `subTotal` decimal(7,2) NOT NULL,
  `productId` int(11) NOT NULL,
  PRIMARY KEY (`orderDetailId`,`orderId`),
  KEY `FK_Product_idx` (`productId`),
  KEY `FK_OrderId` (`orderId`),
  CONSTRAINT `FK_OrderId` FOREIGN KEY (`orderId`) REFERENCES `CustomerOrder` (`orderId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_Product` FOREIGN KEY (`productId`) REFERENCES `Product` (`productId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


