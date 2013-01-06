function TodoListCtrl($scope,Todo) {
    $scope.todos = Todo.query({},function() {
        //good code
    }, function(response, getResponseHeaders) {
        //404 or bad
        if(response.status !=200){
            console.log("Catched status "+response.status)
        }
    });
    $scope.orderProp = 'description';
}

function TodoDetailCtrl($scope, $routeParams,$location,Todo) {
    $scope.todo = Todo.get({todoId: $routeParams.todoId});

    $scope.testclick = function(){
     alert("Clicked!");
    };

    $scope.update = function() {
        console.log("Updating todo...");
        $scope.todo.$update();
        console.log("Finished updating todo...")
        $location.path('/todos');
    }

    $scope.delete = function() {
        console.log("Deleting todo...");
        $scope.todo.$delete();
        console.log("Finished deleting todo...")
        $location.path('/todos');
    }
}