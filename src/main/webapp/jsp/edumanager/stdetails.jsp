<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>选题详情</title>
	<link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
	<script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="../../css/centercss.css">
	<link rel="stylesheet" href="../../css/stdetails.css">
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
					<li><a href="edumanagercenter.jsp"><span class="glyphicon glyphicon-home"></span> 主页</a></li>
					<li><a href="stumanage.jsp"><span class="glyphicon glyphicon-user"></span> 学生管理</a></li>
					<li><a href="teachermanage.jsp"><span class="glyphicon glyphicon-user"></span> 教师管理</a></li>
					<li><a href="stdetails.jsp"><span class="glyphicon glyphicon-th-list"></span> 选题管理</a></li>
					<li><a href="answers.jsp"><span class="glyphicon glyphicon-th-list"></span> 答辩详情</a></li>
					<li><a href=""><span class="glyphicon glyphicon-user"></span> 个人信息</a></li>
				</ul>
			</div>
		</div>
	</div>
	
	<div class="container" style="margin-top:80px;">
		<div class="leftbar col-sm-3" id="leftbar1">
			<ul class="nav nav-pills nav-stacked">
				<li class="leftli" id="leftli" style="text-align:center;"><a href="javascript:void(0)">选题设置</a></li>
				
				<li class="leftli" id="leftli" style="text-align:center;"><a href="javascript:void(0)">全部</a></li>
				<li class="leftli" id="leftli" style="text-align:center;"><a href="javascript:void(0)">已选</a></li>
				<li class="leftli" id="leftli" style="text-align:center;"><a href="javascript:void(0)">未选</a></li>

			</ul>
		</div>
		<div class="rightdiv col-sm-9">
			<div class="set">
				<div style="text-align:right;margin:5px;">
					<button class="btn btn-primary" data-toggle="modal" data-target="#modal">修改</button>
				</div>
					
				
				<table class="table table-striped">
					<tbody>
						<tr>
							<td class="col-md-1">选题状态</td>
							<td class="col-md-3">开启</td>
						</tr>
						<tr>
							<td class="">教师课题状态</td>
							<td>可添加</td>
						</tr>
					</tbody>
				</table>
			</div>
			
			<div class="all-topic">
				<table class="table">
					<thead>
						<tr class="active">
							<th>序号</th>
							<th>课题名称</th>
							<th>课题类型</th>
							<th>对学生要求</th>
							<th>指导老师</th>
							<th>课题状态</th>
						</tr>
					</thead>
					<tbody>
						<tr class="success">
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td>可选</td>
						</tr>
						<tr class="success">
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td>不可选</td>
						</tr>
					</tbody>
				</table>
			</div>
			<div class="selected-topic">
				<table class="table">
					<thead>
						<tr class="active">
							<th>序号</th>
							<th>课题名称</th>
							<th>课题类型</th>
							<th>对学生要求</th>
							<th>指导老师</th>
							<th>课题状态</th>
						</tr>
					</thead>
					<tbody>
						<tr class="success">
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td>不可选</td>
						</tr>
					</tbody>
				</table>
			</div>
			<div class="selecting-topic">
			<table class="table">
					<thead>
						<tr class="active">
							<th>序号</th>
							<th>课题名称</th>
							<th>课题类型</th>
							<th>对学生要求</th>
							<th>指导老师</th>
							<th>课题状态</th>
						</tr>
					</thead>
					<tbody>
						<tr class="success">
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td>可选</td>
						</tr>
						
					</tbody>
				</table>
			</div>
		</div>
	</div>
	
	<div class="modal fade topic-details" id="modal" role="dialog" aria-hidden="true" aria-labelledby="modal-label">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button class="close" type="button" data-dismiss="modal" aria-hidden="true">×</button>
					<h4 class="modal-title" id="modal-label">修改状态</h4>
				</div>
				<div class="modal-body">
				
					<label>选题状态：</label>
					<label class="st-state-label"></label>
					<div class="btn-group">
						<button type="button" class="btn btn-success btn-xs">状态选择</button>
						<button type="button" class="btn btn-success btn-xs dropdown-toggle"
							id="dropdownMenu1" data-toggle="dropdown">
							<span class="caret"></span> <span class="sr-only"></span>
						</button>
						<ul class="dropdown-menu" role="menu"
							aria-labelledby="dropdownMenu1">
							<li role="presentation" id="type1"><a id="type-a1" role="menuitem" tabindex="-1" href="javascript:void(0)">开启</a></li>
							<li role="presentation" id="type2"><a id="type-a2" role="menuitem" tabindex="-1" href="javascript:void(0)">关闭</a></li>
						</ul>
					</div>
					<br>
					<label>教师课题状态：</label>
					<label class="t-state-label"></label>
					<div class="btn-group">
						<button type="button" class="btn btn-success btn-xs">状态选择</button>
						<button type="button" class="btn btn-success btn-xs dropdown-toggle"
							id="t-state-Menu" data-toggle="dropdown">
							<span class="caret"></span> <span class="sr-only"></span>
						</button>
						<ul class="dropdown-menu" role="menu"
							aria-labelledby="t-state-Menu">
							<li role="presentation" id="type1"><a id="type-a1" role="menuitem" tabindex="-1" href="javascript:void(0)">开启</a></li>
							<li role="presentation" id="type2"><a id="type-a2" role="menuitem" tabindex="-1" href="javascript:void(0)">关闭</a></li>
						</ul>
					</div>
				</div>
				<div class="modal-footer">
					<button class="btn btn-primary" type="button">提交</button>
					<button class="btn btn-primary" type="button" data-dismiss="modal">关闭</button>
				</div>
			</div>
		</div>
	</div>
</body>
</html>