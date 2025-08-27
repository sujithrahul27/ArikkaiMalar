package com.sura.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.sura.model.Users;
@Repository
public interface UserRepo extends MongoRepository<Users, Integer> {

	Users findByusername(String username);

}
