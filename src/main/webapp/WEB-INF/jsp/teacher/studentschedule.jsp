<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>进度</title>
	<link rel="icon" type="image/png" href="../resource/i/favicon.png">
	<link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
	<script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/centercss.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/schedulecss.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/font-awesome.css">
	<script src="${pageContext.request.contextPath}/js/teacher-process.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/common.js" type="text/javascript"></script>
</head>
<body>
	<div class="headbar navbar navbar-fixed-top navbar-inverse" id="headbar1" role="navigation">
		
	</div>

	<script type="text/javascript">
	$("#headbar1").load("../common/teacher-header.html");
	</script>
	
	<div class="container" style="margin-top:80px;">
		<div class="table-responsive">
			<table class="table table-bordered table-hover table-condensed">
				<thead>
					<tr class="active">
						<th>学号</th>
						<th>任务书</th>
						<th>开题报告</th>
						<th>中期检查表</th>
						<th>论文</th>
						<th>指导老师评阅表</th>
						<th>评阅老师评阅表</th>
						<th>论文查重报告</th>
						<th>答辩申请表</th>
						<th>答辩记录表</th>
						<th>总进度</th>
					</tr>
				</thead>
				<tbody class="students-process">
				</tbody>
			</table>
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