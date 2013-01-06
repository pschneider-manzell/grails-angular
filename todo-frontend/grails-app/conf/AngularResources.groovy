modules = {
    angular {
        resource url:'http://ajax.googleapis.com/ajax/libs/angularjs/1.0.3/angular.js',disposition: 'head'
    }

    todoapp {
        dependsOn 'bootstrap,angular'
        resource url:'js/controllers.js',disposition: 'head'
        resource url:'js/app.js',disposition: 'head'
    }
}