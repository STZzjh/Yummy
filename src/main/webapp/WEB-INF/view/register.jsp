<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>${seo.mainName}</title>
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <link rel="stylesheet" href="/static/plugins/bootstrap/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="/static/plugins/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="/static/plugins/Ionicons/css/ionicons.min.css">
    <link rel="stylesheet" href="/static/plugins/adminlte/dist/css/AdminLTE.min.css">
    <script src="/static/plugins/jquery/dist/jquery.min.js"></script>
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

    <!-- Google Font -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
</head>
<body class="hold-transition register-page" style="background: url('/static/app/images/register.jpg');background-repeat:no-repeat; background-size:100% 100%;"">
<div class="register-box" style="    background: #fff;">
    <div class="register-logo">
        <a href="/"><b>用户注册</b></a>
    </div>

    <div class="register-box-body">
        <p class="login-box-msg">${not empty msg?msg:"注册账号"}</p>

        <form action="/register" id="registerForm" method="post" accept-charset="UTF-8" enctype="application/x-www-form-urlencoded;charset=UTF-8">
            <div class="form-group has-feedback">
                <input type="text" name="username" class="form-control" placeholder="用户名">
                <span class="glyphicon glyphicon-user form-control-feedback"></span>
            </div>
            <div class="form-group has-feedback">
                <input type="password" name="password" class="form-control" placeholder="密码">
                <span class="glyphicon glyphicon-lock form-control-feedback"></span>
            </div>
            <div class="form-group has-feedback">
                <input type="password" name="repassword" class="form-control" placeholder="重复密码">
                <span class="glyphicon glyphicon-log-in form-control-feedback"></span>
            </div>
            <div class="form-group has-feedback">
                <input type="text" name="name" class="form-control" placeholder="姓名">
                <span class="glyphicon glyphicon-user form-control-feedback"></span>
            </div>
            <div class="form-group has-feedback">
                <input type="email" name="email" class="form-control" placeholder="邮箱">
                <span class="glyphicon glyphicon-user form-control-feedback"></span>
            </div>
            <div class="row">
                <div class="col-xs-8">
                    <div class="checkbox icheck">

                    </div>
                </div>
                <!-- /.col -->
                <div class="col-xs-4">
                    <button type="submit" class="btn btn-primary btn-block btn-flat">注册</button>
                </div>
                <!-- /.col -->
            </div>
        </form>

        <a href="javascript:;" onclick="Restaurant.openAddRestaurant()" class="text-center">餐厅注册</a><br>
        <a href="/login" class="text-center">登录</a>
    </div>
    <!-- /.form-box -->
</div>
<!-- /.register-box -->

<jsp:include page="common/script.jsp"/>
<script src="/static/app/js/admin/restaurant/restaurant.js?v=0.1"></script>

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
     repassword: {
         validators: {
             notEmpty: {
                 message: '不能为空'
             },
             identical: {
                 field: 'newpassword'
             }
         }
     },
     name: {
         validators: {
             notEmpty: {
                 message: '不能为空'
             }
         }
     }
 }

 $('#registerForm').bootstrapValidator({
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

