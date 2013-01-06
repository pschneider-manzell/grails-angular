function TodoListCtrl($scope,$http) {
    $http.get('http://localhost:8080/todo-backend/api/todo').success(function(data) {
        $scope.todos = data;
    });
    $scope.orderProp = 'description';
}

function TodoDetailCtrl($scope, $routeParams,$http) {
    $http.get('http://localhost:8080/todo-backend/api/todo/' + $routeParams.todoId).success(function(data) {
        $scope.todo = data;
    });
}