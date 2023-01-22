package dev.mattroski.movieapi;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {
    @Autowired
    private MovieService movieService;
    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies(){
        return new ResponseEntity<List<Movie>>(movieService.allMovies(), HttpStatus.OK);
        //return new ResponseEntity<String>("All MOOOOVIES",HttpStatus.OK);
    }
    @GetMapping("/{imdbId}") //need Optional as may return null instead of Movie Object
    public ResponseEntity<Optional<Movie>> getSingleMovie(@PathVariable String imdbId){ //what ever we are getting through /{id}, we want to convert it to ObjectId
        //need to go to service layer and write a new method
        return new ResponseEntity<Optional<Movie>>(movieService.singleMovie(imdbId), HttpStatus.OK);
    }
}
//in REST APIs there are usually multiple layers, one of the layers is the API layer, which is this controller and will only concern itself about the task of getting a request
    //from the user and returning a response and nothing else.
//its using a service class and delegating the task of fetching all the movies from the database, and giving it back to the api layer
//so it calls the all movie method inside MovieService, gets a list of the movie and returns them with HTTP status ok. the controller doesnt know whats going on inside the servie class

//the service class MovieService will house most of the business logic.