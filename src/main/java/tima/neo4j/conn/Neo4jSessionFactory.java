package tima.neo4j.conn;

import org.neo4j.ogm.config.Configuration;
import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.session.SessionFactory;
import tima.global.ConfigLoader;

public class Neo4jSessionFactory {
    private static Configuration configuration;
    private static SessionFactory sessionFactory;
    private static Neo4jSessionFactory factory = new Neo4jSessionFactory();

    private static String uri;
    private static String username;
    private static String password;
    private static String packages;

    static {
        loadConfig();
    }

    static void loadConfig() {
        uri = ConfigLoader.getInstance().getProperties().getProperty("neo4j.uri");
        username = ConfigLoader.getInstance().getProperties().getProperty("neo4j.username");
        password = ConfigLoader.getInstance().getProperties().getProperty("neo4j.password");
        packages = ConfigLoader.getInstance().getProperties().getProperty("neo4j.packages");
    }

    public static Neo4jSessionFactory getInstance() {
        if(factory == null){
            factory = new Neo4jSessionFactory();
        }
        return factory;
    }

    // prevent external instantiation
    private Neo4jSessionFactory() {
    }

    public Session getNeo4jSession() {
        configuration = new Configuration.Builder()
                .uri(uri)
                .credentials(username, password)
                .build();
        sessionFactory = new SessionFactory(configuration, packages);
        return sessionFactory.openSession();
    }

    public void closeSession(){
        sessionFactory.close();
    }

}
