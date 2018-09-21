<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>选题</title>
<link
	href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet">
<script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/student-stjs.js" type="text/javascript"></script>
<link rel="stylesheet" href="css/centercss.css">
<link rel="stylesheet" href="css/stcss.css">
<script>
	
</script>
</head>
<body>
	<div class="headbar navbar navbar-fixed-top navbar-inverse"
		id="headbar1" role="navigation">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-collapse">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
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
					<li><a href="studentcenter"><span
							class="glyphicon glyphicon-home"></span> 主页</a></li>
					<li><a href="st"><span class="glyphicon glyphicon-list"></span>
							选题</a></li>
					<li><a href="document"><span
							class="glyphicon glyphicon-folder-open"></span> 文档</a></li>
					<li><a href="schedule"><span
							class="glyphicon glyphicon-align-left"></span> 进度</a></li>
					<li><a href="stu-info"><span
							class="glyphicon glyphicon-user"></span> 个人信息</a></li>
				</ul>
			</div>
		</div>
	</div>

	<div class="container stcenterdiv">
		<div class="searchdiv col-sm-3">

				<div class="form-group">
					<input class="form-control" id="searchWord" placeholder="搜索...">
					<button class="btn btn-sm btn-info search"
						style="margin-top: 5px;">搜索</button>
				</div>
			<div class="labels">
				<h4>
					热门搜索
					</h4>
			</div>

		</div>
		<div class="sttable col-sm-9">
			<table class="table">
				<thead>
					<tr class="active">
						<th>序号</th>
						<th>课题名称</th>
						<th>课题类型</th>
						<th>对学生要求</th>
						<th>指导老师</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody id="all-topics">

					<!-- <tr class="success">
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td>
							<button class="btn btn-info btn-xs">可选</button>
							<button class="btn btn-info btn-xs">详情</button>
						</td>
					</tr>

					<tr class="success">
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td><button class="btn btn-info btn-xs" disabled="disabled">不可选</button></td>
					</tr> -->

				</tbody>
			</table>
		</div>
	</div>
</body>
</html>