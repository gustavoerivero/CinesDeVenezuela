/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author Michael Montero
 */
public class CandyInventory {
    private String id, idCandy, idBranch;
    private int stock;
    private char estatus;

    public CandyInventory(String id,String idCandy,String idBranch,int stock, char estatus)
    {
        this.id=id;
        this.idCandy=idCandy;
        this.idBranch=idBranch;
        this.stock=stock;
        this.estatus= estatus;
    }
    
    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the idCandy
     */
    public String getIdCandy() {
        return idCandy;
    }

    /**
     * @param idCandy the idCandy to set
     */
    public void setIdCandy(String idCandy) {
        this.idCandy = idCandy;
    }

    /**
     * @return the idBranch
     */
    public String getIdBranch() {
        return idBranch;
    }

    /**
     * @param idBranch the idBranch to set
     */
    public void setIdBranch(String idBranch) {
        this.idBranch = idBranch;
    }

    /**
     * @return the stock
     */
    public int getStock() {
        return stock;
    }

    /**
     * @param stock the stock to set
     */
    public void setStock(int stock) {
        this.stock = stock;
    }

    /**
     * @return the estatus
     */
    public char getEstatus() {
        return estatus;
    }

    /**
     * @param estatus the estatus to set
     */
    public void setEstatus(char estatus) {
        this.estatus = estatus;
    }
    
    
}
