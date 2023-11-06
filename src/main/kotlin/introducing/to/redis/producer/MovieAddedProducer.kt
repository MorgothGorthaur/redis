package introducing.to.redis.producer

import introducing.to.redis.model.Movie
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.data.redis.listener.ChannelTopic
import org.springframework.stereotype.Component

@Component
class MovieAddedProducer(
    private val template: RedisTemplate<String, Any>,
    private val channelTopic: ChannelTopic
) {

    private companion object {
        val logger: Logger = LoggerFactory.getLogger(MovieAddedProducer::class.java)
    }

    fun publish(movie: Movie) {
        logger.info("Notifying subscribers on adding a new Movie {} {}", movie.id, movie.name)
        template.convertAndSend(channelTopic.topic, movie)
    }
}