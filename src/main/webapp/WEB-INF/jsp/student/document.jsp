<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>文档</title>
<link rel="icon" type="image/png" href="../resource/i/favicon.png">
<link href="https://cdn.bootcss.com/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
<script src="${pageContext.request.contextPath}/js/jquery-3.3.1.min.js"></script>
<script src="https://cdn.bootcss.com/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
<%-- <script src="${pageContext.request.contextPath}/js/fileinput.min.js"></script> --%>
<script src="https://cdn.bootcss.com/bootstrap-fileinput/4.4.8/js/fileinput.min.js"></script>
<script src="${pageContext.request.contextPath}/js/zh.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/student-docsjs.js" type="text/javascript"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/centercss.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/documentcss.css">
<link href="https://cdn.bootcss.com/bootstrap-fileinput/4.4.8/css/fileinput.min.css" rel="stylesheet">
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

	<div class="container" style="margin-top: 80px;">
		<div class="leftbar col-sm-3" id="leftbar1">
			<ul id="file-classify-menu" class="nav nav-pills nav-stacked">

			</ul>
		</div>
		<div class="col-sm-9">
			<div class="docdivs">
				<!-- 开题报告div -->
				<div class="docdiv" id="docdiv1">
					
					<table class="table">
						<thead>
							<tr class="active">
								<th>文件名</th>
								<th>上传日期</th>
								<th>文件类型</th>
								<th>状态</th>
								<th>操作</th>
							</tr>
						</thead>
						<tbody id="doc-body">
							
						</tbody>
					</table>
					
				</div>
			</div>
			
			
			<div class="uploaddiv">
				<label></label>
				<label class="type-label" id="doc-type" hidden></label>
				
				<button class="btn btn-lg btn-primary open-upload-modal" data-toggle="modal" data-target="#upload-doc">上传文件</button>
			</div>
		</div>
	</div>
	
	<div class="modal fade upload-doc" id="upload-doc" role="dialog" aria-hidden="true" aria-labelledby="upload-doc-label">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button class="close" type="button" data-dismiss="modal" aria-hidden="true">×</button>
					<h4 class="modal-title" id="tupload-doc-label">文件上传</h4>
				</div>
				<div class="modal-body" id="modal-body-content">
					<div class="" id="file_container">
						<form class="" role="form" enctype="multipart/form-data" id="uploadForm">
							<label></label>
							<div class="form-group">
								<input multiple class="file-loading" type="file" name="upload-file"  id="upload-file">
							</div>
						</form>
					</div>
				</div>
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
	<div class="footer"></div>
	<script type="text/javascript">
		$(".footer").load("../common/footer.html");
	</script>
</body>
</html>