package introducing.to.redis.service.author

import introducing.to.redis.exception.ActorNotFoundException
import introducing.to.redis.exception.MovieNotFoundException
import introducing.to.redis.model.Actor
import introducing.to.redis.repository.ActorRepository
import introducing.to.redis.repository.MovieRepository
import org.springframework.stereotype.Service

@Service
class DefaultActorService(private val repo: ActorRepository, private val movieRepo: MovieRepository): ActorService {
    override fun getActor(id: String): Actor = repo.findById(id).orElseThrow { ActorNotFoundException(id) }

    override fun getAllActors(): List<Actor> = repo.findAll().toList()

    override fun updateActor(actor: Actor): Actor = repo.save(actor)

    override fun createActor(actor: Actor): Actor = repo.save(actor)

    override fun deleteActor(id: String) = repo.deleteById(id)

    override fun addActorToMovie(actorId: String, movieId: String) {
        val actor = repo.findById(actorId).orElseThrow { ActorNotFoundException(actorId) }
        val movie = movieRepo.findById(movieId).orElseThrow { MovieNotFoundException(movieId) }
        movie.actors += actor
    }
}