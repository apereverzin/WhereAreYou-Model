package com.creek.whereareyoumodel.repository;

import com.creek.whereareyoumodel.domain.Identifiable;

/**
 * 
 * @author Andrey Pereverzin
 */
public interface IdentifiableRepository<T extends Identifiable> {
    Identifiable create(T identifiable);
    boolean update(T identifiable);
    boolean delete(int id);
}
