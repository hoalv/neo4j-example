package tima.neo4j.crud;

import tima.global.entities.Movie;

public class MovieCrudService extends AbsCrudGenericService {
    @Override
    Class getEntityType() {
        return Movie.class;
    }
}
