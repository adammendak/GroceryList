package com.grocerylist.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@MappedSuperclass
@Getter
@Setter
public abstract class AbstractTimestampableEntity {

    @Column(name = "CREATED_AT")
    //todo dodac converter czasu na java.sql.date z javax pakietu
    private LocalDateTime createdAt;

    @Column(name = "UPDATED_AT")
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        this.setCreatedAt(LocalDateTime.now());
    }

    @PreUpdate
    protected void onUpdate() {
        this.setUpdatedAt(LocalDateTime.now());
    }
}
