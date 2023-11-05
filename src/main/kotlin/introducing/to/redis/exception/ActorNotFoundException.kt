package introducing.to.redis.exception

class ActorNotFoundException (id: String) : Exception("Unable to find actor for $id id")