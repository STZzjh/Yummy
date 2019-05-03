<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>${seo.mainName} Log in</title>
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <link rel="stylesheet" href="/static/plugins/bootstrap/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="/static/plugins/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="/static/plugins/Ionicons/css/ionicons.min.css">
    <link rel="stylesheet" href="/static/plugins/adminlte/dist/css/AdminLTE.min.css">
    <link rel="stylesheet" href="/static/plugins/iCheck/square/blue.css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

    <!-- Google Font -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
</head>
<body class="hold-transition login-page" style="

background: url('/static/app/images/login.jpg');background-repeat:no-repeat; background-size:100% 100%;">
<div class="login-box">
    <div class="login-logo">
        <a href="/"><b>${seo.mainName}</b></a>
    </div>
    <!-- /.login-logo -->
    <div class="login-box-body">
        <p class="login-box-msg">${msg}</p>

        <form action="/login" id="loginForm" method="post">
            <div class="form-group has-feedback">
                <input type="text" name="username" class="form-control" placeholder="编号">
                <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
            </div>
            <div class="form-group has-feedback">
                <input type="password" name="password" class="form-control" placeholder="密码">
                <span class="glyphicon glyphicon-lock form-control-feedback"></span>
            </div>
            <div class="row">
                <div class="col-xs-8">
                    <select class="form-control" name="type" id="">
                        <option value="user">普通用户</option>
                        <option value="restaurant">餐厅</option>
                        <option value="admin">系统管理员</option>
                    </select>
                </div>
                <!-- /.col -->
                <div class="col-xs-4">
                    <button type="submit" class="btn btn-primary btn-block btn-flat">登录</button>
                </div>
                <!-- /.col -->
            </div>
        </form>

        <!-- /.social-auth-links -->
        <a href="register" class="text-center">注册</a>

    </div>
    <!-- /.login-box-body -->
</div>
<!-- /.login-box -->

<!-- jQuery 3 -->
<script src="/static/plugins/jquery/dist/jquery.min.js"></script>
<!-- Bootstrap 3.3.7 -->
<script src="/static/plugins/bootstrap/dist/js/bootstrap.min.js"></script>
<script src="/static/plugins/validate/bootstrapValidator.min.js"></script>
<script src="/static/plugins/validate/zh_CN.js"></script>

<script>
    var validateFields = {
        username: {
            validators: {
                notEmpty: {
                    message: '不能为空'
                }
            }
        },
        password: {
            validators: {
                stringLength: {
                    min: 6,
                    max: 20,
                    message: '密码长度6-20！'
                },
                notEmpty: {
                    message: '不能为空'
                }
            }
        },
    }

    $('#loginForm').bootstrapValidator({
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: validateFields,
        live: 'enabled',
        message: '该字段不能为空'
    });
</script>
</body>
</html>

