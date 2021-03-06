<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>教务管理员中心</title>
    <meta name="description" content="这是一个 index 页面">
    <meta name="keywords" content="index">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <link rel="icon" type="image/png" href="${pageContext.request.contextPath}/resource/i/favicon.png">
    <link rel="apple-touch-icon-precomposed" href="${pageContext.request.contextPath}/resource/i/app-icon72x72@2x.png">
    <meta name="apple-mobile-web-app-title" content="Amaze UI" />
    <script src="${pageContext.request.contextPath}/js/jquery-3.3.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/manager-info.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/amazeui.min.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/admin.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/app.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/manager-info.css">
</head>

<body data-type="generalComponents">


    <header class="am-topbar am-topbar-inverse admin-header"> </header>
	<script type="text/javascript">
		$(".admin-header").load("../common/manager-header.html");
	</script>

    <div class="tpl-page-container tpl-page-header-fixed">

        <div class="tpl-left-nav tpl-left-nav-hover">
            <div class="tpl-left-nav-title">毕业综合训练管理系统</div>
            <div class="tpl-left-nav-list">
               <ul class="tpl-left-nav-menu">
					<li class="tpl-left-nav-item"><a href="edumanagercenter"
						class="nav-link"> <i class="am-icon-home"></i> <span>首页</span>
					</a></li>

					<li class="tpl-left-nav-item">
						<a href="javascript:;" class="nav-link tpl-left-nav-link-list">
							<i class="am-icon-table"></i> <span>课题管理</span>
							<i class="am-icon-angle-right tpl-left-nav-more-ico am-fr am-margin-right"></i>
						</a>
						<ul class="tpl-left-nav-sub-menu">
							<li>
								<a class="active" href="topiclist1">
									<i class="am-icon-angle-right"></i><span>待审核</span></a>
								<a href="topiclist2">
									<i class="am-icon-angle-right"></i><span>已通过</span></a>
								<a href="topiclist3">
									<i class="am-icon-angle-right"></i><span>已驳回</span></a>
								<a href="stdetails">
									<i class="am-icon-angle-right"></i><span>选题详情</span></a>
							</li>
						</ul>
					</li>
					<li class="tpl-left-nav-item">
						<a href="javascript:;" class="nav-link tpl-left-nav-link-list">
							<i class="am-icon-user"></i> <span>用户管理</span>
							<i class="am-icon-angle-right tpl-left-nav-more-ico am-fr am-margin-right"></i>
						</a>
						<ul class="tpl-left-nav-sub-menu">
							<li>
								<a href="teacherManage">
									<i class="am-icon-angle-right"></i><span>教师管理</span>
								</a>
								<a href="studentManage">
									<i class="am-icon-angle-right"></i><span>学生管理</span>
								</a>
							</li>
						</ul>
					</li>
					<li class="tpl-left-nav-item">
						<a href="javascript:;" class="nav-link tpl-left-nav-link-list">
							<i class="am-icon-gavel"></i> <span>答辩管理</span>
							<i class="am-icon-angle-right tpl-left-nav-more-ico am-fr am-margin-right"></i>
						</a>
						<ul class="tpl-left-nav-sub-menu">
							<li>
								<a href="application">
									<i class="am-icon-angle-right"></i><span>答辩处理</span>
								</a>
							</li>
							<li>
								<a href="grade">
									<i class="am-icon-angle-right"></i><span>成绩管理</span>
								</a>
							</li>
						</ul>
					</li>
					<li class="tpl-left-nav-item">
						<a href="javascript:;" class="nav-link tpl-left-nav-link-list">
							<i class="am-icon-envelope"></i> <span>通知通告</span>
							<i class="am-icon-angle-right tpl-left-nav-more-ico am-fr am-margin-right"></i>
						</a>
						<ul class="tpl-left-nav-sub-menu">
							<li>
								<a href="toNotice">
									<i class="am-icon-angle-right"></i><span>通告</span>
								</a>
							</li>
						</ul>
					</li>
					<li class="tpl-left-nav-item">
						<a href="javascript:;" class="nav-link tpl-left-nav-link-list">
							<i class="am-icon-folder-open"></i> <span>文件管理</span>
							<i class="am-icon-angle-right tpl-left-nav-more-ico am-fr am-margin-right"></i>
						</a>
						<ul class="tpl-left-nav-sub-menu">
							<li>
								<a href="file-muban">
									<i class="am-icon-angle-right"></i><span>模板文件</span>
								</a>
								<a href="file-student">
									<i class="am-icon-angle-right"></i><span>学生文档</span>
								</a>
							</li>
						</ul>
					</li>
				</ul>
            </div>
        </div>

        <div class="tpl-content-wrapper">
            <div class="tpl-content-page-title">
                个人信息
            </div>
            <ol class="am-breadcrumb">
                <li><a href="edumanagercenter" class="am-icon-home">首页</a></li>
                <li class="am-active">个人信息</li>
            </ol>
            <div class="tpl-portlet-components">
                <div class="portlet-title">
                    <div class="caption font-green bold">
                        <span class="am-icon-code"></span> 列表
                    </div>
                </div>
                <div class="tpl-block">
                    <div class="am-g">
                        <div class="am-u-sm-12 am-u-md-6">

                        </div>
                        <div class="am-u-sm-12 am-u-md-3">

                        </div>
                        <div class="am-u-sm-12 am-u-md-3">
                            <div class="am-input-group am-input-group-sm">
                                
                            </div>
                        </div>
                    </div>
                    <div class="am-g">
                        <div class="am-u-sm-12 am-u-md-6">
							<table class="am-table am-table-radius am-table-bd table-main">
								<thead>
								
								</thead>
								<tbody>
									<tr class="am-g am-success">
										<td class="am-u-sm-12 am-u-md-6">工号</td>
										<td class="am-u-sm-12 am-u-md-6" id="m-id"></td>
									</tr>
									<tr class="am-g am-success">
										<td class="am-u-sm-12 am-u-md-6">姓名</td>
										<td class="am-u-sm-12 am-u-md-6" id="m-username"></td>
									</tr>
									<tr class="am-g am-success">
										<td class="am-u-sm-12 am-u-md-6">性别</td>
										<td class="am-u-sm-12 am-u-md-6" id="m-sex"></td>
									</tr>
									<tr class="am-g am-success">
										<td class="am-u-sm-12 am-u-md-6">院系</td>
										<td class="am-u-sm-12 am-u-md-6" id="m-department"></td>
									</tr>
									<tr class="am-g am-success">
										<td class="am-u-sm-12 am-u-md-6">Tel</td>
										<td class="am-u-sm-12 am-u-md-6" id="m-tel"></td>
									</tr>
									<tr class="am-g am-success">
										<td class="am-u-sm-12 am-u-md-6">E-mail</td>
										<td class="am-u-sm-12 am-u-md-6 am-u-end" id="m-email"></td>
									</tr>
								</tbody>
							</table>
							
                        </div>
                        <div class="am-u-sm-12 am-u-md-6">
                        	<div id="option-btns">
	                        	<button class="am-btn am-btn-sm am-round am-btn-primary" id="btn-modify-password">修改密码</button>
	                        	<button class="am-btn am-btn-sm am-round am-btn-primary" id="btn-modify-infos">修改个人信息</button>
                        	</div>
                        	<div class="form-div">
                        		<form class="">
                        			<div class="am-form-group">
                        				<input type="password" id="old-password" name="old-password" placeholder="原密码" class="form-control" value="">
                        				<p id="p-old"></p>
                        			</div>
                        			<div class="am-form-group">
                        				<input type="password" id="new-password" name="new-password" placeholder="新密码" class="form-control" value="">
                        				<p id="p-new"></p>
                        			</div>
                        			<div class="am-form-group">
                        				<input type="password" id="new-password-check" name="new-password-check" placeholder="确认密码" class="form-control" value="">
                        				<p id="p-new-check"></p>
                        			</div>
                        		</form>
                        		<button class="am-btn am-btn-sm am-round am-btn-success" id="psw-ok">提交</button>
                        		<button class="am-btn am-btn-sm am-round am-btn-danger" id="psw-cancel">取消</button>
                        	</div>
                        </div>

                    </div>
                </div>
                <div class="tpl-alert"></div>
            </div>

        </div>
        
    </div>


    <script src="${pageContext.request.contextPath}/js/amazeui.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/app.js"></script>
    
</body>

</html>