angular.module('todoServices', ['ngResource']).
    factory('Todo', function($resource){
        return $resource('api/todo/:todoId',{}, {
            query: {method:'GET', params:{}, isArray:true},
            update: { method: 'PUT',params:{todoId:'@id'} },
            delete: { method: 'DELETE',params:{todoId:'@id'} }

        });
    });