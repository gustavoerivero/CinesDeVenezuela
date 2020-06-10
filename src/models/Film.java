
package models;

/**
 *
 * @author Gustavo
 */
public class Film {
    private String
            id,
            name,
            synopsis,
            duration,
            type;
    private char
            classification,
            estatus;
    public Film(String id,String name, String synopsis, String duration,
            String type, char classification, char estatus){
        this.id=id;
        this.name=name;
        this.synopsis=synopsis;
        this.duration=duration;
        this.type=type;
        this.classification=classification;
        this.estatus=estatus;
        
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

    public int getClassification() {
        return classification;
    }

    public void setClassification(char classification) {
        this.classification = classification;
    }

    public int getEstatus() {
        return estatus;
    }

    public void setEstatus(char estatus) {
        this.estatus = estatus;
    }
    
    
}
