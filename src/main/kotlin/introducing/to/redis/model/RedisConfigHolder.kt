package introducing.to.redis.model

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component
data class RedisConfigHolder(
    @Value("\${spring.data.redis.host}")
    var redisHost: String,

    @Value("\${spring.data.redis.port}")
    var redisPort: Int,

    @Value("\${spring.data.redis.topic}")
    var redisTopic: String
)