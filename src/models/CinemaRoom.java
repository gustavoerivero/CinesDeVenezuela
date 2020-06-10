
package models;

/**
 *
 * @author Gustavo
 */
public class CinemaRoom {
    private String 
            id,
            branch_id;
    private int
            fila,
            colum;
    private char estatus;
            
            
    public CinemaRoom(String id,String branch_id,int fila,int colum,char estatus){
        this.id=id;
        this.branch_id=branch_id;
        this.fila=fila;
        this.colum=colum;
        this.estatus=estatus;   
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBranch_id() {
        return branch_id;
    }

    public void setBranch_id(String branch_id) {
        this.branch_id = branch_id;
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getColum() {
        return colum;
    }

    public void setColum(int colum) {
        this.colum = colum;
    }

    public char getEstatus() {
        return estatus;
    }

    public void setEstatus(char estatus) {
        this.estatus = estatus;
    }
    
    
}
