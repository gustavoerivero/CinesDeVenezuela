
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
public class Schedule {
    private String
            id,idBlock,idCinema,idTypeDay;
    private Date day;
    private char status;
    
    public Schedule(String id,String idBlock,String idCinema,String idTypeDay, Date day,char status)
    {
        this.id=id;
        this.idBlock=idBlock;
        this.idCinema=idCinema;
        this.idTypeDay=idTypeDay;
        this.status=status;
        this.day=day;
    }
    public Schedule(String id,String idBlock,String idCinema, Date day,char status)
    {
        this.id=id;
        this.idBlock=idBlock;
        this.idCinema=idCinema;
        this.status=status;
        this.day=day;
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
     * @return the idBlock
     */
    public String getIdBlock() {
        return idBlock;
    }

    /**
     * @param idBlock the idBlock to set
     */
    public void setIdBlock(String idBlock) {
        this.idBlock = idBlock;
    }

    /**
     * @return the idCinema
     */
    public String getIdCinema() {
        return idCinema;
    }

    /**
     * @param idCinema the idCinema to set
     */
    public void setIdCinema(String idCinema) {
        this.idCinema = idCinema;
    }

    /**
     * @return the idTypeDay
     */
    public String getIdTypeDay() {
        return idTypeDay;
    }

    /**
     * @param idTypeDay the idTypeDay to set
     */
    public void setIdTypeDay(String idTypeDay) {
        this.idTypeDay = idTypeDay;
    }

    /**
     * @return the day
     */
    public Date getDay() {
        return day;
    }

    /**
     * @param day the day to set
     */
    public void setDay(Date day) {
        this.day = day;
    }

    /**
     * @return the status
     */
    public char getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(char status) {
        this.status = status;
    }
}
