<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>选题</title>
<link rel="icon" type="image/png" href="../resource/i/favicon.png">
<link href="https://cdn.bootcss.com/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
<script src="${pageContext.request.contextPath}/js/jquery-3.3.1.min.js"></script>
<script src="https://cdn.bootcss.com/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap-fileinput/4.4.8/js/fileinput.min.js"></script>
<script src="${pageContext.request.contextPath}/js/student-stjs.js" type="text/javascript"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/centercss.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/stcss.css">
<script src="${pageContext.request.contextPath}/js/common.js" type="text/javascript"></script>
</head>
<body>
	<div class="headbar navbar navbar-fixed-top navbar-inverse"
		id="headbar1" role="navigation">
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
					<li><a href="logout"><span class="glyphicon glyphicon-log-out"></span> 退出</a></li>
				</ul>
			</div>
		</div>
	</div>

	<div class="container stcenterdiv">
		<div class="searchdiv col-sm-2">

				<div class="form-group">
					<input class="form-control" id="searchWord" placeholder="搜索...">
					<button class="btn btn-sm btn-info search"
						style="margin-top: 5px;">搜索</button>
				</div>
			<div class="labels" id="hot-keys">
				<h4>
					热门搜索
				</h4>
				<div class="hot-keys-list" id="hot-keys-list">
					
				</div>	
			</div>

		</div>
		<div class="sttable col-sm-10">
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

				</tbody>
			</table>
			<nav aria-label="Page navigation">
			  <ul class="pagination" id="topic-pagination">
			   <!--  <li class="disabled">
			      <a href="#" aria-label="Previous">
			        <span aria-hidden="true">&laquo;</span>
			      </a>
			    </li>
			    <li class="active"><a href="#">1</a></li>
			    <li><a href="#">2</a></li>
			    <li><a href="#">3</a></li>
			    <li><a href="#">4</a></li>
			    <li><a href="#">5</a></li>
			    <li>
			      <a href="#" aria-label="Next">
			        <span aria-hidden="true">&raquo;</span>
			      </a>
			    </li> -->
			  </ul>
			</nav>
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