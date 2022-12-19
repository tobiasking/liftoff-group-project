package org.liftoff.project.data;

import org.liftoff.project.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {


   //use a query method to find a User by username

   User findByUserName(String username);



}