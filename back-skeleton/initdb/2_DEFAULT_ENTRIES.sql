-- Insert random products (perfumes)
INSERT INTO Product (name, price, category, description, picture, sellType, Deleted_, seller_id)
VALUES
    ('Perfume 1', 49.99, 'Perfume', 'A floral fragrance with hints of citrus.', 'perfume1.jpg', 'Retail', false, 1),
    ('Perfume 2', 59.99, 'Perfume', 'A woody fragrance with notes of vanilla.', 'perfume2.jpg', 'Retail', false, 2),
    ('Perfume 3', 39.99, 'Perfume', 'A fresh fragrance with a hint of musk.', 'perfume3.jpg', 'Retail', false, 3),
    ('Perfume 4', 69.99, 'Perfume', 'An oriental fragrance with spicy undertones.', 'perfume4.jpg', 'Retail', false, 1),
    ('Perfume 5', 79.99, 'Perfume', 'A fruity fragrance with floral accents.', 'perfume5.jpg', 'Retail', false, 2);

-- Insert random buyers
INSERT INTO Buyer (login, password, Fname, Lname, mail)
VALUES
    ('buyer1', 'password1', 'John', 'Doe', 'john@example.com'),
    ('buyer2', 'password2', 'Jane', 'Smith', 'jane@example.com'),
    ('buyer3', 'password3', 'Michael', 'Johnson', 'michael@example.com');

-- Insert random sellers
INSERT INTO Seller (login, password, Fname, Lname, mail)
VALUES
    ('seller1', 'password1', 'Alice', 'Johnson', 'alice@example.com'),
    ('seller2', 'password2', 'Bob', 'Smith', 'bob@example.com'),
    ('seller3', 'password3', 'Charlie', 'Doe', 'charlie@example.com');
