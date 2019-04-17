package tima.neo4j.crud;

import org.neo4j.ogm.session.Session;

public interface ICrudService<T> {

    Iterable<T> findAll(Session session);

    T find(Session session, Long id);

    void delete(Session session, Long id);

    T createOrUpdate(Session session, T object);
}
