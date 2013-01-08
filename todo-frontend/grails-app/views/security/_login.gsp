<div id="login-holder">
    <div id="loginbox">
        <div id="login-inner" ng-controller="LoginCtrl">
            Note: user/testpass or admin/testpass.<br>&nbsp;
            <form ng-submit="submit()">
                <table border="0" cellpadding="0" cellspacing="0">
                    <tr>
                        <th>Username</th>
                        <td><input type="text" class="login-inp" ng-model="username"/></td>
                    </tr>
                    <tr>
                        <th>Password</th>
                        <td><input type="password" class="login-inp" ng-model="password"/></td>
                    </tr>
                    <tr>
                        <th></th>
                        <td><input type="submit" class="btn" value="Login"></td>
                    </tr>
                </table>
            </form>
        </div>
        <div class="clear"></div>
    </div>
</div>