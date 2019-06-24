<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html>
<head>
	<meta charset="UTF-8">
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
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/amazeui.min.css">
	<%-- <link rel="stylesheet" href="${pageContext.request.contextPath}/css/amazeui.switch.css"/> --%>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/admin.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/app.css">
	<script src="${pageContext.request.contextPath}/js/jquery-3.3.1.min.js"></script>
	
	<%-- <script src="${pageContext.request.contextPath}/js/amazeui.switch.min.js"></script> --%>
	<script src="${pageContext.request.contextPath}/js/echarts.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/managercenter-js.js"></script>
</head>
<body data-type="index">
	<header class="am-topbar am-topbar-inverse admin-header">
        
    </header>
	<script type="text/javascript">
		$(".admin-header").load("../common/manager-header.html");
	</script>
	<div class="tpl-page-container tpl-page-header-fixed">


		<div class="tpl-left-nav tpl-left-nav-hover">
			<div class="tpl-left-nav-title">毕业综合实训管理系统</div>
			<div class="tpl-left-nav-list">
				<ul class="tpl-left-nav-menu">
					<li class="tpl-left-nav-item"><a href="edumanagercenter"
						class="nav-link active"> <i class="am-icon-home"></i> <span>首页</span>
					</a></li>

					<li class="tpl-left-nav-item">
						<a href="javascript:;" class="nav-link tpl-left-nav-link-list">
							<i class="am-icon-table"></i> <span>课题管理</span>
							<i class="am-icon-angle-right tpl-left-nav-more-ico am-fr am-margin-right"></i>
						</a>
						<ul class="tpl-left-nav-sub-menu">
							<li>
								<a href="topiclist1">
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
			<div class="tpl-content-page-title">首页</div><br>
			
			<div class="tpl-content-scope gdms-state">
				<div class="note note-info">
					<h3>
						状态 
					</h3>
					
                            <form class="am-form">
                                <table class="am-table">
                                    <thead>
                                        <tr>
                                            <th class="table-title">权限</th>
                                            <th class="table-type">状态</th>
                                            <th class="table-set">操作</th>
                                        </tr>
                                    </thead>
                                    <tbody class="statebody">
                                        
                                    </tbody>
                                </table>
                                <hr>
                            </form>
                      
				</div>
			</div>

			<div class="row">
				<div class="am-u-lg-3 am-u-md-6 am-u-sm-12">
					<div class="dashboard-stat blue">
						<div class="visual">
							<i class="am-icon-comments-o"></i>
						</div>
						<div class="details">
							<div class="number" id="number-st"></div>
							<div class="desc">已选题人数</div>
						</div>
						<a class="more" href="stdetails"> 查看更多 <i
							class="m-icon-swapright m-icon-white"></i>
						</a>
					</div>
				</div>
				<div class="am-u-lg-3 am-u-md-6 am-u-sm-12">
					<div class="dashboard-stat red">
						<div class="visual">
							<i class="am-icon-bar-chart-o"></i>
						</div>
						<div class="details">
							<div class="number" id="number-topic">0</div>
							<div class="desc">待审核课题</div>
						</div>
						<a class="more" href="topiclist"> 查看更多 <i
							class="m-icon-swapright m-icon-white"></i>
						</a>
					</div>
				</div>
				<div class="am-u-lg-3 am-u-md-6 am-u-sm-12">
					<div class="dashboard-stat green">
						<div class="visual">
							<i class="am-icon-apple"></i>
						</div>
						<div class="details">
							<div class="number" id="number-apply"></div>
							<div class="desc">待审阅文档</div>
						</div>
						<a class="more" href="application"> 查看更多 <i
							class="m-icon-swapright m-icon-white"></i>
						</a>
					</div>
				</div>
				<div class="am-u-lg-3 am-u-md-6 am-u-sm-12">
					<div class="dashboard-stat purple">
						<div class="visual">
							<i class="am-icon-android"></i>
						</div>
						<div class="details">
							<div class="number" id="number-pass"></div>
							<div class="desc">已通过课题</div>
						</div>
						<a class="more" href="topiclist2"> 查看更多 <i
							class="m-icon-swapright m-icon-white"></i>
						</a>
					</div>
				</div>



			</div>
		</div>
	</div>

<script src="${pageContext.request.contextPath}/js/amazeui.min.js"></script>
<script src="${pageContext.request.contextPath}/js/iscroll.js"></script>
<script src="${pageContext.request.contextPath}/js/app.js"></script>
</body>
</html>