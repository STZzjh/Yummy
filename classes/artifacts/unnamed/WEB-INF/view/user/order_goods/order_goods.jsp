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
                    <h3 class="box-title">订单表管理</h3>
                </div>
                <!-- /.box-header -->
                <div class="box-body">
                    <div id="OrderGoodsTableToolbar">
                        <button class="btn btn-primary" type="button" onclick="OrderGoods.pay()">支付</button>
                        <button class="btn btn-primary" type="button" onclick="OrderGoods.shouhuo()">确认收货</button>
                        <button class="btn btn-primary"  type="button" onclick="OrderGoods.tuiding()">退订</button>
                        <button class="btn btn-primary"  type="button" onclick="OrderGoods.quxiao()">取消</button>
                        <button class="btn btn-primary"  type="button" onclick="OrderGoods.openOrderGoodsDetail()">订单详情</button>
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
<script src="/static/app/js/user/order_goods/order_goods.js?v=0.51"></script>
</body>
</html>