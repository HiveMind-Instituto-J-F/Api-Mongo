package com.apimongo.repository;

import com.apimongo.model.RegistroParadas;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RegistroParadasRepository extends MongoRepository<RegistroParadas, ObjectId> {
}
