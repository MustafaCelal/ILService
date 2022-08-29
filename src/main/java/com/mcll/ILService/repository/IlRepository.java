package com.mcll.ILService.repository;

import com.mcll.ILService.model.Il;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface IlRepository extends MongoRepository<Il, String> {
    Optional<List<Il>> findByName(String name);
}
