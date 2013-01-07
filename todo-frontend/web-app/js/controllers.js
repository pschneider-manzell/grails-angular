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
    $scope.original= {};
    $scope.todo = Todo.get({todoId: $routeParams.todoId},function(){$scope.original = angular.copy($scope.todo);});

    $scope.deleteSecurityQuestionVisible = false;

    $scope.update = function () {
        console.log("Updating todo...");
        $scope.todo.$update({},
            function(response, getResponseHeaders){
                $scope.displayMessage($scope.getMessage('todoUpdateSuccess',[]),'blackgloss');
                $location.path('/todos');
            },
            function(response, getResponseHeaders){
                var errorMessages = "";
                for (var i=0;i<response.data.length;i++)
                {
                    errorMessages = errorMessages+response.data[i]+'<br/>';
                }
                $scope.displayMessage($scope.getMessage('todoUpdateFailed',[errorMessages]),'danger');
            }
        );
        console.log("Finished updating todo...");



    };

    $scope.getMessage = function(messageKey,messageObjects) {
        var message =   i18nmessages[messageKey];
        for (var i=0;i<messageObjects.length;i++)
        {
            message = message.replace('${'+i+'}',messageObjects[i]);
        }
        return message;
    }

    $scope.displayMessage = function(message,type){

        $('.flashmessage').notify({
            message: { html: message},
            type: type,
            fadeOut: {
                delay: 5000
            }
        }).show();
    }

    $scope.displayErrorMessage = function(messageKey){
        var message =   i18nmessages[messageKey]
        $('.flashmessage').notify({
            message: { text: message},
            type: 'danger',
            fadeOut: {
                delay: 5000
            }
        }).show();
    }


    $scope.delete = function () {
        var todoId = $scope.todo.id;
        $scope.todo.$delete({'todoId': todoId});
        $scope.hideDeleteSecurityQuestion();
        $location.path('/todos');
    };

    $scope.reset = function () {
        $scope.todo = angular.copy($scope.original);

    }

    $scope.hideDeleteSecurityQuestion = function () {
        $scope.deleteSecurityQuestionVisible = false;
    }
    $scope.showDeleteSecurityQuestion = function () {
        $scope.deleteSecurityQuestionVisible = true;
    }

}