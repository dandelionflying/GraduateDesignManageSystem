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
	<script src="${pageContext.request.contextPath}/js/teacher2.js" type="text/javascript"></script>
	<script src="https://cdn.bootcss.com/bootstrap-select/2.0.0-beta1/js/bootstrap-select.js"></script>
	<link href="https://cdn.bootcss.com/bootstrap-select/2.0.0-beta1/css/bootstrap-select.css" rel="stylesheet">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/centercss.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/tcentercss.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/font-awesome.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/custom.css">
	<script src="${pageContext.request.contextPath}/js/common.js" type="text/javascript"></script>
</head>
<body>
	<div class="headbar navbar navbar-fixed-top navbar-inverse" id="headbar1" role="navigation">
		
	</div>

	<script type="text/javascript">
	$("#headbar1").load("../common/teacher-header2.html");
	
	</script>

	<div class="container centerdiv">
		<div class="searchdiv">
			<select class="selectpicker" id="selectorclassify"
				name="selectclassify" data-first-option="false" title='选择文档分类'
				multiple data-live-search="true" data-live-search-placeholder="搜索">

			</select>
			<button class="btn btn-info" onclick="search()">筛选</button>
		</div>
		<div class="docdiv" id="docdiv">
			<table class="table">
				<thead>
					<tr class="active">
						<th>学号</th>
						<th>文件名</th>
						<th>分类</th>
						<th>状态</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody class="docs">

				</tbody>
			</table>
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