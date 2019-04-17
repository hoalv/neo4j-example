package tima.neo4j.crud;

import org.neo4j.ogm.session.Session;

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

    abstract Class<T> getEntityType();
}

