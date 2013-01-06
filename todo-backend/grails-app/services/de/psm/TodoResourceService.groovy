package de.psm

import org.grails.jaxrs.provider.DomainObjectNotFoundException

class TodoResourceService {
    
    def create(Todo dto) {
        dto.save()
    }

    def read(Long id) {
        def obj = Todo.get(id)
        if (!obj) {
            throw new DomainObjectNotFoundException(Todo.class, id)
        }
        obj
    }
    
    def readAll() {
        Todo.findAll()
    }
    
    def update(Todo dto) {
        def obj = Todo.get(dto.id)
        if (!obj) {
            throw new DomainObjectNotFoundException(Todo.class, dto.id)
        }
        obj.properties = dto.properties 
        obj
    }
    
    void delete(Long id) {
        def obj = Todo.get(id)
        if (obj) { 
            obj.delete()
        }
    }
    
}

