<html>
<head>
    <meta name="layout" content="angular-template"/>
</head>
<body>
<script type="text/javascript">
    $(function() {
        updateI18NMap({
            todoUpdateSuccess : '${message(code:'todo.updated').encodeAsHTML()}',
            todoUpdateFailed : '${message(code:'todo.update.failed')}'
        });
    });


</script>

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
                    <button type="button" class="btn" ng-click="reset()">Reset</button>
                    <button type="button" class="btn btn-primary" ng-click="update()">Update</button>
                    <button type="button" class="btn" ng-click="showDeleteSecurityQuestion()">Delete</button>
                </fieldset>
            </form>
        </div>
    </div>

<div ui-modal class="fade" ng-model="deleteSecurityQuestionVisible" id="deleteSecurityQuestion">
    <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <h3>Security question</h3>
    </div>
    <div class="modal-body">
        <p>Do you really want to delete todo <i>{{todo.description}}?</i></p>
    </div>
    <div class="modal-footer">
        <a ng-click="delete();" class="btn btn-primary">Yes</a>
        <a ng-click="hideDeleteSecurityQuestion();" class="btn">No</a>
    </div>


</div>

</body>
</html>