<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>通知消息</title>
	<link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
	<link rel="icon" type="image/png" href="../resource/i/favicon.png">
	<script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/teacher-notice.js" type="text/javascript"></script>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/centercss.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/teacher-notice.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/font-awesome.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/custom.css">
	<script src="${pageContext.request.contextPath}/js/common.js" type="text/javascript"></script>
</head>
<body>
	<div class="headbar navbar navbar-fixed-top navbar-inverse" id="headbar1" role="navigation">
		
	</div>

	<script type="text/javascript">
	$("#headbar1").load("../common/teacher-header.html");
	</script>

	<div class="container centerdiv">
		<div>
			<ul class="list-group" id="notice-group">
			</ul>
		</div>
		<nav aria-label="Page navigation">
		  <ul class="pagination" id="notice-pagination">
		    
		  </ul>
		</nav>
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