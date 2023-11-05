package introducing.to.redis.service.movie

import introducing.to.redis.exception.MovieNotFoundException
import introducing.to.redis.model.Movie
import introducing.to.redis.repository.MovieRepository
import org.springframework.stereotype.Service

@Service
class DefaultMovieService(private val repo: MovieRepository) : MovieService {

    override fun getMovie(id: String): Movie = repo.findById(id).orElseThrow { MovieNotFoundException(id) }

    override fun getAllMovies(): List<Movie> = repo.findAll().toList()

    override fun updateMovie(movie: Movie): Movie = repo.save(movie)

    override fun createMovie(movie: Movie): Movie = repo.save(movie)

    override fun deleteMovie(id: String) = repo.deleteById(id)
}