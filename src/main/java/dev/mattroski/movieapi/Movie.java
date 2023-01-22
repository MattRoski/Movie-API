package dev.mattroski.movieapi;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

@Document(collection = "movies")
@Data //comes from lombok, takes care of all getters,setters, and toString methods
@AllArgsConstructor //creates a constructor with 1 parameter for each field in your class
@NoArgsConstructor //generates a constructor with no parameters
public class Movie {
    @Id//this property should be treated as the unique id for each movie in the db
    private ObjectId id;
    private String imdbId;
    private String title;
    private String releaseDate;
    private String trailerLink;
    private String poster;
    private List<String> genres;
    private List<String> backdrops;
    @DocumentReference//cause the db toi store only the id of the reviews, the reviews will be separte collection
    private List<Review> reviewIds;

}
