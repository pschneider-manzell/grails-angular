angular.module('todoapp', ['todoServices','ui','http-auth-interceptor']).
    config(['$routeProvider', function($routeProvider) {
        $routeProvider.
            when('/todos', {templateUrl: 'todo/list.html',   controller: TodoListCtrl}).
            when('/todos/:todoId', {templateUrl: 'todo/detail.html', controller: TodoDetailCtrl}).
            otherwise({redirectTo: '/todos'});
    }]);

