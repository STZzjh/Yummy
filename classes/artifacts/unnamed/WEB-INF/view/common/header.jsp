<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<header class="main-header">
    <!-- Logo -->
    <a href="/" class="logo">
        <!-- logo for regular state and mobile devices -->
        <span class="logo-lg"><b>${seo.mainName}</b></span>
    </a>
    <!-- Header Navbar: style can be found in header.less -->
    <nav class="navbar navbar-static-top">
        <!-- Sidebar toggle button-->
        <a href="#" class="sidebar-toggle" data-toggle="push-menu" role="button">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </a>

        <div class="navbar-custom-menu">
            <ul class="nav navbar-nav">
                <!-- User Account: style can be found in dropdown.less -->
                <li class="dropdown user user-menu">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        <img src="/static/app/images/bbq.png" class="user-image" alt="User Image">
                        <span class="hidden-xs">${loginUser.showname}</span>
                    </a>
                    <ul class="dropdown-menu">
                        <!-- User image -->
                        <li class="user-header">
                            <img src="/static/app/images/bbq.png" class="img-circle" alt="User Image">
                            <p>
                                <small></small>
                            </p>
                        </li>
                        <!-- Menu Footer-->
                        <li class="user-footer">
                            <div class="pull-left">
                                <a href="/admin/profile" class="J_menuItem btn btn-default btn-flat">个人资料</a>
                            </div>
                            <div class="pull-right">
                                <a href="/admin/password" class="J_menuItem btn btn-default btn-flat">修改密码</a>
                            </div>
                        </li>
                    </ul>
                </li>
            </ul>
        </div>
    </nav>
</header>


<aside class="main-sidebar">
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">
        <ul class="sidebar-menu tree" data-widget="tree">
            <li class="header">MAIN NAVIGATION</li>

            <li><a class="J_menuItem" href="/admin/welcome"> <i class="fa fa-dashboard"></i> <span>主面板</span></a></li>
            <li>
                <a class="bbq-title" href="javascript:;">
                    <i class="fa fa-user"></i>
                    <span class="nav-label">设置</span>
                    <span class="fa fa-chevron-left pull-right"></span>
                </a>
                <ul class="treeview-menu">
                    <li><a class="J_menuItem" href="/admin/dict/"> <i class="fa fa-user"></i> <span>系统设置</span></a></li>
                    <li><a class="J_menuItem" href="/admin/rest_type/"> <i class="fa fa-user"></i> <span>餐厅类型</span></a></li>
                    <li><a class="J_menuItem" href="/admin/goods_type/"> <i class="fa fa-user"></i> <span>菜品类型</span></a></li>
                </ul>

            </li>
            <li>
                <a class="bbq-title" href="javascript:;">
                    <i class="fa fa-user"></i>
                    <span class="nav-label">餐厅管理</span>
                    <span class="fa fa-chevron-left pull-right"></span>
                </a>
                <ul class="treeview-menu">
                    <li><a class="J_menuItem" href="/admin/restaurant/"> <i class="fa fa-user"></i> <span>餐厅审批</span></a></li>
                </ul>
            </li>
            <li>
                <a class="bbq-title" href="javascript:;">
                    <i class="fa fa-user"></i>
                    <span class="nav-label">统计信息</span>
                    <span class="fa fa-chevron-left pull-right"></span>
                </a>
                <ul class="treeview-menu">
                    <li><a class="J_menuItem" href="/admin/order_goods_ct/"> <i class="fa fa-user"></i> <span>餐厅统计</span></a></li>
                    <li><a class="J_menuItem" href="/admin/order_goods_hy/"> <i class="fa fa-user"></i> <span>会员统计</span></a></li>
                    <li><a class="J_menuItem" href="/admin/order_goods_pt/"> <i class="fa fa-user"></i> <span>平台统计</span></a></li>
                </ul>
            </li>
        </ul>
    </section>
    <!-- /.sidebar -->
</aside>
