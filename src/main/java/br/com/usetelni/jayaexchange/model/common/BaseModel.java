package br.com.usetelni.jayaexchange.model.common;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.*;

import static br.com.usetelni.jayaexchange.util.TimeZones.getUtc;

@MappedSuperclass
public class BaseModel<T extends BaseModel<T>> implements Serializable {

    private static final long serialVersionUID = -1112571230237032841L;


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, name = "id")
    private Long id;

    @Embedded
    private DateModel dateModel;

    @Version
    @Column(nullable = false, name = "version")
    private Integer version;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DateModel getDateModel() {
        return dateModel;
    }

    public void setDateModel(DateModel dateModel) {
        this.dateModel = dateModel;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    @PrePersist
    public void initializeDates() {
        LocalDateTime now = LocalDateTime.now(getUtc());
        dateModel = new DateModel(now, now, null);
    }

    @PreUpdate
    public void updateUpdatedAt() {
        dateModel.setUpdatedAt(LocalDateTime.now(getUtc()));
    }
}
