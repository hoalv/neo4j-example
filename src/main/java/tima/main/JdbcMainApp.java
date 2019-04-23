package tima.main;

import org.json.JSONObject;

import java.sql.*;
import java.util.Map;

public class JdbcMainApp {
    public static void main(String[] args) {
        // Connecting
        try (Connection con = DriverManager.getConnection("jdbc:neo4j:bolt://localhost", "hoalv", "123456")) {

            // Querying
            String query = "MATCH (u:User)" +
                    " WHERE u.id = {1} MATCH (u)-[:RATING]->(m:Movie)" +
                    " RETURN u, m" +
                    " LIMIT 10";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setInt(1, 2);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Map<String, Object> object = (Map<String, Object>) rs.getObject("u");
                System.out.println(object.get("_labels"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
