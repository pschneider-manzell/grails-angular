<html>
<head>
    <meta name="layout" content="angular-template"/>
</head>
<body>


    <div class="row-fluid">
        <div class="offset2 span8">
            <h1>Todos</h1>
            Search: <input ng-model="query">
            Sort by:
            <select ng-model="orderProp">
                <option value="description">Alphabetical</option>
                <option value="done">Done</option>
            </select>
            <table class="table" style="width: 100%">
                <thead>
                <tr>
                    <th>Description</th>
                    <th>Done?</th>
                </tr>
                </thead>
                <tbody>
                <tr ng-repeat="todo in todos | filter:query | orderBy:orderProp">
                    <td><a href="#/todos/{{todo.id}}">{{todo.description}}</a></td>
                    <td><input type="checkbox" ng-model ="todo.done"></td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>

</body>
</html>