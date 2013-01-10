angular.module('todoServices', ['ngResource']).
    factory('Todo', function($resource){
        return $resource('http://localhost:8080/todo-backend/api/todo/:todoId', {'8080':':8080','ajax':'true'}, {
            query: {method:'GET', isArray:true},
            update: { method: 'PUT',params:{todoId:'@id'} },
            delete: { method: 'DELETE',params:{todoId:'@id'} }

        });
    });