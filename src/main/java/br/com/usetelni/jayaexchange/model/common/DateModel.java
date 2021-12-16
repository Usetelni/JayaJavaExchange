package br.com.usetelni.jayaexchange.model.common;

import static br.com.usetelni.jayaexchange.util.DatePatterns.YYY_MM_DD_T_HH_MM_SS;
import static br.com.usetelni.jayaexchange.util.Dates.getFormattedDate;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Embeddable;


@Embeddable
public class DateModel implements Serializable {

    private static final long serialVersionUID = 5296071796628634422L;

    public static final String CREATED_AT = "createdAt";
    public static final String UPDATED_AT = "updatedAt";
    public static final String DELETED_AT = "deletedAt";

    @Column(nullable = false, name = "createdAt")
    private LocalDateTime createdAt;

    @Column(nullable = false, name = "updatedAt")
    private LocalDateTime updatedAt;

    @Column(nullable = true, name = "deletedAt")
    private LocalDateTime deletedAt;

    
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public LocalDateTime getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(LocalDateTime deletedAt) {
        this.deletedAt = deletedAt;
    }

    public DateModel() {
    }

    public DateModel(LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime deletedAt) {
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deletedAt = deletedAt;
    }

    public DateModel(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String formattedCreatedAt() {
        return getFormattedDate(createdAt, YYY_MM_DD_T_HH_MM_SS);
    }

    public String formattedUpdatedAt() {
        return getFormattedDate(createdAt, YYY_MM_DD_T_HH_MM_SS);
    }
}
