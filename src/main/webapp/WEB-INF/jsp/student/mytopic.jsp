<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>学生中心</title>
	<link rel="icon" type="image/png" href="${pageContext.request.contextPath}/resource/i/favicon.png">
	<link href="https://cdn.bootcss.com/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
	<!-- <script src="${pageContext.request.contextPath}/js/jquery-3.3.1.min.js"></script> -->
	<script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://cdn.bootcss.com/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/centercss.css">
	<script src="${pageContext.request.contextPath}/js/student-mytopic.js"></script>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/student-mytopic.css">
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

		<div class="jumbotron mytopic" style="background-color: #fff">
			<div class="row">
				<div class="col-sm-6">
					<div class="row">
						<div class="col-sm-3"><p>课题名称</p></div>
						<div class="col-sm-9"><p id="topic-name"></p></div>
					</div>
					<div class="row">
						<div class="col-sm-3"><p>课题编号</p></div>
						<div class="col-sm-9"><p id="topic-id"></p></div>
					</div>
					<div class="row">
						<div class="col-sm-3"><p>指导教师</p></div>
						<div class="col-sm-9"><p id="teacher"></p></div>
					</div>
					
					<div class="row">
						<div class="col-sm-3"><p>详情</p></div>
						<div class="col-sm-9"><p id="topic-content"></p></div>
					</div>
					<div class="row">
						<div class="col-sm-3"><p id="topic-proccess">进度</p></div>
						<div class="col-sm-9">
							<div>
								<table class="table" style="width:100%;text-align:center">
									<tbody id="state-classify">
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
				
				<div class="col-sm-6" id="grades" style="text-align:center">
					<p>成绩</p>
					<table class="table">
						<thead>
							<tr class="active">
								<th>文献翻译成绩</th>
								<th>指导老师成绩</th>
								<th>评阅老师成绩</th>
								<th>答辩成绩</th>
								<th>总成绩</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>0</td>
								<td>0</td>
								<td>0</td>
								<td>0</td>
								<td>0</td>
							</tr>
						</tbody>
						
					</table>
				</div>
				
			</div>
		</div>
	</div>
	<div class="laoding"></div>
	<script type="text/javascript">
		$(".laoding").load("../common/loading-modal.html");
	</script>
	<div class="footer"></div>
	<script type="text/javascript">
		$(".footer").load("../common/footer.html");
	</script>
</body>
</html>