package tima.neo4j.crud;

import org.neo4j.ogm.cypher.Filter;
import org.neo4j.ogm.cypher.Filters;
import org.neo4j.ogm.session.Session;

import java.util.Map;


public interface ICrudService<T> {

    Iterable<T> findAll(Session session);

    T find(Session session, Long id);

    void delete(Session session, Long id);

    T createOrUpdate(Session session, T object);

    Iterable<T> findBySingleFilter(Session session, Filter filter);

    Iterable<T> findByCompositeFilter(Session session, Filters filters);

    Iterable<T> cypherQuery(Session session, String cypher, Map<String, Object> params);
}
