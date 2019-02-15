package com.example.meetup


import org.springframework.http.ResponseEntity
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.util.concurrent.atomic.AtomicLong

@RestController
@RequestMapping("v1/users")
class UserController {

    @Autowired
    val userRepository: UserRepository? = null  //Cade a implemenação?

    private val counter = AtomicLong()
    val MESSAGE = "FOI-SE O BOI COM A CORDA, MOSTRE APENAS OS SLIDES!"

    @GetMapping("/test")
    fun test(): ResponseEntity<User> {
        return ResponseEntity.ok(User())
    }

    @GetMapping("/clear")
    @ResponseBody
    fun clear(): ResponseEntity<Any> {
        if(userRepository != null)
            userRepository!!.deleteAll()
        else
            println(MESSAGE)
        return ResponseEntity.ok("é nois na fita mano!")
    }

    @GetMapping()
    @ResponseBody
    fun getAllUsers(): Iterable<User>? {

        if(userRepository != null){
            var user = User()
            user.email = "vegeta_${counter.incrementAndGet()}@test.com"
            user.name = "vegeta_${counter.incrementAndGet()}"

            var user1 = User()
            user1.email = "goku_${counter.incrementAndGet()}@test.com"
            user1.name = "goku${counter.incrementAndGet()}"

            userRepository!!.save(user)
            userRepository!!.save(user1)

            return userRepository!!.findAll()
        }
        println(MESSAGE)
        return null
    }
}



//    @GetMapping("/by_email")
//    fun allByEmail(page: Pageable?, @RequestParam("email") email: String?): ResponseEntity<Page<User>> {
//
//        if(userRepository != null)
//            return ResponseEntity.ok(userRepository!!.findAllByEmailLike(email, page))
//
//        println(MESSAGE)
//
//        return ResponseEntity.ok(Page.empty())
//    }
