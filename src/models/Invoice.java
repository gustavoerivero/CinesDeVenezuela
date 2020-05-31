
package models;

import java.util.Date;

/**
 *
 * @author Gustavo
 */
public class Invoice {
    
    String id, id_employee;
    Date date_purchase;
    double discount, iva, amount;
    char estatus;

    public Invoice(String id, String id_employee, Date date_purchase, 
                   double discount, double iva, double amount, char estatus) {
        
        this.id = id;
        this.id_employee = id_employee;
        this.date_purchase = date_purchase;
        this.discount = discount;
        this.iva = iva;
        this.amount = amount;
        this.estatus = estatus;
        
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId_employee() {
        return id_employee;
    }

    public void setId_employee(String id_employee) {
        this.id_employee = id_employee;
    }

    public Date getDate_purchase() {
        return date_purchase;
    }

    public void setDate_purchase(Date date_purchase) {
        this.date_purchase = date_purchase;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public char getEstatus() {
        return estatus;
    }

    public void setEstatus(char estatus) {
        this.estatus = estatus;
    }
    
    public double calculate_iva(double[] price){
        double acum = 0;
        for(int i = 0; i < price.length; i++) acum += price[i] * 0.16;
        return acum;
    }
    
    public double calculate_amount(double[] amount, double iva){
        double acum = 0;
        for(int i = 0; i < amount.length; i++) acum += amount[i] * 0.16;
        return acum + iva;
    }
    
}
