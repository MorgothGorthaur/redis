package introducing.to.redis.adapter

import com.google.gson.Gson
import introducing.to.redis.model.Movie
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.data.redis.serializer.JacksonObjectReader
import org.springframework.stereotype.Component
import java.util.*

@Component
class MovieDataAdapterImpl(
    private val template: RedisTemplate<String, Any>
) : MovieDataAdapter {

    private val movieListKey = "FifoMovieList"

    override fun add(movie: Movie): Movie {
        template.opsForList().leftPush(movieListKey, movie)
        return movie
    }

    override fun poll(): Movie? {
        val toString = template.opsForList().rightPop(movieListKey).toString()
        return Gson().fromJson(toString, Movie::class.java)
    }
}