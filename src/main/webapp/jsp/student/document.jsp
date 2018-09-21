<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>文档</title>
<link
	href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet">
<script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap-fileinput/4.4.8/js/fileinput.min.js"></script>
<script src="js/zh.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/student-docsjs.js" type="text/javascript"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/centercss.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/documentcss.css">
<link href="https://cdn.bootcss.com/bootstrap-fileinput/4.4.8/css/fileinput.min.css" rel="stylesheet">

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
					<li><a href="studentcenter"><span class="glyphicon glyphicon-home"></span> 主页</a></li>
					<li><a href="st"><span class="glyphicon glyphicon-list"></span> 选题</a></li>
					<li><a href="document"><span class="glyphicon glyphicon-folder-open"></span> 文档</a></li>
					<li><a href="schedule"><span class="glyphicon glyphicon-align-left"></span> 进度</a></li>
					<li><a href="stu-info"><span class="glyphicon glyphicon-user"></span> 个人信息</a></li>
				</ul>
			</div>
		</div>
	</div>

	<div class="container" style="margin-top: 80px;">
		<div class="leftbar col-sm-3" id="leftbar1">
			<ul class="nav nav-pills nav-stacked">
				<li class="leftli" id="leftli1"><a href="javascript:void(0)">开题报告</a></li>
				<li class="leftli" id="leftli2"><a href="javascript:void(0)">项目计划书</a></li>
				<li class="leftli" id="leftli3"><a href="javascript:void(0)">周志</a></li>
				<li class="leftli" id="leftli4"><a href="javascript:void(0)">中期检查报告</a></li>
				<li class="leftli" id="leftli5"><a href="javascript:void(0)">毕业设计报告</a></li>
				<li class="leftli" id="leftli6"><a href="javascript:void(0)">毕业论文</a></li>

			</ul>
		</div>
		<div class="col-sm-9">
			<!-- 开题报告div -->
			<div class="docdiv" id="docdiv1">
				<table class="table">
					<thead>
						<tr class="active">
							<th>文件名</th>
							<th>上传日期</th>
							<th>文件类型</th>
							<th>操作</th>
						</tr>
					</thead>
					<c:if test="${docs['开题报告']!=null}">
					<tbody>
						<tr class="success">
							<td><c:out value="${docs['开题报告']['docName']}"/></td>
							<td><c:out value="${docs['开题报告']['createDate']}"/></td>
							<td><c:out value="${docs['开题报告']['docType']}"/></td>
							<td>
								<button class="btn btn-xs btn-success">查看</button>
								<button class="btn btn-xs btn-success">删除</button>
								<button class="btn btn-xs btn-success">查看教师指导</button>
							</td>
						</tr>
					</tbody>
					</c:if>
				</table>
			</div>
			<!-- 项目计划书div -->
			<div class="docdiv" id="docdiv2">
				<table class="table">
					<thead>
						<tr class="active">
							<th>文件名</th>
							<th>上传日期</th>
							<th>文件类型</th>
							<th>操作</th>
						</tr>
					</thead>
					<c:if test="${docs['项目计划书']!=null}">
					<tbody>
						<tr class="success">
							<td><c:out value="${docs['项目计划书']['docName']}"/></td>
							<td><c:out value="${docs['项目计划书']['createDate']}"/></td>
							<td><c:out value="${docs['项目计划书']['docType']}"/></td>
							<td>
								<button class="btn btn-xs btn-success">查看</button>
								<button class="btn btn-xs btn-success">删除</button>
								<button class="btn btn-xs btn-success">查看教师指导</button>
							</td>
						</tr>
					</tbody>
					</c:if>
				</table>
			</div>
			<!-- 周志div -->
			<div class="docdiv" id="docdiv3">
				<table class="table">
					<thead>
						<tr class="active">
							<th>文件名</th>
							<th>上传日期</th>
							<th>文件类型</th>
							<th>操作</th>
						</tr>
					</thead>
					<c:if test="${docs['周志']!=null}">
					<tbody>
						<tr class="success">
							<td><c:out value="${docs['周志']['docName']}"/></td>
							<td><c:out value="${docs['周志']['createDate']}"/></td>
							<td><c:out value="${docs['周志']['docType']}"/></td>
							<td>
								<button class="btn btn-xs btn-success">查看</button>
								<button class="btn btn-xs btn-success">删除</button>
								<button class="btn btn-xs btn-success">查看教师指导</button>
							</td>
						</tr>
					</tbody>
					</c:if>
				</table>
			</div>

			<!-- 中期检查报告div -->
			<div class="docdiv" id="docdiv4">
				<table class="table">
					<thead>
						<tr class="active">
							<th>文件名</th>
							<th>上传日期</th>
							<th>文件类型</th>
							<th>操作</th>
						</tr>
					</thead>
					<c:if test="${docs['中期检查表']!=null}">
					<tbody>
						<tr class="success">
							<td><c:out value="${docs['中期检查表']['docName']}"/></td>
							<td><c:out value="${docs['中期检查表']['createDate']}"/></td>
							<td><c:out value="${docs['中期检查表']['docType']}"/></td>
							<td>
								<button class="btn btn-xs btn-success">查看</button>
								<button class="btn btn-xs btn-success">删除</button>
								<button class="btn btn-xs btn-success">查看教师指导</button>
							</td>
						</tr>
					</tbody>
					</c:if>
				</table>
			</div>
			<!-- 毕业设计报告div -->
			<div class="docdiv" id="docdiv5">
				<table class="table">
					<thead>
						<tr class="active">
							<th>文件名</th>
							<th>上传日期</th>
							<th>文件类型</th>
							<th>操作</th>
						</tr>
					</thead>
					<c:if test="${docs['毕业设计报告']!=null}">
					<tbody>
						<tr class="success">
							<td><c:out value="${docs['毕业设计报告']['docName']}"/></td>
							<td><c:out value="${docs['毕业设计报告']['createDate']}"/></td>
							<td><c:out value="${docs['毕业设计报告']['docType']}"/></td>
							<td>
								<button class="btn btn-xs btn-success">查看</button>
								<button class="btn btn-xs btn-success">删除</button>
								<button class="btn btn-xs btn-success">查看教师指导</button>
							</td>
						</tr>
					</tbody>
					</c:if>
				</table>
			</div>
			<!-- 毕业论文div -->
			
			<div class="docdiv" id="docdiv6">
				<table class="table">
					<thead>
						<tr class="active">
							<th>文件名</th>
							<th>上传日期</th>
							<th>文件类型</th>
							<th>操作</th>
						</tr>
					</thead>
					<c:if test="${docs['毕业论文']!=null}">
					<tbody>
						<tr class="success">
							<td><c:out value="${docs['毕业论文']['docName']}"/></td>
							<td><c:out value="${docs['毕业论文']['createDate']}"/></td>
							<td><c:out value="${docs['毕业论文']['docType']}"/></td>
							<td>
								<button class="btn btn-xs btn-success">查看</button>
								<button class="btn btn-xs btn-success">删除</button>
								<button class="btn btn-xs btn-success">查看教师指导</button>
							</td>
						</tr>
					</tbody>
					</c:if>
				</table>
			</div>
			<div>
				<c:forEach items="${docs}" var="doc">
					<div>${doc}</div>
				</c:forEach>
			</div>
			<div class="uploaddiv">
				<label></label>
				<label class="type-label" id="doc-type"></label>
				<div class="btn-group">
					<button type="button" class="btn btn-success btn-xs">选择</button>
					<button type="button" class="btn btn-success btn-xs dropdown-toggle"
						id="dropdownMenu1" data-toggle="dropdown">
						<span class="caret"></span> <span class="sr-only"></span>
					</button>
					<ul class="dropdown-menu" role="menu"
						aria-labelledby="dropdownMenu1">
						<li role="presentation" class="dropdown-header">类型选择</li>
						<li role="presentation" id="type0"><a id="type-a0" role="menuitem" tabindex="-1" href="javascript:void(0)">开题报告</a></li>
						<li role="presentation" id="type2"><a id="type-a2" role="menuitem" tabindex="-1" href="javascript:void(0)">项目计划书</a></li>
						<li role="presentation" id="type3"><a id="type-a3" role="menuitem" tabindex="-1" href="javascript:void(0)">周志</a></li>
						<li role="presentation" id="type4"><a id="type-a4" role="menuitem" tabindex="-1" href="javascript:void(0)">中期检查表</a></li>
						<li role="presentation" id="type5"><a id="type-a5" role="menuitem" tabindex="-1" href="javascript:void(0)">毕业设计报告</a></li>
						<li role="presentation" id="type6"><a id="type-a6" role="menuitem" tabindex="-1" href="javascript:void(0)">毕业论文</a></li>
					</ul>
				</div><br><br>
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

</body>
</html>