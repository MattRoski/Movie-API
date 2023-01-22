package dev.mattroski.movieapi;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    @Autowired //lets the frame know we want it to instantiate the class for us
    private MovieRepository movieRepository;

    public List<Movie> allMovies(){
        return movieRepository.findAll();//findAll() comes from the MongoRepository class
    }

    public Optional<Movie> singleMovie(ObjectId id){ //Need to have Optional<Movie> as the method may return null instead of a movie object
        return movieRepository.findById(id);
    }
}
//the service class MovieService will house most of the business logic.
//the service class uses the MovieRepository class and talks to the database, gets a list of the movies, and returns to the API layer.
