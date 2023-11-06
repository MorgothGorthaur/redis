package introducing.to.redis.consumer

import com.fasterxml.jackson.databind.ObjectMapper
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.data.redis.connection.Message
import org.springframework.data.redis.connection.MessageListener
import org.springframework.stereotype.Component

@Component
class MovieAddedListener(private val objectMapper: ObjectMapper) : MessageListener {

    private companion object {
        val logger : Logger = LoggerFactory.getLogger(MovieAddedListener::class.java)
    }

    override fun onMessage(message: Message, pattern: ByteArray?) {
        val movieMap = objectMapper.readValue(message.toString(), Map::class.java)
        logger.info("Notified on a new Movie creation {}, {}", movieMap["id"], movieMap["name"])
    }

}