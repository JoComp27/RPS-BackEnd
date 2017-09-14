package hello;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by erin.benderoff on 14/09/17.
 */
@RepositoryRestResource
public interface PlayerRepository extends CrudRepository<Player, Long> {
}
