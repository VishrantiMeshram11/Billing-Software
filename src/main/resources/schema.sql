
CREATE DATABASE IF NOT EXISTS billing_software;
USE billing_software;

CREATE TABLE IF NOT EXISTS customer (
    customer_id INT AUTO_INCREMENT PRIMARY KEY,
    customer_name VARCHAR(100),
    customer_phone_no VARCHAR(20),
    customer_email VARCHAR(100),
    customer_address VARCHAR(200)
    );

CREATE TABLE product (
                         id INT AUTO_INCREMENT PRIMARY KEY,
                         name VARCHAR(100) NOT NULL,
                         price INT NOT NULL,
                         gst_percentage DOUBLE NOT NULL,
                         stock_quantity INT NOT NULL
);


CREATE TABLE invoice (
                         invoice_id INT AUTO_INCREMENT PRIMARY KEY,
                         invoice_date DATETIME NOT NULL,
                         customer_id INT NOT NULL,
                         total_amount DOUBLE,
                         total_tax DOUBLE,
                         discount DOUBLE,
                         final_amount DOUBLE,
                         FOREIGN KEY (customer_id) REFERENCES customer(id)
);

CREATE TABLE invoice_item (
                              id INT AUTO_INCREMENT PRIMARY KEY,
                              invoice_id INT NOT NULL,
                              product_id INT NOT NULL,
                              quantity INT NOT NULL,
                              price DOUBLE,
                              tax_amount DOUBLE,
                              total DOUBLE,
                              FOREIGN KEY (invoice_id) REFERENCES invoice(invoice_id),
                              FOREIGN KEY (product_id) REFERENCES product(id)
);
