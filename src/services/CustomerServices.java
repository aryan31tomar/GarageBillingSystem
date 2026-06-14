package services;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import config.DBconfig;
import entity.Customer;

public class CustomerServices {

    public static void addCustomer(Customer customer) throws SQLException {
        Connection con = DBconfig.getConnection();
        PreparedStatement ps = con.prepareStatement("INSERT INTO customers(name,phone) VALUES(?,?)");
        ps.setString(1, customer.getName());
        ps.setString(2, customer.getPhone());
        ps.executeUpdate();
        ps.close();
        con.close();
    }

    public List<Customer> getAllCustomer() throws SQLException {
        List<Customer> list = new ArrayList<>();
        Connection con = DBconfig.getConnection();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM customers");
        while (rs.next()) {
            list.add(new Customer(rs.getInt("id"), rs.getString("name"), rs.getString("phone")));
        }
        return list;
    }

    public static Customer getCustomer(String number) throws SQLException {
        Customer customer= new Customer();
        Connection con = DBconfig.getConnection();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM customers where id ="+number);
        while (rs.next()) {
           customer=new Customer(rs.getInt("id"), rs.getString("name"), rs.getString("phone"));
        }
        return customer;
    }
}
