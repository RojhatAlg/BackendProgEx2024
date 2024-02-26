-- Insert sample data into Customer table
INSERT INTO Customer (Name, Email) VALUES ('Jason Tatum', 'JT@example.com');
INSERT INTO Customer (Name, Email) VALUES ('Jalen Brown', 'JB@example.com');
INSERT INTO Customer (Name, Email) VALUES ('Lionel Messi', 'LM10@example.com');
INSERT INTO Customer (Name, Email) VALUES ('Stephen Curry', 'curry@example.com');
INSERT INTO Customer (Name, Email) VALUES ('Neymar Jr', 'Njr@example.com');
INSERT INTO Customer (Name, Email) VALUES ('Luis Suarez', 'L.suarez@example.com');
INSERT INTO Customer (Name, Email) VALUES ('Erlig Haaland', 'mancity@example.com');
INSERT INTO Customer (Name, Email) VALUES ('Pep Guardiola', 'fcbmancity@example.com');

-- Insert sample data into Address table
INSERT INTO Address (Street, City, Postcode, Country, Customer_Id) VALUES ('123 Main St', 'New York', '10001', 'USA', 1);
INSERT INTO Address (Street, City, Postcode, Country, Customer_Id) VALUES ('456 Oak Ave', 'Los Angeles', '90001', 'USA', 2);
INSERT INTO Address (Street, City, Postcode, Country, Customer_Id) VALUES ('Brook St', 'Miami', '12002', 'USA', 3);
INSERT INTO Address (Street, City, Postcode, Country, Customer_Id) VALUES ('Sac Ave St', 'Sacramento', '12002', 'USA', 4);
INSERT INTO Address (Street, City, Postcode, Country, Customer_Id) VALUES ('Al hilal street', 'Riyadh', '123123', 'Saudi-Arabia', 5);
INSERT INTO Address (Street, City, Postcode, Country, Customer_Id) VALUES ('Brook St 2', 'Miami', '12003', 'USA', 6);
INSERT INTO Address (Street, City, Postcode, Country, Customer_Id) VALUES ('Etihad Stadium', 'Manchester', '0909', 'England', 7);
INSERT INTO Address (Street, City, Postcode, Country, Customer_Id) VALUES ('Etihad Stadium 2', 'Manchester', '1010', 'England', 8);

-- Insert sample data into Orders table
INSERT INTO Orders (Date, Customer_Id) VALUES ('2024-02-25', 1);
INSERT INTO Orders (Date, Customer_Id) VALUES ('2024-02-26', 2);
INSERT INTO Orders (Date, Customer_Id) VALUES ('2024-02-26', 3);
INSERT INTO Orders (Date, Customer_Id) VALUES ('2024-02-26', 4);
INSERT INTO Orders (Date, Customer_Id) VALUES ('2024-02-26', 5);
INSERT INTO Orders (Date, Customer_Id) VALUES ('2024-02-26', 6);
INSERT INTO Orders (Date, Customer_Id) VALUES ('2024-02-26', 7);
INSERT INTO Orders (Date, Customer_Id) VALUES ('2024-02-26', 8);

-- Insert sample data into Item table
INSERT INTO Item (Name, Price, Product_Id) VALUES ('Dentist Desk', 19.99, 'DSK001');
INSERT INTO Item (Name, Price, Product_Id) VALUES ('Dentist chair', 39.99, 'CHR002');
INSERT INTO Item (Name, Price, Product_Id) VALUES ('Dentist Lamp', 59.99, 'LMP003');
INSERT INTO Item (Name, Price, Product_Id) VALUES ('Dentist Drill', 119.99, 'DRL004');

-- Insert sample data into OrderItem table
INSERT INTO Order_Item (Order_ID, Item_Id) VALUES (1, 1);
INSERT INTO Order_Item (Order_ID, Item_Id) VALUES (1, 2);
INSERT INTO Order_Item (Order_ID, Item_Id) VALUES (2, 2);
INSERT INTO Order_Item (Order_ID, Item_Id) VALUES (3, 1);
INSERT INTO Order_Item (Order_ID, Item_Id) VALUES (3, 2);
INSERT INTO Order_Item (Order_ID, Item_Id) VALUES (3, 3);
INSERT INTO Order_Item (Order_ID, Item_Id) VALUES (4, 1);
INSERT INTO Order_Item (Order_ID, Item_Id) VALUES (5, 2);
INSERT INTO Order_Item (Order_ID, Item_Id) VALUES (6, 3);
INSERT INTO Order_Item (Order_ID, Item_Id) VALUES (6, 1);
INSERT INTO Order_Item (Order_ID, Item_Id) VALUES (7, 4);
INSERT INTO Order_Item (Order_ID, Item_Id) VALUES (8, 3);
INSERT INTO Order_Item (Order_ID, Item_Id) VALUES (8, 4);
