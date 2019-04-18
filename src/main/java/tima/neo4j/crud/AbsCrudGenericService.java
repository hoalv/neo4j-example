package tima.neo4j.crud;

import org.neo4j.ogm.cypher.Filter;
import org.neo4j.ogm.cypher.Filters;
import org.neo4j.ogm.session.Session;

import java.util.Map;


public abstract class AbsCrudGenericService<T> implements ICrudService<T> {

    private static final int DEPTH_LIST = 0;
    private static final int DEPTH_ENTITY = 1;
//    protected Session session = Neo4jSessionFactory.getInstance().getNeo4jSession();

    @Override
    public Iterable<T> findAll(Session session) {
        return session.loadAll(getEntityType(), DEPTH_LIST);
    }

    @Override
    public T find(Session session, Long id) {
        return session.load(getEntityType(), id, DEPTH_ENTITY);
    }

    @Override
    public void delete(Session session, Long id) {
        session.delete(session.load(getEntityType(), id));
    }

    @Override
    public T createOrUpdate(Session session, T entity) {
        session.save(entity, DEPTH_ENTITY);
        return entity;
    }

    @Override
    public Iterable<T> findBySingleFilter(Session session, Filter filter) {
        return session.loadAll(getEntityType(), filter);
    }

    @Override
    public Iterable<T> findByCompositeFilter(Session session, Filters filters) {
        return session.loadAll(getEntityType(), filters);
    }

    @Override
    public Iterable<T> cypherQuery(Session session, String cypher, Map<String, Object> params) {
        return session.query(getEntityType(), cypher, params);
    }

    abstract Class<T> getEntityType();
}

