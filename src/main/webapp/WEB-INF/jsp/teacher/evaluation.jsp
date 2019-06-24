<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>评阅</title>
<link rel="icon" type="image/png" href="../resource/i/favicon.png">
<link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap-fileinput/4.4.8/js/fileinput.min.js"></script>
<script src="${pageContext.request.contextPath}/js/zh.js" type="text/javascript"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/font-awesome.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/custom.css">
<link href="https://cdn.bootcss.com/bootstrap-fileinput/4.4.8/css/fileinput.min.css" rel="stylesheet">
<link rel="stylesheet" href="../css/centercss.css">
<link rel="stylesheet" href="../css/tdocument.css">
<script src="${pageContext.request.contextPath}/js/common.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/teacher-evaluation.js" type="text/javascript"></script>
<body>
	<div class="headbar navbar navbar-fixed-top navbar-inverse" id="headbar1" role="navigation">
		
	</div>

	<script type="text/javascript">
	$("#headbar1").load("../common/teacher-header2.html");
	</script>

	<div class="container" style="margin-top: 80px;">
		<div class="evaluation" id="evaluation">
				<table class="table">
					<thead>
						<tr class="active ">
							<th>学号</th>
							<th>姓名</th>
							<th>班级</th>
							<th>文献翻译</th>
							<th>评阅老师成绩</th>
							<th>指导老师成绩</th>
							<th>答辩成绩</th>
							<th>总成绩</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody class="evaluation-body">
						
					</tbody>
				</table>
				<label class="hidden-div" hidden="hidden"></label>
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
	<div class="footer" style="margin-bottom:50px"></div>
	<script type="text/javascript">
		$(".footer").load("../common/footer.html");
	</script>
</body>
</html>