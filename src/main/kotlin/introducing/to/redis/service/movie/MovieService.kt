package introducing.to.redis.service.movie

import introducing.to.redis.exception.MovieNotFoundException
import introducing.to.redis.model.Movie

interface MovieService {
    @Throws(MovieNotFoundException::class)
    fun getMovie(id: String): Movie

    fun getAllMovies(): List<Movie>

    fun updateMovie(movie: Movie): Movie

    fun createMovie(movie: Movie) : Movie

    @Throws(MovieNotFoundException::class)
    fun deleteMovie(id: String)
}