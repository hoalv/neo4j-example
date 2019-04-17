package tima.neo4j.crud;

import tima.global.entities.User;

public class UserCrudService extends AbsCrudGenericService<User> {

    @Override
    Class<User> getEntityType() {
        return User.class;
    }
}
