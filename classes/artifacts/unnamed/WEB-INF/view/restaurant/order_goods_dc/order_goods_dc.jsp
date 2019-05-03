<%@ taglib tagdir="/WEB-INF/tags" prefix="form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>订单表管理 - ${seo.mainName}</title>
    <jsp:include page="../../common/link.jsp"/>
</head>
<body class="hold-transition skin-blue sidebar-mini">
<section class="content">
    <div class="row">
        <div class="col-xs-12">
            <div class="box">
                <div class="box-header">
                    <h3 class="box-title">订餐统计</h3>
                </div>
                <!-- /.box-header -->
                <div class="box-body">
                    <div id="OrderGoodsTableToolbar">
                        <form class="form-inline">
                            <form:laydate_double id="time" name="时间" />
                            <form:input_double id="money" name="金额" />
                            <form:input_inline id="userName" name="用户"  />
                            <button class="btn btn-primary"  type="button" onclick="OrderGoods.search()">查找</button>
                        </form>
                     </div>
                    <table id="OrderGoodsTable"></table>
                </div>
                <!-- /.box-body -->
            </div>
            <!-- /.box -->

        </div>
        <!-- /.col -->
    </div>
    <!-- /.row -->
</section>
<!-- Site wrapper -->
<jsp:include page="../../common/script.jsp"/>
<script src="/static/app/js/restaurant/order_goods_dc/order_goods_dc.js?v=0.1"></script>
</body>
</html>