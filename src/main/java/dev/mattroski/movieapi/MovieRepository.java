package dev.mattroski.movieapi;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MovieRepository extends MongoRepository<Movie, ObjectId> {

    Optional<Movie> findMovieByImdbId(String imdbId); //we can create dynamic queries like this using any property name in your model class, AS long as they're unique
}

//the repository layer is kind the data access layer for our API
//it does the job of actually talking to the database and getting the data back
