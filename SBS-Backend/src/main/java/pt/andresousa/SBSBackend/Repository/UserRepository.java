package pt.andresousa.SBSBackend.Repository;

import org.springframework.data.repository.CrudRepository;
import pt.andresousa.SBSBackend.Entity.User;

public interface UserRepository extends CrudRepository<User, Integer> {
}
