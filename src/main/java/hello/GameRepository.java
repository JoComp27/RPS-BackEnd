package hello;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * Created by jonathan.cournoyer on 14/09/17.
 */
@RepositoryRestResource
public interface GameRepository extends CrudRepository<Game, Long> {


}
