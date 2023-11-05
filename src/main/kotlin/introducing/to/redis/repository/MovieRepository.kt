package introducing.to.redis.repository

import introducing.to.redis.model.Movie
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface MovieRepository : CrudRepository<Movie, String>