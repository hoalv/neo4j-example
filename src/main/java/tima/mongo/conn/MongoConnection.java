package tima.mongo.conn;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import tima.global.ConfigLoader;

import java.net.UnknownHostException;

public class MongoConnection {
    private static String host;
    private static Integer port;

    private static MongoClient mongoClient;

    static {
        loadConfig();
    }

    private static void loadConfig() {
        host = ConfigLoader.getInstance().getProperties().getProperty("mongo.host");
        port = Integer.valueOf(ConfigLoader.getInstance().getProperties().getProperty("mongo.port"));
    }

    private MongoConnection(){};

    public static MongoClient getInstance(){
        if(mongoClient == null){
            try {
                mongoClient = new MongoClient( host , port );
            } catch (UnknownHostException e) {
                e.printStackTrace();
            }
        }

        return mongoClient;
    }

    public DB getDatabase(String dbName){
       return mongoClient.getDB(dbName);
    }
}
