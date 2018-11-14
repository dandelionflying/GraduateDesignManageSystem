<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>教师管理</title>
	<link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
	<script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/centercss.css">
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
					<li><a href="edumanagercenter"><span class="glyphicon glyphicon-home"></span> 主页</a></li>
					<li><a href="stumanage"><span class="glyphicon glyphicon-user"></span> 学生管理</a></li>
					<li><a href="teachermanage"><span class="glyphicon glyphicon-user"></span> 教师管理</a></li>
					<li><a href="stdetails.jsp"><span class="glyphicon glyphicon-th-list"></span> 选题详情</a></li>
					<li><a href="answers.jsp"><span class="glyphicon glyphicon-th-list"></span> 答辩详情</a></li>
					<li><a href=""><span class="glyphicon glyphicon-user"></span> 个人信息</a></li>
				</ul>
			</div>
		</div>
	</div>
	
	<div class="container" style="margin-top:80px;">
		<table class="table">
			<thead>
				<tr class="active">
					<th class="col-md-1">工号</th>
					<th class="col-md-1">姓名</th>
					<th class="col-md-1">性别</th>
					<th class="col-md-1">角色</th>
					<th class="col-md-1">联系方式</th>
					<th class="col-md-1">操作</th>
				</tr>
			</thead>
			<tbody>
				<tr class="success">
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td>
						<button class="btn btn-info btn-xs">修改</button>
						<button class="btn btn-danger btn-xs">删除</button>
					</td>
				</tr>
			</tbody>
		</table>
		
		
	</div>
</body>
</html>