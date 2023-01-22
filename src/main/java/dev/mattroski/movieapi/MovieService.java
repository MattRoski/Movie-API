package dev.mattroski.movieapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    @Autowired //lets the frame know we want it to instantiate the class for us
    private MovieRepository movieRepository;

    public List<Movie> allMovies(){
        return movieRepository.findAll();//findAll() comes from the MongoRepository class
    }

}
