package services;

import java.sql.SQLException;
import java.util.*;

import entity.Invoice;

public class BillingService {
    public CustomerServices customerServices = new CustomerServices();
    public InvoiceService invoiceService = new InvoiceService();

    public  void createInvoice(int customerId,int vehicleId, List<Integer> serviceIds)throws SQLException{
        String sids="";
        for(int serviceId:serviceIds){
           sids+=serviceId;
        }
         invoiceService.addInvoice( new Invoice(0, customerId, vehicleId, Integer.parseInt(sids)));
        System.out.println("Invoice generated successfully.....");
    }

    public void showAllInvoice()throws SQLException{
        List<Invoice> list = invoiceService.getAllInvoices();
        for(Invoice i : list){
            System.out.println(i);
        }
    }
}
