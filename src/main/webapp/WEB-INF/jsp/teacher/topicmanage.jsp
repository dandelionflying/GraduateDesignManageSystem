<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>课题管理</title>
	<link rel="icon" type="image/png" href="../resource/i/favicon.png">
	<link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
	<script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/centercss.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/topicmanagecss.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/fileinput.min.css">
	<script src="${pageContext.request.contextPath}/js/fileinput.min.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/teacher-topic.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/common.js" type="text/javascript"></script>
	
</head>
<body>
	<div class="headbar navbar navbar-fixed-top navbar-inverse" id="headbar1" role="navigation">
		
	</div>

	<script type="text/javascript">
	$("#headbar1").load("../common/teacher-header.html");
	</script>

	<div class="container" style="margin-top: 80px;">
		<div class="leftbar col-sm-3" id="leftbar1">
			<ul class="nav nav-pills nav-stacked">
				<li class="leftli" id="leftli1"><a href="javascript:void(0)">全部课题</a></li>
				<li class="leftli" id="leftli2"><a href="javascript:void(0)">我的课题</a></li>
				<li class="leftli" id="leftli3" data-toggle="modal" data-target="#apply-modal"><a href="javascript:void(0)">添加课题</a></li>

			</ul>
		</div>
		<div class="col-sm-9">
			<div class="topicmsg">
				<table class="table table-striped" id="topic-table">
					<tbody id="topics">

					</tbody>
				</table>
			</div>
			<nav aria-label="Page navigation">
			  <ul class="pagination" id="topic-pagination">
			  
			  </ul>
			</nav>
			
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
							<label class="tname form-control" id="teacherName"></label>
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
									<li role="presentation" id="type1"><a id="classify1" role="menuitem" tabindex="-1" href="javascript:void(0)">工程设计</a></li>
									<li role="presentation" id="type2"><a id="classify2" role="menuitem" tabindex="-1" href="javascript:void(0)">综合试验</a></li>
									<li role="presentation" id="type3"><a id="classify3" role="menuitem" tabindex="-1" href="javascript:void(0)">专题研究</a></li>
									<li role="presentation" id="type4"><a id="classify4" role="menuitem" tabindex="-1" href="javascript:void(0)">专题论文</a></li>
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
	<!-- 编辑课题modal -->
	<div class="update-topic modal fade" id="update-modal" role="dialog" aria-labelledby="#modal-title-label" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				
				<form role="form" action="addNewTopic">
					<div class="modal-header">
						<button class="close" type="button" data-dismiss="modal" aria-hidden="true">&times;</button>
						<h4 class="modal-title" id="modal-title-label">添加课题</h4>
					</div>
					<div class="modal-body">
						<div class="form-group">
							<label>课题编号</label>
							<input class="form-control" id="update-topic-id" disabled="disabled">
							<label>课题名称</label>
							<input class="form-control" id="update-topic-name" name="update-topic-topicName">
							<label>课题简介</label>
							<textarea class="form-control" id="update-topic-content" name="update-topic-content" rows="5" cols="" style="width:100%"></textarea>
							<br>
							<label>指导老师</label>
							<label class="tname form-control" id="update-topic-teacherName"></label>
							<br>
							<label>课题类型：</label>
							<label class="update-type-label" id="topic_type"></label>
							<div class="btn-group">
								<button type="button" class="btn btn-success btn-xs">选择</button>
								<button type="button" class="btn btn-success btn-xs dropdown-toggle"
									id="dropdownMenu1" data-toggle="dropdown">
									<span class="caret"></span> <span class="sr-only"></span>
								</button>
								<ul class="dropdown-menu" role="menu"
									aria-labelledby="dropdownMenu1">
									<li role="presentation" class="dropdown-header">类型选择</li>
									<li role="presentation" id="type1"><a id="update-classify1" role="menuitem" tabindex="-1" href="javascript:void(0)">工程设计</a></li>
									<li role="presentation" id="type2"><a id="update-classify2" role="menuitem" tabindex="-1" href="javascript:void(0)">综合试验</a></li>
									<li role="presentation" id="type3"><a id="update-classify3" role="menuitem" tabindex="-1" href="javascript:void(0)">专题研究</a></li>
									<li role="presentation" id="type4"><a id="update-classify4" role="menuitem" tabindex="-1" href="javascript:void(0)">专题论文</a></li>
								</ul>
							</div>
							<br>
							<label>对学生要求</label>
							<textarea class="form-control" id="update-topic-demand" name="update-topic-demand" rows="5" cols="" style="width:100%"></textarea>
						</div>

					</div>
					<div class="modal-footer">

						<button type="button" id="send-btn" class="btn btn-info apply" onclick="sendUpdateForm()">提交修改</button>

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
	<div class="laoding"></div>
	<script type="text/javascript">
		$(".laoding").load("../common/loading-modal.html");
	</script>
	
	<div class="footer" style="margin-bottom:50px"></div>
	<script type="text/javascript">
		$(".footer").load("../common/footer.html");
	</script>
</body>
</html>