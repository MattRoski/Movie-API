package dev.mattroski.movieapi;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReviewRepository extends MongoRepository<Review, ObjectId> {

}
