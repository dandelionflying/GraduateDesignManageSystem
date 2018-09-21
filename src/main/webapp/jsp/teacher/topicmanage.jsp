<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>课题管理</title>
	<link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
	<script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/topic-manage.js" type="text/javascript"></script>
	<link rel="stylesheet" href="css/centercss.css">
	<link rel="stylesheet" href="css/topicmanagecss.css">
	<link rel="stylesheet" href="css/fileinput.min.css">
	<script src="js/fileinput.min.js" type="text/javascript"></script>
	
	<script>
		

		
	</script>
</head>
<body>
	<div class="headbar navbar navbar-fixed-top navbar-inverse" id="headbar1" role="navigation">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
					<span class="sr-only"></span>
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

	<div class="container" style="margin-top: 80px;">
		<div class="leftbar col-sm-3" id="leftbar1">
			<ul class="nav nav-pills nav-stacked">
				<li class="leftli" id="leftli1"><a href="javascript:void(0)">全部课题</a></li>
				<li class="leftli" id="leftli2"><a href="javascript:void(0)">我的课题</a></li>
				<li class="leftli" id="leftli3" data-toggle="modal" data-target="#apply-modal"><a href="javascript:void(0)">添加课题</a></li>

			</ul>
		</div>
		<div class="col-sm-9">
			<div class="topic" id="all-topics">	
				<table class="table table-striped">
					<thead>
						<tr class="active">
							<th>课题编号</th>
							<th>课题名称</th>
							<th>出题老师</th>
							<th>课题类型</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${topics}" var="topic">
							<tr>
								<td>${topic.topicId}</td>
								<td>${topic.topicName}</td>
								<td>${topic.teacherName}</td>
								<td>${topic.topicType}</td>
								<td><button onclick="contents(${topic.topicId})" class="btn btn-xs btn-primary content-btn" data-toggle="modal" data-target="#topic-details">详情</button></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<div class="topic" id="my-topics">	
				<table class="table table-striped active my-topics">
					<thead>
						<tr class="active">
							<th>课题编号</th>
							<th>课题名称</th>
							<th>课题类型</th>
							<th>课题状态</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${myTopics}" var="mytopic">
							<tr>
								<td>${mytopic.topicId}</td>
								<td>${mytopic.topicName}</td>
								<td>${mytopic.topicType}</td>
								<td>${mytopic.state}</td>
								<td>
									<button class="btn btn-xs btn-success">编辑</button>
									<button class="btn btn-xs btn-danger">删除</button>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	
	<!-- 添加课题modal -->
	<div class="apply-topic modal fade" id="apply-modal" role="dialog" aria-labelledby="#modal-title-label" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				
				<form role="form" action="addNewTopic">
					<div class="modal-header">
						<button class="close" type="button" data-dismiss="modal" aria-hidden="true">&times;</button>
						<h4 class="modal-title" id="modal-title-label">添加课题</h4>
					</div>
					<div class="modal-body">
						<div class="form-group">
							<label>课题名称</label>
							<input class="form-control" id="new_topic_name" name="topicName">
							<label>课题简介</label>
							<textarea class="form-control" id="new_content" name="content" rows="5" cols="" style="width:100%"></textarea>
							<br>
							<label>指导老师</label>
							<label class="tname form-control" id="teacherName">陈露露</label><!-- 当前session获取 -->
							<br>
							<label>课题类型：</label>
							<label class="type-label" id="topic_type"></label>
							<div class="btn-group">
								<button type="button" class="btn btn-success btn-xs">选择</button>
								<button type="button" class="btn btn-success btn-xs dropdown-toggle"
									id="dropdownMenu1" data-toggle="dropdown">
									<span class="caret"></span> <span class="sr-only"></span>
								</button>
								<ul class="dropdown-menu" role="menu"
									aria-labelledby="dropdownMenu1">
									<li role="presentation" class="dropdown-header">类型选择</li>
									<li role="presentation" id="type1"><a id="type-a1" role="menuitem" tabindex="-1" href="javascript:void(0)">工程设计</a></li>
									<li role="presentation" id="type2"><a id="type-a2" role="menuitem" tabindex="-1" href="javascript:void(0)">综合试验</a></li>
									<li role="presentation" id="type3"><a id="type-a3" role="menuitem" tabindex="-1" href="javascript:void(0)">专题研究</a></li>
									<li role="presentation" id="type4"><a id="type-a4" role="menuitem" tabindex="-1" href="javascript:void(0)">专题论文</a></li>
								</ul>
							</div>
							<br>
							<label>对学生要求</label>
							<textarea class="form-control" id="new_demand" name="demand" rows="5" cols="" style="width:100%"></textarea>
						</div>

					</div>
					<div class="modal-footer">

						<button type="button" id="send-btn" class="btn btn-info apply" onclick="sendForm()">提交课题</button>

					</div>
				</form>	
			</div>
		</div>
	</div>
	
	
	<!-- 课题详情modal -->
	<div class="modal fade topic-details" id="topic-details" role="dialog" aria-hidden="true" aria-labelledby="topic-details-label">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button class="close" type="button" data-dismiss="modal" aria-hidden="true">×</button>
					<h4 class="modal-title" id="topic-details-label">课题详情</h4>
				</div>
				<div class="modal-body" id="modal-body-content"></div>
				<div class="modal-footer">
					<button class="btn btn-primary" type="button" data-dismiss="modal">关闭</button>
				</div>
			</div>
		</div>
	</div>
</body>
</html>