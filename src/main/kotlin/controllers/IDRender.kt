package controllers


import helpers.IDFactory
import io.ktor.application.ApplicationCall
import io.ktor.http.ContentType
import io.ktor.response.respondText
import libs.json.toJson


class IDRender(val call: ApplicationCall){
    suspend fun index(){
        val prefix = call.parameters.get("prefix")?:""
        val id = IDFactory.getId()
        call.respondText(prefix+id, ContentType.Text.Plain)
    }

    suspend fun peek(){
        val ids = IDFactory.peekBuffer().toJson()
        call.respondText(ids, ContentType.Text.Plain)
    }

    suspend fun verify(){
        val id = call.parameters.get("id")?:""
        call.respondText(IDFactory.verify(id).toString(), ContentType.Text.Plain)
    }
}