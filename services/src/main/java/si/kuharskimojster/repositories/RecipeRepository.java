package si.kuharskimojster.repositories;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import si.kuharskimojster.entities.RecipeNode;

import java.util.Collection;

@Repository
public interface RecipeRepository extends Neo4jRepository<RecipeNode, Long> {

    @Query("MATCH (:User {userId: {userId}})-[:SUBSCRIBES_TO]->(user:User) RETURN user.userId")
    Collection<Long> getUsersSubscriptions(@Param("userId") Long userId);
}
