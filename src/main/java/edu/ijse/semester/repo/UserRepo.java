package edu.ijse.semester.repo;

import edu.ijse.semester.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepo extends MongoRepository<User,String> {
}
