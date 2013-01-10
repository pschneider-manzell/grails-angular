package de.psm

import grails.converters.JSON
import grails.plugins.springsecurity.Secured

class TodoController {

    def list() {
        int pageSize = params.pageSize ?  params.pageSize as int :10
        if(pageSize>50){
            pageSize = 50
        }
        int offset = params.offset ?  params.offset as int :0
        String sortOrder = params.sortOrder? params.sortOrder:'description'
        String order = params.order?params.order :'asc'

        log.error("Entering list...")
        render Todo.list(max: pageSize, offset: offset,sort:sortOrder,order:order) as JSON
    }
    @Secured(['ROLE_USER'])
    def show(Long id) {
        log.error("Entering show...")
        withTodo { todoInstance ->
            render todoInstance as JSON
        }

    }

    def update(Long id) {
        log.error("Entering update with params $params...")
        withTodo { todoInstance ->
            todoInstance.properties = params['todo']
            todoInstance.save(flush:true)
            if(todoInstance.hasErrors()){
                log.error("Todo instance has errors!")
                response.status = 500
                render todoInstance.errors.allErrors.collect {
                    message(error:it,encodeAs:'HTML')
                } as JSON
            }
            else {
                render todoInstance as JSON
            }
        }
    }

    def delete(Long id) {
        log.error("Entering delete...")
        withTodo { todoInstance ->
            todoInstance.delete(flush: true)
            render "{message:'Todo deleted!'}"
        }
    }

    def save() {
        log.error("Entering save...")
        Todo todoInstance = new Todo()
        todoInstance.properties = params['todo']
        todoInstance.save(flush:true)
        if(todoInstance.hasErrors()){
            log.error("Todo instance has errors!")
            response.status = 500
            render todoInstance.errors.allErrors.collect {
                message(error:it,encodeAs:'HTML')
            } as JSON
        }
        else {
            render todoInstance as JSON
        }

    }

    private def withTodo(id = "id", Closure c) {
        def todoInstance = Todo.get(params[id])
        if (todoInstance) {
            c.call todoInstance
        } else {
            render "{message:'Todo was not found!'}"
            response.status = 404;
        }
    }
}
