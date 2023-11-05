package introducing.to.redis.repository

import introducing.to.redis.model.Actor
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ActorRepository : CrudRepository<Actor, String>