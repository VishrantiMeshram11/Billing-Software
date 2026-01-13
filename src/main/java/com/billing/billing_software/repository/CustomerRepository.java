package com.billing.billing_software.repository;

import com.billing.billing_software.model.Customer;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerRepository {

    private final JdbcTemplate jdbcTemplate;

    public CustomerRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // CREATE
    public int saveCustomer(Customer c) {
        String sql = """
            INSERT INTO customer 
            (customer_name, customer_phone_no, customer_email, customer_address)
            VALUES (?,?,?,?)
            """;
        return jdbcTemplate.update(sql,
                c.getCustomerName(),
                c.getCustomerPhoneNo(),
                c.getCustomerEmail(),
                c.getCustomerAddress());
    }

    // READ ALL
    public List<Customer> findAllCustomers() {
        return jdbcTemplate.query("SELECT * FROM customer",
                (rs, rowNum) -> {
                    Customer c = new Customer();
                    c.setCustomerId(rs.getInt("customer_id"));
                    c.setCustomerName(rs.getString("customer_name"));
                    c.setCustomerPhoneNo(rs.getString("customer_phone_no"));
                    c.setCustomerEmail(rs.getString("customer_email"));
                    c.setCustomerAddress(rs.getString("customer_address"));
                    return c;
                });
    }

    // READ BY ID (SAFE)
    public Customer findCustomerById(int id) {
        String sql = "SELECT * FROM customer WHERE customer_id=?";
        List<Customer> list = jdbcTemplate.query(sql,
                new Object[]{id},
                (rs, rowNum) -> {
                    Customer c = new Customer();
                    c.setCustomerId(rs.getInt("customer_id"));
                    c.setCustomerName(rs.getString("customer_name"));
                    c.setCustomerPhoneNo(rs.getString("customer_phone_no"));
                    c.setCustomerEmail(rs.getString("customer_email"));
                    c.setCustomerAddress(rs.getString("customer_address"));
                    return c;
                });
        return list.isEmpty() ? null : list.get(0);
    }

    // DELETE
    public int deleteCustomerById(int id) {
        return jdbcTemplate.update(
                "DELETE FROM customer WHERE customer_id=?", id);
    }
}
