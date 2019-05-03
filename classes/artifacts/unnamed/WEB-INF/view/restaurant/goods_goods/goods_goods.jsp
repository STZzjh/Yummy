<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>套餐详情管理 - ${seo.mainName}</title>
    <jsp:include page="../../common/link.jsp"/>
</head>
<body class="hold-transition skin-blue sidebar-mini">
<section class="content">
    <div class="row">
        <div class="col-xs-12">
            <div class="box">
                <div class="box-header">
                    <h3 class="box-title">套餐详情管理</h3>
                </div>
                <!-- /.box-header -->
                <div class="box-body">
                    <div id="GoodsGoodsTableToolbar">
                        <button class="btn btn-primary" type="button" onclick="GoodsGoods.openAddGoodsGoods()">新增</button>
                        <button class="btn btn-primary"  type="button" onclick="GoodsGoods.openGoodsGoodsDetail()">修改</button>
                        <button class="btn btn-primary"  type="button" onclick="GoodsGoods.delete()">删除</button>
                    </div>
                    <table id="GoodsGoodsTable"></table>
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
<script src="/static/app/js/restaurant/goods_goods/goods_goods.js?v=0.1"></script>
</body>
</html>