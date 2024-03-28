DROP SCHEMA public CASCADE;
CREATE SCHEMA public;

CREATE TABLE Buyer(
                      Buy_ID serial,
                      login VARCHAR(50) NOT NULL,
                      password VARCHAR(50) NOT NULL,
                      Fname VARCHAR(50),
                      Lname VARCHAR(50),
                      mail VARCHAR(50),
                      PRIMARY KEY(Buy_ID)
);

CREATE TABLE Delivery_details(
                                 Delivery_ID serial,
                                 Buy_ID serial,
                                 Address_Line_1 VARCHAR(50),
                                 Address_Line_2 VARCHAR(50),
                                 City VARCHAR(50),
                                 Postal_code VARCHAR(50),
                                 Country VARCHAR(50),
                                 Phone_number VARCHAR(50),
                                 Fname VARCHAR(50),
                                 Lname VARCHAR(50),
                                 PRIMARY KEY(Delivery_ID,Buy_ID),
                                 FOREIGN KEY (Buy_ID) REFERENCES Buyer(Buy_ID)
);

CREATE TABLE Payment_details(
                                Card_Number BIGINT,
                                Type VARCHAR(50),
                                Name VARCHAR(50),
                                Expiration_date DATE,
                                Security_Code INT,
                                PRIMARY KEY(Card_Number)
);

CREATE TABLE Product(
                        Product_ID bigserial,
                        name VARCHAR(50),
                        price DECIMAL(10,2),
                        category VARCHAR(50),
                        description TEXT,
                        picture VARCHAR(50),
                        sellType VARCHAR(50),
                        Deleted_ boolean,
                        seller_id int null,
                        PRIMARY KEY(Product_ID)
);

CREATE TABLE Seller(
                       Sell_ID serial,
                       login VARCHAR(50) NOT NULL,
                       password VARCHAR(50) NOT NULL,
                       mail VARCHAR(50),
                       Fname VARCHAR(50),
                       Lname VARCHAR(50),
                       Bckground VARCHAR(50),
                       photo VARCHAR(50),
                       PRIMARY KEY(Sell_ID)
);

CREATE TABLE Administrator(
                              Admin_ID serial,
                              login VARCHAR(50) NOT NULL,
                              password VARCHAR(50) NOT NULL,
                              mail VARCHAR(50),
                              Fname VARCHAR(50),
                              Lname VARCHAR(50),
                              PRIMARY KEY(Admin_ID)
);

CREATE TABLE In_cart(
                        Buy_ID serial,
                        Product_ID bigserial,
                        Quantity INT,
                        PRIMARY KEY(Buy_ID, Product_ID),
                        FOREIGN KEY(Buy_ID) REFERENCES Buyer(Buy_ID),
                        FOREIGN KEY(Product_ID) REFERENCES Product(Product_ID)
);

CREATE TABLE Bought_Sold(
                            Buy_ID serial,
                            Product_ID bigserial,
                            Sell_ID serial,
                            Transaction_date date,
                            Quantity INT,
                            sellType VARCHAR(50),
                            PRIMARY KEY(Buy_ID, Product_ID, Sell_ID),
                            FOREIGN KEY(Buy_ID) REFERENCES Buyer(Buy_ID),
                            FOREIGN KEY(Product_ID) REFERENCES Product(Product_ID),
                            FOREIGN KEY(Sell_ID) REFERENCES Seller(Sell_ID)
);

CREATE TABLE Is_selling(
                           Product_ID bigserial,
                           Sell_ID serial,
                           Quantity INT,
                           Add_date timestamp,
                           PRIMARY KEY(Product_ID, Sell_ID),
                           FOREIGN KEY(Product_ID) REFERENCES Product(Product_ID),
                           FOREIGN KEY(Sell_ID) REFERENCES Seller(Sell_ID)
);

CREATE TABLE Added(
                      Product_ID bigserial,
                      Admin_ID serial,
                      Add_date timestamp,
                      Quantity INT,
                      PRIMARY KEY(Product_ID, Admin_ID),
                      FOREIGN KEY(Product_ID) REFERENCES Product(Product_ID),
                      FOREIGN KEY(Admin_ID) REFERENCES Administrator(Admin_ID)
);

CREATE TABLE Remove(
                       Product_ID bigserial,
                       Admin_ID serial,
                       Delete_date timestamp,
                       PRIMARY KEY(Product_ID, Admin_ID),
                       FOREIGN KEY(Product_ID) REFERENCES Product(Product_ID),
                       FOREIGN KEY(Admin_ID) REFERENCES Administrator(Admin_ID)
);

CREATE TABLE Cancel(
                       Product_ID bigserial,
                       Sell_ID serial,
                       Can_date timestamp,
                       PRIMARY KEY(Product_ID, Sell_ID),
                       FOREIGN KEY(Product_ID) REFERENCES Product(Product_ID),
                       FOREIGN KEY(Sell_ID) REFERENCES Seller(Sell_ID)
);