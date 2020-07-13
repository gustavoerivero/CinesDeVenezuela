
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
public class Film {
    private String
            id,
            name,
            synopsis,
            duration,
            type,
            classification;
    private char
            //classification,
            estatus;
    private Date premiere;
    
    public Film(String id,String name, String synopsis, String duration,
            String type, String classification, char estatus, Date premiere){
        this.id=id;
        this.name=name;
        this.synopsis=synopsis;
        this.duration=duration;
        this.type=type;
        this.classification=classification;
        this.estatus=estatus;
        this.premiere=premiere;
        
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
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

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    /*public int getClassification() {
        return classification;
    }

    public void setClassification(char classification) {
        this.classification = classification;
    }*/

    public int getEstatus() {
        return estatus;
    }

    public void setEstatus(char estatus) {
        this.estatus = estatus;
    }
      public Date getPremiere() {
        return premiere;
    }

    public void setPremiere(Date premiere) {
        this.premiere = premiere;
    }
 
    
}
