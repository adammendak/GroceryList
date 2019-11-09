package com.grocerylist.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@MappedSuperclass
@Getter
@Setter
public class AbstractTimestampableEntity {

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATED_AT")
    //todo dodac converter czasu na java.sql.date z javax pakietu
    private LocalDate createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "UPDATED_AT")
    private LocalDate updatedAt;

    @PrePersist
    protected void onCreate() {
        this.setCreatedAt(LocalDate.now());
    }

    @PreUpdate
    protected void onUpdate() {
        this.setUpdatedAt(LocalDate.now());
    }
}
