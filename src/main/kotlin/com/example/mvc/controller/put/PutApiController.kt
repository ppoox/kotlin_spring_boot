package com.example.mvc.controller.put

import com.example.mvc.model.http.Result
import com.example.mvc.model.http.UserRequest
import com.example.mvc.model.http.UserResponse
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class PutApiController {

    @PutMapping("/put-mapping")
    fun putMapping(): String {
        return "put-mapping"
    }

    @RequestMapping(method = [RequestMethod.PUT], path = ["/request-mapping"])
    fun requestMapping(): String {
        return "put-request-mapping"
    }

    @PutMapping("/put-mapping/object")
    fun putMappingObject(@RequestBody userRequest: UserRequest): UserResponse {
        // 0. Response
        return UserResponse().apply {
            // 1. result
            this.result = Result().apply {
                this.resultCode = "OK"
                this.resultMessage = "성공"
            }
        }.apply {
            // 2. description
            this.description = "~~~~~~"
        }.apply {
            // 3. user mutable list
            val userList = mutableListOf<UserRequest>()
            userList.add(userRequest)
            userList.add(userRequest.apply {
                this.name = "a"
                this.age = 10
                this.email = "a@gmail.com"
                this.address = "a address"
                this.phoneNumber = "010-1111-2222"
            })
            userList.add(userRequest.apply {
                this.name = "b"
                this.age = 20
                this.email = "b@gmail.com"
                this.address = "b address"
                this.phoneNumber = "010-1111-3333"
            })

            this.userRequest = userList
        }
    }
}