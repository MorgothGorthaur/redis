package introducing.to.redis.controller

import introducing.to.redis.model.Movie
import introducing.to.redis.service.movie.MovieService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/v1/movies")
class MovieController(private val service: MovieService) {
    @PostMapping
    private fun createActor(@RequestBody movie: Movie): Movie = service.createMovie(movie)

    @GetMapping(value = ["/{id}"])
    private fun getActorById(@PathVariable id: String): Movie = service.getMovie(id)

    @PutMapping(value = ["/{id}"])
    private fun updateActor(@RequestBody movie: Movie): Movie = service.updateMovie(movie)

    @GetMapping
    private fun getActors(): List<Movie> = service.getAllMovies()

    @DeleteMapping(value = ["/{id}"])
    private fun deleteMovie(@PathVariable id: String) = service.deleteMovie(id)

}