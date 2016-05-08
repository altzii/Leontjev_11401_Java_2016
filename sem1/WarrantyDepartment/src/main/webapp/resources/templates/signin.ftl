<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Вход</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <!-- Bootstrap 3.3.5 -->
    <link rel="stylesheet" href="/resources/bootstrap/css/bootstrap.min.css">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
    <!-- Ionicons -->
    <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="/resources/dist/css/AdminLTE.css">
    <!-- iCheck -->
    <link rel="stylesheet" href="/resources/dist/css/skins/skin-purple.css">
    <link rel="stylesheet" href="/resources/plugins/iCheck/square/blue.css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body class="hold-transition login-page"  <#if from_signup??>onload="$('#myModal').modal()" </#if>>
<div class="login-box">
    <div class="login-logo">
        <a href="/"><b>Новая</b> Реальность</a>
    </div><!-- /.login-logo -->
    <div class="login-box-body">
        <p class="login-box-msg">Вход в гарантийный отдел</p>
        <form action="j_spring_security_check" method="post">
            <div class="form-group has-feedback">
                <input name="j_username" type="text" class="form-control" placeholder="логин">
                <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
            </div>
            <div class="form-group has-feedback">
                <input name="j_password" type="password" class="form-control" placeholder="пароль">
                <span class="glyphicon glyphicon-lock form-control-feedback"></span>
            </div>
        <#if error??>
            <p align="center" style="color: #a71f1f">
                Неправильный логин или пароль
            </p>
            </#if>

            <div class="row">
                <div class="col-xs-8">
                    <div class="checkbox icheck">
                        <label>
                            <input type="checkbox" name="remember-me">&nbsp;&nbsp;Запомнить меня
                        </label>
                    </div>
                </div><!-- /.col -->
                <div class="col-xs-4">
                    <button type="submit" class="btn btn-primary btn-block btn-flat">Войти</button>
                </div><!-- /.col -->
            </div>
        </form>

        <a href="/signup" class="text-center">Еще нет аккаунта?</a>

    </div><!-- /.login-box-body -->
</div><!-- /.login-box -->

<div id="myModal" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h3 align="center" class="modal-title">Вы успешно зарегистрировались!</h3>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->

<!-- jQuery 2.1.4 -->
<script src="/resources/plugins/jQuery/jQuery-2.1.4.min.js"></script>
<!-- Bootstrap 3.3.5 -->
<script src="/resources/bootstrap/js/bootstrap.min.js"></script>
<!-- iCheck -->
<script src="/resources/plugins/iCheck/icheck.min.js"></script>
<script>
    $(function () {
        $('input').iCheck({
            checkboxClass: 'icheckbox_square-blue',
            radioClass: 'iradio_square-blue',
            increaseArea: '20%' // optional
        });
    });
</script>
</body>
</html>
