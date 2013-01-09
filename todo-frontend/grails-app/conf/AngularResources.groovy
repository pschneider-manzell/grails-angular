modules = {

    bootstrapnotify {
        resource url:'js/bootstrap-notify/alert-notification-animations.css'
        resource url:'js/bootstrap-notify/bootstrap-notify.css'
        resource url:'js/bootstrap-notify/alert-blackgloss.css'
        resource url:'js/bootstrap-notify/bootstrap-notify.js',disposition: 'head'
    }

    angular {
        resource url:'js/lib/angular.js',disposition: 'head'
        resource url:'js/lib/angular-resource.js',disposition: 'head'
    }

    angularui {
        dependsOn 'angular'
        resource url:'js/angular-ui/0_3_2/angular-ui.css'
        resource url:'js/angular-ui/0_3_2/angular-ui.js',disposition: 'head'
    }

    angularauthinterceptor {
        dependsOn 'angular'
        resource url:'js/lib/http-auth-interceptor.js',disposition: 'head'
    }

    todoapp {
        dependsOn 'bootstrap, angularui, bootstrapnotify, angularauthinterceptor'
        resource url:'css/todo.css'
        resource url:'js/services.js',disposition: 'head'
        resource url:'js/controllers.js',disposition: 'head'
        resource url:'js/app.js',disposition: 'head'
    }
}