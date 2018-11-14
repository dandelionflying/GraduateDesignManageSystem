<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>教师中心</title>
	<link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
	<script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/teacherjs.js" type="text/javascript"></script>
	<link rel="stylesheet" href="css/centercss.css">
	<link rel="stylesheet" href="css/tcentercss.css">
	<link rel="stylesheet" href="css/font-awesome.css">
	<link rel="stylesheet" href="css/custom.css">
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
					<li><a href="teachercenter"><span class="glyphicon glyphicon-home"></span> 主页</a></li>
					<li><a href="topicmanage"><span class="glyphicon glyphicon-list"></span> 课题管理</a></li>
					<li><a href="teacherinfo"><span class="glyphicon glyphicon-user"></span> 个人信息</a></li>
				</ul>
			</div>
		</div>
	</div>

	<div class="container centerdiv">
		<div class="students">
			<div class="row">
				<div>
					<h3>选择您的课题的学生如下</h3>
				</div>
			</div>
			<div class="row">
				<c:forEach items="${myStudents}" var="student">
					<div class="col-md-4 col-sm-6 col-xs-12">
						<div class="main-box stu-wheat3" onclick='getStudentTopic(${student.sId})' >
							<a href="javascript:void(0)"> <i class="fa fa-github-alt fa-5x"></i>
								<h5>${student.studentName}</h5>
							</a>
						</div>
					</div>
				</c:forEach>
			</div>

		</div>

		<div class="detail">
		
			
				<table class="table table-striped detail-table" id="detail1">
					<thead>
						<tr class="active info">
							<th>学号</th>					
							<th>姓名</th>
							<th>班级</th>
							<th>专业</th>
							<th>课题名称</th>
							<th>进度</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody class="stu-msg-tbody">
						<tr>
							<td id="stu-topic-msg-1"></td>
							<td id="stu-topic-msg-2"></td>
							<td id="stu-topic-msg-3"></td>
							<td id="stu-topic-msg-4"></td>
							<td id="stu-topic-msg-5"></td>
							<td id="stu-topic-msg-6"></td>
							<td>
								<button class="btn btn-xs btn-default show-detail">查看</button>
								
							</td>
						</tr>
					</tbody>
				</table>
			
			
		</div>
	</div>

</body>
</html>