<!DOCTYPE html>
<html lang="en" ng-app="todoapp">
<head>
    <g:layoutTitle/>
    <style>
    body {
        padding-top: 60px; /* 60px to make the container go all the way to the bottom of the topbar */
    }
    </style>
    <r:script>
        var i18nmessages={};

        function updateI18NMap(newI18NMessages) {
            jQuery.each(newI18NMessages, function(key, val) {
                i18nmessages[key] = val
            });
        }

    </r:script>
    <r:layoutResources/>
</head>
<body>
<div class='notifications bottom-right flashmessage'></div>
<div class="navbar navbar-inverse navbar-fixed-top">
    <div class="navbar-inner">
        <div class="container">
            <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </a>
            <a class="brand" href="#">Angular Grails SplitTest</a>
            <div class="nav-collapse collapse">
                <ul class="nav">
                    <li class="active"><a href="#">Home</a></li>
                    <li><a href="#about">About</a></li>
                    <li><a href="#contact">Contact</a></li>
                </ul>
            </div><!--/.nav-collapse -->
        </div>
    </div>
</div>

<g:layoutBody/>
<r:layoutResources/>
</body>
</html>