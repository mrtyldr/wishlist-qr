package com.wusly.wishlistqr.core;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Persistable;

import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.Objects;


@MappedSuperclass
@Getter
@Setter
public abstract class Aggregate<ID extends Serializable> implements Persistable<ID>{

    @Transient
    private boolean isNew = false;


    @NotNull
    @Id
    protected ID id;


    OffsetDateTime createdAt = OffsetDateTime.now();

    OffsetDateTime updatedAt = createdAt;

    protected void markAsNew() {
        isNew = true;
    }

    @Override
    public boolean isNew() {
        return isNew;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aggregate<?> aggregate = (Aggregate<?>) o;
        return Objects.equals(id, aggregate.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
