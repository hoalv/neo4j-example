package tima;

import org.neo4j.driver.v1.*;

public class DriverMainApp {
    public static void main(String[] args) {
        Driver driver = GraphDatabase.driver(
                "bolt://localhost:7687", AuthTokens.basic("hoalv", "123456"));

        Session session = driver.session();
        StatementResult result = session.run("MATCH (u:User {id: 477})" +
                " MATCH (u)-[:RATING]->(m:Movie)" +
                " RETURN u, m" +
                " LIMIT 10");
        while (result.hasNext()){
            Record record = result.next();
            System.out.println(record.get("u").keys());
        }
        session.close();
        driver.close();

        /*
        MATCH (n)
OPTIONAL MATCH (n)-[r]-()
DELETE n,r
        * */
    }
}
