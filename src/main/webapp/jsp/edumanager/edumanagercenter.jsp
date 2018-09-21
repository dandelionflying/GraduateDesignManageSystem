<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<meta charset="UTF-8">
	<title>教务管理员中心</title>
	<link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
	<script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="../../css/centercss.css">
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
					
					<li role="presentation" id="type1"><a id="type-a1" role="menuitem" tabindex="-1" href="javascript:void(0)">
					<span class="glyphicon glyphicon-log-out"></span> 注销用户</a></li>
				</ul>
				
			</div>
			<div class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<li><a href="edumanagercenter.jsp"><span class="glyphicon glyphicon-home"></span> 主页</a></li>
					<li><a href="stumanage.jsp"><span class="glyphicon glyphicon-user"></span> 学生管理</a></li>
					<li><a href="teachermanage.jsp"><span class="glyphicon glyphicon-user"></span> 教师管理</a></li>
					<li><a href="stdetails.jsp"><span class="glyphicon glyphicon-th-list"></span> 选题详情</a></li>
					<li><a href="answers.jsp"><span class="glyphicon glyphicon-th-list"></span> 答辩详情</a></li>
					<li><a href=""><span class="glyphicon glyphicon-user"></span> 个人信息</a></li>
				</ul>
			</div>
		</div>
	</div>
	

</body>
</html>