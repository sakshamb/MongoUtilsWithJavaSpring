package com.org.mongo.connect.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.org.mongo.connect.model.StartupModel;
@Repository
public interface TimeRepository extends MongoRepository<StartupModel, String> {

}
