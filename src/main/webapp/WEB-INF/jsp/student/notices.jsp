<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>通知公告</title>
	<link rel="icon" type="image/png" href="${pageContext.request.contextPath}/resource/i/favicon.png">
	<link href="https://cdn.bootcss.com/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
	<script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>
	<!-- <script src="${pageContext.request.contextPath}/js/jquery-3.3.1.min.js"></script> -->
	<script src="https://cdn.bootcss.com/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/centercss.css">
	<script src="${pageContext.request.contextPath}/js/student-notice.js"></script>
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
		<div class="panel panel-default">
			<div class="panel-heading">
				<h3 class="panel-title">通知</h3>
			</div>
			<ul class="list-group" id="notice-group">
				
			</ul>
		</div>
		<nav aria-label="Page navigation">
		  <ul class="pagination" id="notice-pagination">
		    
		  </ul>
		</nav>
	</div>
	<div class="laoding"></div>
	<script type="text/javascript">
		$(".laoding").load("../common/loading-modal.html");
	</script>
	<div class="footer" style=""></div>
	<script type="text/javascript">
		$(".footer").load("../common/footer.html");
	</script>
</body>
</html>