package tima.main;

import com.mongodb.*;
import tima.mongo.conn.MongoConnection;

import java.net.UnknownHostException;
import java.util.Date;

public class TestMongoApp {
    public static void main(String[] args) {
        MongoClient mongoClient = MongoConnection.getInstance();
//        List<String> dbs = mongoClient.getDatabaseNames();
//        for(String db : dbs){
//            System.out.println(db);
//        }

        DB db = mongoClient.getDB("myNewDatabase");
        DBCollection table = db.getCollection("employees");

        /**** Insert ****/
        // create a document to store key and value
        BasicDBObject document = new BasicDBObject();
        document.put("name", "mkyong");
        document.put("age", 30);
        document.put("createdDate", new Date());
        table.insert(document);
        System.out.println("insert " + document + " done!");

        /**** Find and display ****/
        BasicDBObject searchQuery = new BasicDBObject();
        searchQuery.put("name", "mkyong");

        DBCursor cursor = table.find(searchQuery);

        while (cursor.hasNext()) {
            System.out.println(cursor.next());
        }

        /**** Update ****/
        // search document where name="mkyong" and update it with new values
        BasicDBObject query = new BasicDBObject();
        query.put("name", "mkyong");

        BasicDBObject newDocument = new BasicDBObject();
        newDocument.put("name", "mkyong-updated");

        BasicDBObject updateObj = new BasicDBObject();
        updateObj.put("$set", newDocument);

        table.update(query, updateObj);

        /**** Find and display ****/
        BasicDBObject searchQuery2
                = new BasicDBObject().append("name", "mkyong-updated");

        DBCursor cursor2 = table.find(searchQuery2);

        while (cursor2.hasNext()) {
            System.out.println(cursor2.next());
        }

        /**** Done ****/
        System.out.println("Done");

    }
}
