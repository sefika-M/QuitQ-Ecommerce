-- Create Database : QuitQ
CREATE DATABASE QuitQ;
USE QuitQ;

-- Users Table (for Customers, Sellers, Admins)
CREATE TABLE users (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE,
    password VARCHAR(255) NOT NULL,
    gender VARCHAR(10),
    contact_number VARCHAR(15),
    address TEXT,
    role ENUM('CUSTOMER', 'SELLER', 'ADMIN') NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Category Table
CREATE TABLE category(
    cat_id INT AUTO_INCREMENT PRIMARY KEY,
    cat_name VARCHAR(100) NOT NULL UNIQUE
);

-- Products Table
CREATE TABLE products (
    product_id INT AUTO_INCREMENT PRIMARY KEY,
    seller_id INT NOT NULL,
    cat_id INT NOT NULL,
    product_name VARCHAR(150) not null,
    price DECIMAL(10,2) NOT NULL,
    stock INT DEFAULT 0,
    description TEXT,
    image_url VARCHAR(255),
    FOREIGN KEY (seller_id) REFERENCES users(user_id),
    FOREIGN KEY (cat_id) REFERENCES category(cat_id)
);

-- Cart Items Table
CREATE TABLE cart_items (
    cart_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    product_id INT NOT NULL,
    quantity INT default 1,
    added_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users(user_id),
    FOREIGN KEY (product_id) REFERENCES products(product_id)
);

-- Orders Table
CREATE TABLE orders (
    order_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    total_amount DECIMAL(10,2) NOT NULL,
    payment_status ENUM('PENDING', 'PAID', 'FAILED') DEFAULT 'PENDING',
    order_status ENUM('PLACED', 'SHIPPED', 'DELIVERED', 'CANCELLED') DEFAULT 'PLACED',
    shipping_address TEXT NOT NULL,
    order_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users(user_id)
);

-- Order Items Table
CREATE TABLE order_items (
    item_id INT AUTO_INCREMENT PRIMARY KEY,
    order_id INT NOT NULL,
    product_id INT NOT NULL,
    quantity INT NOT NULL,
    price DECIMAL(10,2) NOT NULL,
    FOREIGN KEY (order_id) REFERENCES orders(order_id),
    FOREIGN KEY (product_id) REFERENCES products(product_id)
);


-- Wallet Table
CREATE TABLE wallet (
         wallet_id INT AUTO_INCREMENT PRIMARY KEY,
         user_id INT NOT NULL,
         wal_balance DECIMAL(10,2) NOT NULL,
         wal_source ENUM('UPI', 'CARD', 'NETBANKING') DEFAULT 'UPI',
         FOREIGN KEY (user_id) REFERENCES users(user_id)
     );


-- Insert data

-- Insert Users (Customers, Sellers, Admin)
INSERT INTO users (name, email, password, gender, contact_number, address, role)
VALUES 
('Steven John', 'steven@gmail.com', 'john098', 'Male', '9876543210', 'Bangalore, Karnataka', 'CUSTOMER'),
('Priya Sharma', 'priya.sharma@gmail.com', '123priya', 'Female', '9898989898', 'Mumbai, Maharashtra', 'CUSTOMER'),
('Ankitha', 'ankitha@techmart.in', 'techmart456', 'Female', '9123456789', 'Noida, Uttar Pradesh', 'SELLER'),
('Meena Joshi', 'meena.j@fashionhub.in', 'fashub01', 'Female', '9001234567', 'Pune, Maharashtra', 'SELLER'),
('Admin 1', 'admin@quitq.in', 'adminpass', 'Male', '9999999999', 'Chennai, Tamil Nadu', 'ADMIN');

-- Insert Categories
INSERT INTO category (cat_name)
VALUES 
('Electronics'),
('Fashion'),
('Home & Furniture'),
('Books'),
('Mobiles');

-- Insert Products
INSERT INTO products (seller_id, cat_id, product_name, price, stock, description, image_url)
VALUES
(3, 1, 'Noise Smartwatch ColorFit Pro 3', 3499.00, 20, 'Smartwatch with heart rate & SpO2 monitoring', 'https://example.com/noise-watch.jpg'),
(3, 5, 'Samsung Galaxy M14 5G', 12999.00, 15, 'Samsung mid-range 5G phone with 6000mAh battery', 'https://example.com/galaxy-m14.jpg'),
(4, 2, 'Cotton Kurti - Blue', 799.00, 30, 'Blue cotton kurti with floral print', 'https://example.com/kurti-blue.jpg'),
(4, 2, 'Men''s Casual Shirt - White', 999.00, 25, 'White shirt', 'https://example.com/shirt-white.jpg');

-- Insert Cart Items
INSERT INTO cart_items (user_id, product_id, quantity)
VALUES
(1, 1, 1),  
(1, 2, 1),  
(2, 3, 2);  

-- Insert Orders
INSERT INTO orders (user_id, total_amount, payment_status, order_status, shipping_address)
VALUES
(1, 16498.00, 'PAID', 'PLACED', 'Steven John, Bangalore, Karnataka, 560001'),
(2, 1598.00, 'PAID', 'SHIPPED', 'Priya Sharma, Mumbai, Maharashtra, 400001');

-- Insert Order Items
INSERT INTO order_items (order_id, product_id, quantity, price)
VALUES
(1, 1, 1, 3499.00),
(1, 2, 1, 12999.00),
(2, 3, 2, 799.00);

-- Insert  Wallets
INSERT INTO wallet (user_id, wal_balance, wal_source) 
VALUES 
(7, 1500.00, 'UPI'),
(2, 3200.50, 'CARD'),
(1, 500.75, 'NETBANKING'),
(6, 900.00, 'CARD');


