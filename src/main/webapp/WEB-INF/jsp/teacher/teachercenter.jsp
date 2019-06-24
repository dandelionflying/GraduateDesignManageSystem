<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>教师中心</title>
	<link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
	<link rel="icon" type="image/png" href="../resource/i/favicon.png">
	<script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script src="https://cdn.bootcss.com/bootstrap-fileinput/4.4.8/js/fileinput.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/zh.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/teacherjs.js" type="text/javascript"></script>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/centercss.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/tcentercss.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/font-awesome.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/custom.css">
	<link href="https://cdn.bootcss.com/bootstrap-fileinput/4.4.8/css/fileinput.min.css" rel="stylesheet">
</head>
<body>
	<div class="headbar navbar navbar-fixed-top navbar-inverse" id="headbar1" role="navigation">
		
	</div>

	<script type="text/javascript">
	$("#headbar1").load("../common/teacher-header.html");
	</script>
	
	<div class="container centerdiv">
		<div class="students">
			<div class="row">
				<div>
					<h3>选择您的课题的学生如下</h3>
				</div>
			</div>
			<div class="row" id="students">
					
			</div>

		</div>

		<div class="detail">
			
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
	<div class="footer" style="margin-bottom:100px"></div>
	<script type="text/javascript">
		$(".footer").load("../common/footer.html");
	</script>
</body>
</html>