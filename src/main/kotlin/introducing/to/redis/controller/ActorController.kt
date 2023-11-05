package introducing.to.redis.controller

import introducing.to.redis.model.Actor
import introducing.to.redis.service.author.ActorService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/v1/actors")
class ActorController(private val service: ActorService) {
    @PostMapping
    private fun createActor(@RequestBody actor: Actor): Actor = service.createActor(actor)

    @GetMapping(value = ["/{id}"])
    private fun getActorById(@PathVariable id: String): Actor = service.getActor(id)

    @PutMapping(value = ["/{id}"])
    private fun updateActor(@RequestBody actor: Actor): Actor = service.updateActor(actor)

    @GetMapping
    private fun getActors(): List<Actor> = service.getAllActors()

    @DeleteMapping(value = ["/{id}"])
    private fun deleteActor(@PathVariable id: String) = service.deleteActor(id)

    @PatchMapping(value = ["/{actorId}/link/{movieId}"])
    private fun addActorToMovie(@PathVariable actorId: String, @PathVariable movieId: String) =
        service.addActorToMovie(actorId, movieId)

}