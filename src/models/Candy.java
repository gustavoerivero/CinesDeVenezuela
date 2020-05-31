
package models;

/**
 *
 * @author Gustavo
 */
public class Candy {
    
    String id, name, descr;
    int cant;
    double price;
    char estatus;

    public Candy(String id, String name, String descr, int cant, double price, char estatus) {
        this.id = id;
        this.name = name;
        this.descr = descr;
        this.cant = cant;
        this.price = price;
        this.estatus = estatus;
    }
   
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public int getCant() {
        return cant;
    }

    public void setCant(int cant) {
        this.cant = cant;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public char getEstatus() {
        return estatus;
    }

    public void setEstatus(char estatus) {
        this.estatus = estatus;
    }
    
}
