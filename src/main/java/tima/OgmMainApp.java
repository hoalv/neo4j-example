package tima;

import org.neo4j.ogm.cypher.BooleanOperator;
import org.neo4j.ogm.cypher.ComparisonOperator;
import org.neo4j.ogm.cypher.Filter;
import org.neo4j.ogm.cypher.Filters;
import org.neo4j.ogm.session.Session;
import tima.global.entities.Movie;
import tima.neo4j.conn.Neo4jSessionFactory;

import java.util.*;


public class OgmMainApp {
    public static void main(String[] args) {

        //open session
        Session session = Neo4jSessionFactory.getInstance().getNeo4jSession();

        /*//load by native id of neo4j
        Movie movie = session.load(Movie.class, 0l);*/

        /*//load by filter by property of node
        Filter filter = new Filter("title", ComparisonOperator.EQUALS,"Toy Story (1995)");
        List<Movie> movies = (List<Movie>) session.loadAll(Movie.class, filter);
        movies.forEach(m -> {
            System.out.println(m.getTitle());

        });*/

        //  load by mutil property
        Filters composite = new Filters();
        Filter filter = new Filter ("id", ComparisonOperator.EQUALS, 1);
        composite.add(filter);
        filter = new Filter ("title", ComparisonOperator.EQUALS, "Toy Story (1995)");
        filter.setBooleanOperator(BooleanOperator.AND);
        composite.add(filter);
        //  Load all Persons which match the composite filter.
        List<Movie> movieList = (List<Movie>) session.loadAll (Movie.class, composite);
        movieList.forEach(m -> {
            System.out.println(m.getTitle());
        });

        /*//  use cypher
        Map<String, Object> params = new HashMap<>(1);
        params.put ("title", "Toy Story (1995)");
        params.put ("id", 1);
        //  Execute query and return the other side of the married relationship
        String cypher = "MATCH (m:Movie {title:$title , id:$id}) RETURN m";
        List<Movie> movieList = (List<Movie>) session.query (Movie.class, cypher, params);
        movieList.forEach(m -> {
            System.out.println(m.getTitle());
        });*/


        /*//test create node
        Movie movie = new Movie();
        movie.setTitle("3 idiots");
        new MovieCrudService().createOrUpdate(session, movie);

        User user  = new User();
        user.setUserId(1000l);
        Set<Movie> rateM = new HashSet<>();
        rateM.add(movie);
        user.setRatingMovies(rateM);
        new UserCrudService().createOrUpdate(session, user);
*/
        //close session
        Neo4jSessionFactory.getInstance().closeSession();

    }
}
