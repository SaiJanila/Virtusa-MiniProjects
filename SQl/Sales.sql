CREATE DATABASE sales_db;
USE sales_db;

CREATE TABLE Users (
    u_id INT PRIMARY KEY,
    u_name VARCHAR(40),
    u_city VARCHAR(40)
);

CREATE TABLE Products (
    p_id INT PRIMARY KEY,
    p_name VARCHAR(50),
    P_category VARCHAR(40),
    P_price INT
);


CREATE TABLE Orders (
    o_id INT PRIMARY KEY,
    u_id INT,
    o_date DATE,
    FOREIGN KEY (u_id) REFERENCES Users(u_id)
);


CREATE TABLE OrderItems (
    o_id INT,
    p_id INT,
    qty INT,
    FOREIGN KEY (o_id) REFERENCES Orders(o_id),
    FOREIGN KEY (p_id) REFERENCES Products(p_id)
);

INSERT Users VALUES
(1,'Janila','Vizag'),
(2,'Bhavana','Hyderabad'),
(3,'Sagarika','Chennai');

INSERT INTO Products VALUES
(11,'Laptop','Electronics',55000),
(12,'Mobile','Electronics',20000),
(13,'Shoes','Fashion',3000),
(14,'Watch','Accessories',2500);

INSERT INTO Orders VALUES
(101,1,'2026-03-20'),
(102,2,'2026-04-02'),
(103,1,'2026-04-12');

INSERT INTO OrderItems VALUES
(101,11,1),
(101,13,2),
(102,12,1),
(103,14,2);

SELECT p.p_name, sum(oi.qty) AS total_qty
FROM OrderItems oi
JOIN Products p ON oi.p_id = p.p_id
GROUP BY p.p_name
ORDER BY total_qty DESC;

SELECT u.u_name, sum(p.p_price * oi.qty) AS total_amount
FROM Users u
JOIN Orders o ON u.u_id = o.u_id
JOIN OrderItems oi ON o.o_id = oi.o_id
JOIN Products p ON oi.p_id = p.p_id
GROUP BY u.u_name
ORDER BY total_amount DESC;

SELECT DATE_FORMAT(o.o_date,'%Y-%m') AS month,
SUM(p.p_price * oi.qty) AS revenue
FROM Orders o
JOIN OrderItems oi ON o.o_id = oi.o_id
JOIN Products p ON oi.p_id = p.p_id
GROUP BY month;

SELECT p.p_category, SUM(p.p_price * oi.qty) AS total_sales
FROM Products p
JOIN OrderItems oi ON p.p_id = oi.p_id
GROUP BY p.p_category;


SELECT * FROM Users
WHERE u_id NOT IN (
    SELECT DISTINCT u_id
    from Orders
    WHERE o_date >= DATE_SUB(CURDATE(), INTERVAL 1 YEAR)
);


