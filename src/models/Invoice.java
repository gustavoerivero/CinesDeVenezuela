
package models;

import java.util.Date;

/**
 *  Materia: Laboratorio I
 *  Sección: 1
 *      Integrantes:
 *          @author Brizuela, Yurisbellys   C.I: 27.142.239
 *          @author Miranda, Marihec        C.I: 26.120.075
 *          @author Montero, Michael        C.I: 26.561.077
 *          @author Rivero, Gustavo         C.I: 26.772.857
 *          @author Torrealba, Luis         C.I: 26.121.249
 */
public class Invoice {
    
    private String id, id_employee, id_client;
    private Date date_purchase;
    private double iva, amount;
    private char estatus;

    public Invoice(String id, String id_employee, String id_client, Date date_purchase, 
                   double iva, double amount, char estatus) {
        
        this.id = id;
        this.id_employee = id_employee;
        this.id_client = id_client;
        this.date_purchase = date_purchase;
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
    
        public String getId_client() {
        return id_client;
    }

    public void setId_client(String id_client) {
        this.id_client = id_client;
    }

    public Date getDate_purchase() {
        return date_purchase;
    }

    public void setDate_purchase(Date date_purchase) {
        this.date_purchase = date_purchase;
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
