package com.grocerylist.model;

import javax.persistence.*;
import java.time.LocalDate;

@MappedSuperclass
public class AbstractTimestampableEntity {

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    private LocalDate createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at")
    private LocalDate updatedAt;

    @PrePersist
    protected void onCreate() {
        this.setCreatedAt(this.setUpdatedAt(LocalDate.now()));
    }

    @PreUpdate
    protected void onUpdate() {
        this.setUpdatedAt(LocalDate.now());
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDate getUpdatedAt() {
        return updatedAt;
    }

    public LocalDate setUpdatedAt(LocalDate updatedAt) {
        this.updatedAt = updatedAt;
        return updatedAt;
    }
}
