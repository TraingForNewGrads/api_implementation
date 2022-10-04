package org.example.insurance.adapters.persistence;

import java.io.Serializable;

public interface PersistenceObject<T> extends Serializable {
    T toDomainModel();
}
