**Online Retail Sales Analysis Database (SQL)**  
**Project Description**  

This project is a Retail Sales Analysis System implemented using SQL.
It stores and analyzes data related to users, products, orders, and sales to generate meaningful business insights.

**Objective**

To design a relational database for an online store and perform queries to analyze:

Sales performance  
Customer behavior  
Product trends  
**Database Structure**  

**1. Users Table**  

Stores customer details:

u_id (Primary Key)  
u_name  
u_city  

**2. Products Table**

Stores product details:

p_id (Primary Key)  
p_name  
p_category  
p_price  

**3. Orders Table**

Stores order details:

o_id (Primary Key)  
u_id (Foreign Key)  
o_date  

**4. OrderItems Table**

Stores order item details:

o_id (Foreign Key)  
p_id (Foreign Key)  
qty  

**Features**  
Track product sales and quantities  
Identify top-selling products  
Calculate total spending per user  
Generate monthly revenue reports  
Analyze category-wise sales  
Detect inactive users

**Concepts Used**  
DDL (CREATE DATABASE, CREATE TABLE)  
DML (INSERT)  
JOIN operations  
Aggregate functions (SUM)  
GROUP BY and ORDER BY  
Date functions (DATE_FORMAT, DATE_SUB)  
Subqueries  
Foreign Key relationships

**Tools Used**  
MySQL / MySQL Workbench  
SQL  
