-- Insert sample data into Customer table
INSERT INTO Customer (Name, Email) VALUES ('John Doe', 'john@example.com');
INSERT INTO Customer (Name, Email) VALUES ('Alice Smith', 'alice@example.com');

-- Insert sample data into Address table
INSERT INTO Address (Street, City, Postcode, Country, Customer_Id) VALUES ('123 Main St', 'New York', '10001', 'USA', 1);
INSERT INTO Address (Street, City, Postcode, Country, Customer_Id) VALUES ('456 Oak Ave', 'Los Angeles', '90001', 'USA', 2);

-- Insert sample data into Orders table
INSERT INTO Orders (Date, Customer_Id) VALUES ('2024-02-25', 1);
INSERT INTO Orders (Date, Customer_Id) VALUES ('2024-02-26', 2);

-- Insert sample data into Item table
INSERT INTO Item (Name, Price, Product_Id) VALUES ('T-shirt', 19.99, 'TS001');
INSERT INTO Item (Name, Price, Product_Id) VALUES ('Jeans', 39.99, 'JN002');

-- Insert sample data into OrderItem table
INSERT INTO Order_Item (Order_ID, Item_Id) VALUES (1, 1);
INSERT INTO Order_Item (Order_ID, Item_Id) VALUES (1, 2);
INSERT INTO Order_Item (Order_ID, Item_Id) VALUES (2, 2);
