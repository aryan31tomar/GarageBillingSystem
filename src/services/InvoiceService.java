package services;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import config.DBconfig;
import entity.Invoice;
public class InvoiceService {
    public void addInvoice(Invoice invoice) throws SQLException{
        Connection con = DBconfig.getConnection();
        PreparedStatement ps = con.prepareStatement("INSERT INTO invoices(customer_id,vehicle_id,service_id) VALUES(?,?,?)");
        ps.setInt(1, invoice.getCustomerId());
        ps.setInt(2, invoice.getVehicleId());
        ps.setInt(3, invoice.getServiceId()); 
        ps.executeUpdate();
        ps.close();
        con.close();
    }

    public List<Invoice> getAllInvoices() throws SQLException {
        List<Invoice> list = new ArrayList<>();
        Connection con = DBconfig.getConnection();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM invoices");
        while (rs.next()) {
            list.add(new Invoice(rs.getInt("id"),
             rs.getInt("customer_id"), 
             rs.getInt("vehicle_id"),rs.getInt("service_id")));
        }
        return list;
    }
}
