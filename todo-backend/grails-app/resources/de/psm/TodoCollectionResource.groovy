package de.psm

import static org.grails.jaxrs.response.Responses.*

import javax.ws.rs.Consumes
import javax.ws.rs.GET
import javax.ws.rs.Produces
import javax.ws.rs.Path
import javax.ws.rs.PathParam
import javax.ws.rs.POST
import javax.ws.rs.core.Response

@Path('/api/todo')
@Consumes(['application/xml','application/json'])
@Produces(['application/xml','application/json'])
class TodoCollectionResource {

    def todoResourceService
    
    @POST
    Response create(Todo dto) {
        created todoResourceService.create(dto)
    }

    @GET
    Response readAll() {
        ok todoResourceService.readAll()
    }
    
    @Path('/{id}')
    TodoResource getResource(@PathParam('id') Long id) {
        new TodoResource(todoResourceService: todoResourceService, id:id)
    }
        
}
