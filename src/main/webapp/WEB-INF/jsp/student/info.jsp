<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>个人信息</title>
	<link rel="icon" type="image/png" href="${pageContext.request.contextPath}/resource/i/favicon.png">
	<link href="https://cdn.bootcss.com/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
	<script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>
	<!-- <script src="${pageContext.request.contextPath}/js/jquery-3.3.1.min.js"></script> -->
	<script src="https://cdn.bootcss.com/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/student-info.css">
	<script src="${pageContext.request.contextPath}/js/student-info.js"></script>
	
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
		<div class="jumbotron" style="background-color: #ddd">
			<div class="panel panel-info">
				<div class="panel-heading">个人信息</div>
				<table class="table">
					<tbody>
						<tr class="row">
							<td class="col-sm-2 active">姓名</td>
							<td class="col-sm-4" id="s-name"></td>
							<td class="col-sm-2 active">学号</td>
							<td class="col-sm-4" id="s-id"></td>
						</tr>
						<tr class="row">
							<td class="active">性别</td>
							<td id="s-sex"></td>
							<td class="active">所属院系</td>
							<td id="s-dept"></td>
						</tr>
						<tr class="row">
							<td class="active">班级</td>
							<td id="s-class"></td>
							<td class="active">所属专业</td>
							<td id="s-mayor"></td>
						</tr>
						<tr class="row">
							<td class="active">TEL</td>
							<td id="s-tel"></td>
							<td class="active">入学年份</td>
							<td id="s-year"></td>
						</tr>
						<tr class="row">
							<td class="active">e-mail</td>
							<td id="s-email"></td>
						</tr>
					</tbody>
				</table>
			</div>
			
			<div id="option-btns">
				<button class="btn btn-default" id="btn-modify-password" data-toggle="modal" data-target="#modify-psw-modal">修改密码</button>
				<button class="btn btn-default" id="btn-modify-infos">修改个人信息</button>
			</div>	
		</div>
	</div>
	<!-- 修改密码modal -->
	<div class="modal fade topic-details" id="modify-psw-modal" role="dialog" aria-hidden="true" aria-labelledby="topic-details-label">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button class="close" type="button" data-dismiss="modal" aria-hidden="true">×</button>
					<h4 class="modal-title" id="topic-details-label">修改密码</h4>
				</div>
				<div class="modal-body" id="modal-body-content">
					<div style="margin-left:35px;margin-right:35px">
						<form role="form">
							<div class="form-group">
								<input type="password" id="old-password" name="old-password" class="form-control" placeholder="原密码">
								<p class="p-password" id="p-old"></p>
							</div>
							<div class="form-group">
								<input class="form-control" id="new-password" name="new-password" type="password" placeholder="新密码">
								<p class="p-password" id="p-new"></p>
							</div>
							
							<div class="form-group">
								<input class="form-control" id="new-password-check" name="new-password-check" type="password" placeholder="新密码" >
								<p class="p-password" id="p-new-check"></p>
							</div>
						</form>
					</div>
				</div>
				<div class="modal-footer">
					<button class="btn btn-primary" id="psw-ok">提交</button>
					<button class="btn btn-primary" type="button" data-dismiss="modal">关闭</button>
				</div>
			</div>
		</div>
	</div>
	<div class="laoding"></div>
	<script type="text/javascript">
		$(".laoding").load("../common/loading-modal.html");
	</script>
	<div class="footer" style="margin-top:100px"></div>
	<script type="text/javascript">
		$(".footer").load("../common/footer.html");
	</script>
</body>
</html>