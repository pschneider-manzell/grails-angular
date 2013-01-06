<html>
<head>
    <meta name="layout" content="angular-template"/>
</head>
<body>


    <div class="row-fluid">
        <div class="offset2 span8">
            <form>
                <fieldset>
                    <legend>Legend</legend>
                    <label>Description</label>
                    <input type="text" placeholder="Type something…" ng-model="todo.description">
                    <label class="checkbox">
                        <input type="checkbox" ng-model="todo.done"> done
                    </label>
                    <button type="submit" class="btn">Submit</button>
                </fieldset>
            </form>
        </div>
    </div>

</body>
</html>