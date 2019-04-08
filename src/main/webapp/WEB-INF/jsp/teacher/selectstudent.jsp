<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>学生选择</title>
	<link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
	<script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="../../css/centercss.css">
	<link rel="stylesheet" href="../../css/selectstudentcss.css">
	<script>
		
	</script>
</head>
<body>
	<div class="headbar navbar navbar-fixed-top navbar-inverse" id="headbar1" role="navigation">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
					<span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<a class="navbar-brand dropdown-toggle" id="dropdownMenu1" data-toggle="dropdown" href="javascript:void(0)">毕业设计管理系统</a>
				
				<ul class="dropdown-menu" role="menu"
						aria-labelledby="dropdownMenu1">
					
					<li role="presentation" id="type1"><a id="type-a1" role="menuitem" tabindex="-1" href="loginout">
					<span class="glyphicon glyphicon-log-out"></span> 注销用户</a></li>
				</ul>
			</div>
			<div class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<li><a href="teachercenter.jsp"><span class="glyphicon glyphicon-home"></span> 主页</a></li>
					<li><a href="topicmanage.jsp"><span class="glyphicon glyphicon-list"></span> 课题管理</a></li>
					<li><a href="tdocument.jsp"><span class="glyphicon glyphicon-folder-open"></span> 学生文档</a></li>
					<li><a href="studentschedule.jsp"><span class="glyphicon glyphicon-align-left"></span> 学生任务进度</a></li>
					<li><a href="tinfo.jsp"><span class="glyphicon glyphicon-user"></span> 个人信息</a></li>
				</ul>
			</div>
		</div>
	</div>

	<div class="container students">
		<div class="row">
			<div class="col-md-4">
				<div class="main-box mb-red">
					<a href="#"> <i class="fa fa-bolt fa-5x"></i>
						<h5>Zero Issues</h5>
					</a>
				</div>
			</div>
			<div class="col-md-4">
				<div class="main-box mb-dull">
					<a href="#"> <i class="fa fa-plug fa-5x"></i>
						<h5>40 Task In Check</h5>
					</a>
				</div>
			</div>
			<div class="col-md-4">
				<div class="main-box mb-pink">
					<a href="#"> <i class="fa fa-dollar fa-5x"></i>
						<h5>200K Pending</h5>
					</a>
				</div>
			</div>

		</div>
	</div>

</body>
</html>