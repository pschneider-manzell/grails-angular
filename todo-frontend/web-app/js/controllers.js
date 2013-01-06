function TodoListCtrl($scope, Todo) {
    $scope.todos = Todo.query({}, function () {
        //good code
    }, function (response, getResponseHeaders) {
        //404 or bad
        if (response.status != 200) {
            console.log("Catched status " + response.status)
        }
    });
    $scope.orderProp = 'description';
}

function TodoDetailCtrl($scope, $routeParams, $location, $locale,Todo) {
    $scope.todo = Todo.get({todoId: $routeParams.todoId});
    $scope.deleteSecurityQuestionVisible = false;

    $scope.update = function () {
        console.log("Updating todo...");
        $scope.todo.$update();
        $scope.displaySuccessMessage('todoUpdated');
        console.log("Finished updating todo...");


        $location.path('/todos');
    };

    $scope.displaySuccessMessage = function(messageKey){
        var message =   i18nmessages[messageKey]
        $('.flashmessage').notify({
            message: { text: message},
            type: 'blackgloss',
            fadeOut: {
                delay: 5000
            }
        }).show();
    }


    $scope.delete = function () {
        console.log("Deleting todo...");
        var todoId = $scope.todo.id;
        $scope.todo.$delete({'todoId': todoId});
        $scope.hideDeleteSecurityQuestion();
        console.log("Finished deleting todo " + todoId + "...");
        $location.path('/todos');
    };

    $scope.hideDeleteSecurityQuestion = function () {
        $scope.deleteSecurityQuestionVisible = false;
    }
    $scope.showDeleteSecurityQuestion = function () {
        $scope.deleteSecurityQuestionVisible = true;
    }
}