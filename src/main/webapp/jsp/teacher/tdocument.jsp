<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>学生文档</title>
<link
	href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet">
<script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="../../css/centercss.css">
<link rel="stylesheet" href="../../css/documentcss.css">
<script>
	window.onload = function() {
		$("#leftli1").click(function() {
			$(".docdiv").hide(1000);
			$("#docdiv1").show(1000);
		});
		$("#leftli2").click(function() {
			$(".docdiv").hide(1000);
			$("#docdiv2").show(1000);
		});
		$("#leftli3").click(function() {
			$(".docdiv").hide(1000);
			$("#docdiv3").show(1000);
		});
		$("#leftli4").click(function() {
			$(".docdiv").hide(1000);
			$("#docdiv4").show(1000);
		});

		$("#leftli5").click(function() {
			$(".docdiv").hide(1000);
			$("#docdiv5").show(1000);
		});

		$("#leftli6").click(function() {
			$(".docdiv").hide(1000);
			$("#docdiv6").show(1000);
		});

		$("#leftli7").click(function() {
			$(".docdiv").hide(1000);
			$("#docdiv7").show(1000);
		});
	}
</script>
</head>
<body>
	<div class="headbar navbar navbar-fixed-top navbar-inverse" id="headbar1" role="navigation">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
					<span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<a class="navbar-brand dropdown-toggle" id="dropdownMenu1" data-toggle="dropdown" href="javascript:void(0)">毕业设计管理系统</a>
				
				<ul class="dropdown-menu" role="menu"
						aria-labelledby="dropdownMenu1">
					
					<li role="presentation" id="type1"><a id="type-a1" role="menuitem" tabindex="-1" href="javascript:void(0)">
					<span class="glyphicon glyphicon-log-out"></span> 注销用户</a></li>
				</ul>
			</div>
			<div class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<li><a href="teachercenter.jsp"><span class="glyphicon glyphicon-home"></span> 主页</a></li>
					
					<li><a href="tdocument.jsp"><span class="glyphicon glyphicon-folder-open"></span> 学生文档</a></li>
					<li><a href="studentschedule.jsp"><span class="glyphicon glyphicon-align-left"></span> 学生任务进度</a></li>
					
				</ul>
			</div>
		</div>
	</div>

	<div class="container" style="margin-top: 80px;">
		<div class="leftbar col-sm-3" id="leftbar1">
			<ul class="nav nav-pills nav-stacked">
				<li class="leftli" id="leftli1"><a href="javascript:void(0)">开题报告</a></li>
				<li class="leftli" id="leftli2"><a href="javascript:void(0)">项目计划书</a></li>
				<li class="leftli" id="leftli3"><a href="javascript:void(0)">需求规格说明书</a></li>
				<li class="leftli" id="leftli4"><a href="javascript:void(0)">系统设计说明书</a></li>
				<li class="leftli" id="leftli5"><a href="javascript:void(0)">项目测试报告</a></li>
				<li class="leftli" id="leftli6"><a href="javascript:void(0)">毕业设计报告</a></li>
				<li class="leftli" id="leftli7"><a href="javascript:void(0)">毕业论文</a></li>

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
					<tbody>
						<tr class="success">
							<td>开题报告</td>
							<td></td>
							<td>doc</td>
							<td>
								<button class="btn btn-xs btn-success">下载</button>
								<button class="btn btn-xs btn-success">评价</button>
								
							</td>
						</tr>
						
					</tbody>
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
					<tbody>
						<tr class="success">
							<td>项目计划书</td>
							<td></td>
							<td>doc</td>
							<td>
								<button class="btn btn-xs btn-success">下载</button>
								<button class="btn btn-xs btn-success">评价</button>
							</td>
						</tr>
						
					</tbody>
				</table>
			</div>
			<!-- 需求规格说明书div -->
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
					<tbody>
						<tr class="success">
							<td>需求规格说明书</td>
							<td></td>
							<td>doc</td>
							<td>
								<button class="btn btn-xs btn-success">下载</button>
								<button class="btn btn-xs btn-success">评价</button>
							</td>
						</tr>
						
					</tbody>
				</table>
			</div>

			<!-- 系统设计说明书div -->
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
					<tbody>
						<tr class="success">
							<td>系统设计说明书</td>
							<td></td>
							<td>doc</td>
							<td>
								<button class="btn btn-xs btn-success">下载</button>
								<button class="btn btn-xs btn-success">评价</button>
							</td>
						</tr>
						
					</tbody>
				</table>
			</div>
			<!-- 项目测试报告div -->
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
					<tbody>
						<tr class="success">
							<td>项目测试报告</td>
							<td></td>
							<td>doc</td>
							<td>
								<button class="btn btn-xs btn-success">下载</button>
								<button class="btn btn-xs btn-success">评价</button>
							</td>
						</tr>
						
					</tbody>
				</table>
			</div>
			<!-- 毕业设计报告div -->
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
					<tbody>
						<tr class="success">
							<td>毕业设计报告</td>
							<td></td>
							<td>doc</td>
							<td>
								<button class="btn btn-xs btn-success">下载</button>
								<button class="btn btn-xs btn-success">评价</button>
							</td>
						</tr>
						
					</tbody>
				</table>
			</div>
			<!-- 毕业论文 -->
			<div class="docdiv" id="docdiv7">
				<table class="table">
					<thead>
						<tr class="active">
							<th>文件名</th>
							<th>上传日期</th>
							<th>文件类型</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
					
						<tr class="success">
							<td>毕业论文</td>
							<td></td>
							<td>doc</td>
							<td>
								<button class="btn btn-xs btn-success">下载</button>
								<button class="btn btn-xs btn-success">评价</button>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
			<div class="uploaddiv">
				<button class="btn btn-lg btn-primary">填写学生毕业设计评价表</button>
			</div>
		</div>
	</div>

</body>
</html>