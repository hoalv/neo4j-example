package tima.neo4j.crud;

import tima.global.entities.Genre;

public class GenreCrudService extends AbsCrudGenericService {
    @Override
    Class getEntityType() {
        return Genre.class;
    }
}
