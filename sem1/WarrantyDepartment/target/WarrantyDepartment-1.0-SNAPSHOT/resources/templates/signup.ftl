<#assign security=JspTaglibs["http://www.springframework.org/security/tags"] />
<#assign c=JspTaglibs["http://java.sun.com/jsp/jstl/core"] />
<#assign form=JspTaglibs["http://www.springframework.org/tags/form"]>

<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Регистрация</title>
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
    <link rel="stylesheet" href="/resources/plugins/iCheck/square/blue.css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body class="hold-transition register-page">
<div class="register-box">
    <div class="register-logo">
        <a href="/"><b>Новая</b> Реальность</a>
    </div>

    <div class="register-box-body">
        <p class="login-box-msg">Регистрация нового пользователя</p>
    <@form.form commandName="signup_form" action="/signup" acceptCharset="UTF-8"  method="post">
        <div class="form-group has-feedback">
            <@form.input id="login" name="login" path="login" class="form-control" placeholder="введите логин" />
            <p align="center"><@form.errors path="login" cssStyle="color: #ab2020;" /></p>
            <span class="glyphicon glyphicon-user form-control-feedback"></span>
        </div>
        <div class="form-group has-feedback">
            <@form.input  id="name" name="name" path="name"  class="form-control" placeholder="введите ФИО"/>
            <p align="center"><@form.errors path="name" cssStyle="color: #ab2020;" /></p>
            <span class="glyphicon glyphicon-edit form-control-feedback"></span>
        </div>
        <div class="form-group has-feedback">
            <@form.input  id="email" type="email" name="email" path="email" class="form-control" placeholder="введите e-mail"/>
            <p align="center"><@form.errors path="email" cssStyle="color: #ab2020;" /></p>
            <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
        </div>
        <div class="form-group has-feedback">
            <@form.input  id="phone" name="phone" path="phone" class="form-control" placeholder="введите номер телефона"/>
            <p align="center"><@form.errors path="phone" cssStyle="color: #ab2020;" /></p>
            <span class="glyphicon glyphicon-phone form-control-feedback"></span>
        </div>
        <div class="form-group has-feedback">
            <@form.input  id="address" name="address" path="address" class="form-control" placeholder="введите адрес"/>
            <p align="center"><@form.errors path="address" cssStyle="color: #ab2020;" /></p>
            <span class="glyphicon glyphicon-tasks form-control-feedback"></span>
        </div>
        <div class="form-group has-feedback">
            <@form.input type="password" name="password" path="password" class="form-control" placeholder="введите пароль"/>
            <p align="center"><@form.errors path="password" cssStyle="color: #ab2020;" /></p>
            <span class="glyphicon glyphicon-lock form-control-feedback"></span>

        </div>
        <div class="form-group has-feedback">
            <@form.input type="password" name="confirmPassword" path="confirmPassword" class="form-control" placeholder="повторите ввод пароля"/>
            <span class="glyphicon glyphicon-log-in form-control-feedback"></span>
        </div>
        <div>
            <p align="center"><@form.errors path="confirmPassword" cssStyle="color: #ab2020;"/></p>
        </div>

        <div class="row">
            <div class="col-xs-4" style="float: right; padding-left: 5px; padding-right: 5px; margin-right: 10px">
                <button type="submit" class="btn btn-primary btn-block btn-flat">Регистрация</button>
            </div><!-- /.col -->
        </div>
    </@form.form>
        <a href="/signin" class="text-center">У меня уже есть аккаунт</a>
    </div><!-- /.form-box -->
</div><!-- /.register-box -->

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

<script>
    $("#name").attr('required', '');
    $("#email").attr('required', '');
    $("#phone").attr('required', '');
    $("#password").attr('required', '');
    $("#confirmPassword").attr('required', '');
    $("#login").attr('required', '');
    $("#address").attr('required', '');
</script>
</body>
</html>
