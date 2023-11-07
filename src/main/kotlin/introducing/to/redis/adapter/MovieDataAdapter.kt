package introducing.to.redis.adapter

import introducing.to.redis.model.Movie

interface MovieDataAdapter {
    fun add(movie: Movie): Movie
    fun poll(): Movie?
}