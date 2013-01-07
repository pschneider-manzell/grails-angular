package de.psm

import grails.converters.JSON

class TodoController {

    def list() {
        log.error("Entering list...")
        render Todo.list() as JSON
    }

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
