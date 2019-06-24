<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>进度</title>
	<link rel="icon" type="image/png" href="${pageContext.request.contextPath}/resource/i/favicon.png">
	<link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
	<script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/centercss.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/schedulecss.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/font-awesome.css">
	<script>
		window.onload=function(){
			var len=($("#progress1").css("width")+$("#progress2").css("width")+$("#progress3").css("width")+$("#progress4").css("width")+$("#progress5").css("width")+$("#progress6").css("width"))/6;
			$(".whole-progress").css("width",len);
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
					
					<li role="presentation" id="type1"><a id="type-a1" role="menuitem" tabindex="-1" href="loginout">
					<span class="glyphicon glyphicon-log-out"></span> 注销用户</a></li>
				</ul>
			</div>
			<div class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<li><a href="teachercenter"><span class="glyphicon glyphicon-home"></span> 主页</a></li>
					
					<li><a href="tdocument"><span class="glyphicon glyphicon-folder-open"></span> 学生文档</a></li>
					<li><a href="studentschedule"><span class="glyphicon glyphicon-align-left"></span> 学生任务进度</a></li>
					
				</ul>
			</div>
		</div>
	</div>
	
	<div class="container schedule">
		<div class="">
			<h3>毕业设计总进度</h3>
			<div class="progress progress-striped active">
				<div class="progress-bar progress-bar-info whole-progress" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100"
	         style="width: 40%;">40%</div>
			</div>
		</div>
		
	</div>
	
	<div class="container">
		
		<div class="divideschedules">
			
			<div class="schedules col-md-4 col-sm-6 col-xs-12" id="schedules1">
					<!-- 选题 -->
				<h5>选题</h5>
				<div class="progress progress-striped active">
					<div class="progress-bar progress-bar-info" id="progress1" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100"
		         style="width: 100%;">100%</div>
				</div>
			</div>
			
			<div class="schedules col-md-4 col-sm-6 col-xs-12" id="schedules2">
				<!-- 需求分析 -->
				<h5>需求分析</h5>
				<div class="progress progress-striped active">
					<div class="progress-bar progress-bar-info" id="progress2" data-toggle="modal" data-target="#mymodal-need" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100"
		         style="width: 40%;">40%</div>
				</div>
			</div>
			
			<div class="schedules col-md-4 col-sm-6 col-xs-12" id="schedules3">
				<!-- 系统设计 -->
				<h5>系统设计</h5>
				<div class="progress progress-striped active">
					<div class="progress-bar progress-bar-info" id="progress3" data-toggle="modal" data-target="#mymodal-sysdesign" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100"
		         style="width: 40%;">40%</div>
				</div>
			</div>
			
			<div class="schedules col-md-4 col-sm-6 col-xs-12" id="schedules4">
				<!-- 测试 -->
				<h5>测试</h5>
				<div class="progress progress-striped active">
					<div class="progress-bar progress-bar-info" id="progress4" data-toggle="modal" data-target="#mymodal-test" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100"
		         style="width: 40%;">40%</div>
				</div>
			</div>
			<div class="schedules col-md-4 col-sm-6 col-xs-12" id="schedules5">
				<!-- 毕业设计报告 -->
				<h5>毕业设计报告</h5>
				<div class="progress progress-striped active">
					<div class="progress-bar progress-bar-info" id="progress5" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100"
		         style="width: 0%;">0%</div>
				</div>
			</div>
			
			<div class="schedules col-md-4 col-sm-6 col-xs-12" id="schedules6">
				<!-- 毕业论文 -->
				<h5>毕业论文</h5>
				<div class="progress progress-striped active">
					<div class="progress-bar progress-bar-info" id="progress6" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100"
		         style="width: 0%;">0%</div>
				</div>
			</div>
			
		</div>



		<!-- 需求分析模拟框 -->
		<div class="modal fade" id="mymodal-need" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel-need" aria-hidden="true"
			data-backdrop="true">
			<div class="modal-dialog">
				<div class="modal-content">
					
					<div class="modal-header">
						<button class="close" type="button" data-dismiss="modal"
							aria-hidden="true">&times;</button>
						<h4 class="modal-title" id="myModalLabel-need">详情</h4>
					</div>
					<div class="modal-body" style="text-align:center">
						
						<table class="table">
							<tbody>
								<tr class="success">
									<td><label>功能性需求</label></td>
									<td><p class="task-state">已完成</p></td>
								</tr>
								<tr class="success">
									<td><label>非功能性需求</label></td>
									<td><p class="task-state">未完成</p></td>
								</tr>
								<tr class="success">
									<td><label>约束条件分析</label></td>
									<td><p class="task-state">未完成</p></td>
								</tr>
							</tbody>
						</table>
						
					</div>
					<div class="modal-footer">
						<button class="btn btn-primary" type="button" data-dismiss="modal">关闭</button>
					</div>
				
				</div>
			</div>
		</div>
		
		<!-- 系统设计模拟框 -->
		<div class="modal fade" id="mymodal-sysdesign" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel-sysdesign" aria-hidden="true"
			data-backdrop="true">
			<div class="modal-dialog">
				<div class="modal-content">
					
					<div class="modal-header">
						<button class="close" type="button" data-dismiss="modal"
							aria-hidden="true">&times;</button>
						<h4 class="modal-title" id="myModalLabel-sysdesign">详情</h4>
					</div>
					<div class="modal-body" style="text-align:center">
						<table class="table">
							<tbody>
								<tr class="success">
									<td><label>概要设计</label></td>
									<td><p class="task-state">已完成</p></td>
								</tr>
								<tr class="success">
									<td><label>详细设计</label></td>
									<td><p class="task-state">未完成</p></td>
								</tr>
								
							</tbody>
						</table>
					</div>
					<div class="modal-footer">
						<button class="btn btn-primary" type="button" data-dismiss="modal">关闭</button>
					</div>
				
				</div>
			</div>
		</div>
		
		<!-- 测试模拟框 -->
		<div class="modal fade" id="mymodal-test" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel-test" aria-hidden="true"
			data-backdrop="true">
			<div class="modal-dialog">
				<div class="modal-content">
					
					<div class="modal-header">
						<button class="close" type="button" data-dismiss="modal"
							aria-hidden="true">&times;</button>
						<h4 class="modal-title" id="myModalLabel-test">详情</h4>
					</div>
					<div class="modal-body" style="text-align:center">
						<table class="table">
							<tbody>
								<tr class="success">
									<td><label>单元测试</label></td>
									<td><p class="task-state">已完成</p></td>
								</tr>
								<tr class="success">
									<td><label>集成测试</label></td>
									<td><p class="task-state">未完成</p></td>
								</tr>
								<tr class="success">
									<td><label>系统测试</label></td>
									<td><p class="task-state">未完成</p></td>
								</tr>
								
							</tbody>
						</table>
					</div>
					<div class="modal-footer">
						<button class="btn btn-primary" type="button" data-dismiss="modal">关闭</button>
					</div>
				
				</div>
			</div>
		</div>
		
		
		
	</div>

</body>
</html>