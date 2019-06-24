<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>学生中心</title>
	<link rel="icon" type="image/png" href="${pageContext.request.contextPath}/resource/i/favicon.png">
	<link href="https://cdn.bootcss.com/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
	<script src="${pageContext.request.contextPath}/js/jquery-3.3.1.min.js"></script>
	<script src="https://cdn.bootcss.com/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<!-- <script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script> -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/centercss.css">
	<script src="${pageContext.request.contextPath}/js/student-center.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/common.js" type="text/javascript"></script>
</head>
<body>
	<div class="headbar navbar navbar-fixed-top navbar-inverse" id="headbar1" role="navigation">
		<div class="container">
			<div class="navbar-header">
				
				<a class="navbar-brand dropdown-toggle" href="javascript:void(0)">毕业综合实训管理系统</a>
				
			</div>
			<div class="collapse navbar-collapse">
				<ul class="nav navbar-nav" id="nave-left">
					<li><a href="studentcenter"><span class="glyphicon glyphicon-home"></span> 主页</a></li>
					<li><a href="mytopic"><span class="glyphicon glyphicon-leaf"></span> 我的课题</a></li>
					<li><a href="st"><span class="glyphicon glyphicon-list"></span> 选题</a></li>
					<li><a href="document"><span class="glyphicon glyphicon-folder-open"></span> 文档</a></li>
					<li><a href="mubanfiles"><span class="glyphicon glyphicon-book"></span> 模板文件</a></li>
					<li><a href="notices"><span class="glyphicon glyphicon-envelope"></span> 通知公告</a></li>
					<li><a href="stu-info"><span class="glyphicon glyphicon-user"></span> 个人信息</a></li>
				</ul>
				<ul class="nav navbar-nav" id="nav-right" style="float:right">
					<!-- <li><a href=" "><span class="glyphicon glyphicon-bell"></span> 提醒
					<span class="badge" style="background-color: red">4</span></a></li> -->
					<li><a href="logout"><span class="glyphicon glyphicon-log-out"></span> 退出</a></li>
				</ul>
			</div>
			
		</div>
	</div>
	
	<div class="container" style="margin-top: 80px">
		<div class="jumbotron" style="background-color:#ddd">
		  <h1>Welcome To GDMS!</h1>
		  <p>请按照说明完成毕业综合实训任务</p>
		  <p>
		  	<a class="btn btn-primary btn-lg" href="mytopic" role="button">我的课题</a>
		  	<a class="btn btn-info btn-lg" href="" role="button" data-toggle="modal" data-target="#new-notice"><span class="glyphicon glyphicon-bell"></span> 新通知
					<span class="badge" id="count-of-new" style="background-color: red;color:#fff"></span></a>
		  </p>
		</div>
		
	</div>
	
	<!-- 新通知modal -->
	<div class="modal fade new-notices" id="new-notice" role="dialog" aria-hidden="true" aria-labelledby="notive-label">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button class="close" type="button" data-dismiss="modal" aria-hidden="true">×</button>
					<h4 class="modal-title" id="notice-label">通知详情</h4>
				</div>
				<div class="modal-body" id="notice-content">
					<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">通知</h3>
					</div>
					<!-- <div class="panel-body"></div> -->
					<ul class="list-group" id="new-notice-group">
						<!-- <li class="list-group-item" ><a class="notice-li-a" role="button" onclick="show(1)">开始发布课题</a></li>
						<div class="alert alert-info alert-dismissible" role="alert" id="alert-1" hidden>
							<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
  							<strong>详情</strong> 开始发布课题
						</div> -->
						<!-- <li class="list-group-item">Dapibus ac facilisis in</li>
						<li class="list-group-item">Morbi leo risus</li>
						<li class="list-group-item">Porta ac consectetur ac</li>
						<li class="list-group-item">Vestibulum at eros</li> -->
					</ul>
					
				</div>
				
				</div>
				<div class="modal-footer">
					<a class="btn btn-info" href="notices" style="float:center" role="button">更多</a>
					<button class="btn btn-primary" type="button" data-dismiss="modal">关闭</button>
				</div>
			</div>
		</div>
	</div>
	<div class="laoding"></div>
	<script type="text/javascript">
		$(".laoding").load("../common/loading-modal.html");
	</script>
	<%-- <div><iframe MARGINWIDTH=0 MARGINHEIGHT=0 HSPACE=0 VSPACE=0 FRAMEBORDER=0 SCROLLING=no src="${pageContext.request.contextPath}/common/footer.html" height="auto" width="100%"></iframe></div> --%>
	<div class="footer" style="margin-top:120px"></div>
	<script type="text/javascript">
		$(".footer").load("../common/footer.html");
	</script>
</body>
</html>