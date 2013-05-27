package com.creek.whereareyoumodel.repository;

import com.creek.whereareyoumodel.domain.Identifiable;

/**
 * 
 * @author andreypereverzin
 */
public interface IdentifiableRepository<T extends Identifiable> {
    Identifiable create(T identifiable);
    boolean update(T identifiable);
    boolean delete(int id);
}
