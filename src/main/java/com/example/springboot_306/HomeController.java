package com.example.springboot_306;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashSet;
import java.util.Set;

@Controller
public class HomeController {

    @Autowired
    DirectorRepo directorRepo;

    @RequestMapping("/")
    public String index(Model model){
        //Making a Director
        Director director = new Director();
        director.setName("Michael Bay");
        director.setGenre("Action");


        //Adding a movie
        Movie movie = new Movie();
        movie.setTitle("Transformers");
        movie.setYear(2009);
        movie.setDescription("About Car Robots");

        //Make a list
        Set<Movie> movies = new HashSet<Movie>();
        movies.add(movie); // this adds the first movie we made to the the empty list.

        movie = new Movie(); // this is a new instance of another movie using the same variable. essentially clearing the old entry (Stored on the list)
        movie.setTitle("Transformers 2");
        movie.setYear(2011);
        movie.setDescription("another movies about robot cars");
        movies.add(movie); // adding the second movie to the directors list

        //add the list of movies to the directors movie list.
        director.setMovies(movies); // this part is adding all the movies made by the director Michael bay to his object (Prior to this Michale bay had no movies)

        directorRepo.save(director); // adding this object to the DB (The object director is the instance of Michael bay)

        model.addAttribute("directors", directorRepo.findAll());
        return"index";
    }


}
