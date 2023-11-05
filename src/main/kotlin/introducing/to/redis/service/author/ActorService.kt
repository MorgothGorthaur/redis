package introducing.to.redis.service.author

import introducing.to.redis.exception.ActorNotFoundException
import introducing.to.redis.exception.MovieNotFoundException
import introducing.to.redis.model.Actor


interface ActorService {
    @Throws(ActorNotFoundException::class)
    fun getActor(id: String): Actor

    fun getAllActors(): List<Actor>

    fun updateActor(actor: Actor): Actor

    fun createActor(actor: Actor): Actor

    @Throws(ActorNotFoundException::class)
    fun deleteActor(id: String)

    @Throws(ActorNotFoundException::class, MovieNotFoundException::class)
    fun addActorToMovie(actorId: String, movieId: String)
}