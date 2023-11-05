package introducing.to.redis.exception

class MovieNotFoundException(id: String) : Exception("Unable to find movie for $id id")