package Model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by amaia.nazabal on 10/21/16.
 */
@Entity
public class Project implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @Column(columnDefinition="DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;

    @Column(columnDefinition="DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModification;

    private String version;

    private String root;

    private String type;

    public Project(){

    }


    public Project(String name, String version, String type, String root) {
        this.name = name;
        this.version = version;
        this.type = type;
        this.root = root;
        this.creationDate = new Date();
        this.lastModification = new Date();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getLastModification() {
        return lastModification;
    }

    public void setLastModification(Date lastModification) {
        this.lastModification = lastModification;
    }

    public String getRoot() { return root; }

    private void setRoot(String root) {this.root = root; }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
