package de.psm

import static org.grails.jaxrs.response.Responses.*

import javax.ws.rs.Consumes
import javax.ws.rs.DELETE
import javax.ws.rs.GET
import javax.ws.rs.Produces
import javax.ws.rs.PUT
import javax.ws.rs.core.Response

import org.grails.jaxrs.provider.DomainObjectNotFoundException

@Consumes(['application/xml','application/json'])
@Produces(['application/xml','application/json'])
class TodoResource {
    
    def todoResourceService
    def id
    
    @GET
    Response read() {
        ok todoResourceService.read(id)
    }
    
    @PUT
    Response update(Todo dto) {
        dto.id = id
        ok todoResourceService.update(dto)
    }
    
    @DELETE
    void delete() {
        todoResourceService.delete(id)
    }
    
}

