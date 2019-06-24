<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>教务管理员中心</title>
    <meta name="description" content="这是一个 index 页面">
    <meta name="keywords" content="index">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <link rel="icon" type="image/png" href="${pageContext.request.contextPath}/resource/i/favicon.png">
    <link rel="apple-touch-icon-precomposed" href="${pageContext.request.contextPath}/resource/i/app-icon72x72@2x.png">
    <meta name="apple-mobile-web-app-title" content="Amaze UI" />
    <script src="${pageContext.request.contextPath}/js/jquery-3.3.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/manager-teacher.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/amazeui.min.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/admin.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/app.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/manager-teacher.css">
    
    <!-- <script src="https://cdn.bootcss.com/bootstrap-fileinput/5.0.2/js/fileinput.js"></script>
    <link href="https://cdn.bootcss.com/bootstrap-fileinput/5.0.2/css/fileinput.css" rel="stylesheet"> -->
    
</head>

<body data-type="generalComponents">


    <header class="am-topbar am-topbar-inverse admin-header"> </header>

	<script type="text/javascript">
		$(".admin-header").load("../common/manager-header.html");
	</script>

    <div class="tpl-page-container tpl-page-header-fixed">


        <div class="tpl-left-nav tpl-left-nav-hover">
            <div class="tpl-left-nav-title">
                毕业综合实训管理系统
            </div>
            <div class="tpl-left-nav-list">
               <ul class="tpl-left-nav-menu">
					<li class="tpl-left-nav-item"><a href="edumanagercenter"
						class="nav-link"> <i class="am-icon-home"></i> <span>首页</span>
					</a></li>

					<li class="tpl-left-nav-item">
						<a href="javascript:;" class="nav-link tpl-left-nav-link-list">
							<i class="am-icon-table"></i> <span>课题管理</span>
							<i class="am-icon-angle-right tpl-left-nav-more-ico am-fr am-margin-right"></i>
						</a>
						<ul class="tpl-left-nav-sub-menu">
							<li>
								<a href="topiclist1">
									<i class="am-icon-angle-right"></i><span>待审核</span></a>
								<a href="topiclist2">
									<i class="am-icon-angle-right"></i><span>已通过</span></a>
								<a href="topiclist3">
									<i class="am-icon-angle-right"></i><span>已驳回</span></a>
								<a href="stdetails">
									<i class="am-icon-angle-right"></i><span>选题详情</span></a>
							</li>
						</ul>
					</li>
					<li class="tpl-left-nav-item">
						<a href="javascript:;" class="nav-link tpl-left-nav-link-list">
							<i class="am-icon-user"></i> <span>用户管理</span>
							<i class="am-icon-angle-right tpl-left-nav-more-ico am-fr am-margin-right tpl-left-nav-more-ico-rotate"></i>
						</a>
						<ul class="tpl-left-nav-sub-menu" style="display: block">
							<li>
								<a class="active" href="teacherManage">
									<i class="am-icon-angle-right"></i><span>教师管理</span>
								</a>
								<a href="studentManage">
									<i class="am-icon-angle-right"></i><span>学生管理</span>
								</a>
							</li>
						</ul>
					</li>
					<li class="tpl-left-nav-item">
						<a href="javascript:;" class="nav-link tpl-left-nav-link-list">
							<i class="am-icon-gavel"></i> <span>答辩管理</span>
							<i class="am-icon-angle-right tpl-left-nav-more-ico am-fr am-margin-right"></i>
						</a>
						<ul class="tpl-left-nav-sub-menu">
							<li>
								<a href="application">
									<i class="am-icon-angle-right"></i><span>答辩处理</span>
								</a>
							</li>
							<li>
								<a href="grade">
									<i class="am-icon-angle-right"></i><span>成绩管理</span>
								</a>
							</li>
						</ul>
					</li>
					<li class="tpl-left-nav-item">
						<a href="javascript:;" class="nav-link tpl-left-nav-link-list">
							<i class="am-icon-envelope"></i> <span>通知通告</span>
							<i class="am-icon-angle-right tpl-left-nav-more-ico am-fr am-margin-right"></i>
						</a>
						<ul class="tpl-left-nav-sub-menu">
							<li>
								<a href="toNotice">
									<i class="am-icon-angle-right"></i><span>通告</span>
								</a>
								
							</li>
						</ul>
					</li>
					<li class="tpl-left-nav-item">
						<a href="javascript:;" class="nav-link tpl-left-nav-link-list">
							<i class="am-icon-folder-open"></i> <span>文件管理</span>
							<i class="am-icon-angle-right tpl-left-nav-more-ico am-fr am-margin-right"></i>
						</a>
						<ul class="tpl-left-nav-sub-menu">
							<li>
								<a href="file-muban">
									<i class="am-icon-angle-right"></i><span>模板文件</span>
								</a>
								<a href="file-student">
									<i class="am-icon-angle-right"></i><span>学生文档</span>
								</a>
								
							</li>
						</ul>
					</li>
				</ul>
            </div>
        </div>


        <div class="tpl-content-wrapper">
            <div class="tpl-content-page-title">
                教师管理
            </div>
            <ol class="am-breadcrumb">
                <li><a href="edumanagercenter" class="am-icon-home">首页</a></li>
                <li><a href="#">用户管理</a></li>
                <li class="am-active">教师管理</li>
            </ol>
            <div class="tpl-portlet-components">
                <div class="portlet-title">
                    <div class="caption font-green bold">
                        <span class="am-icon-code"></span> 教师列表
                    </div>
                </div>
                <div class="tpl-block import">
                    <div class="am-g">
                    	<div class="am-u-sm-12">
                        	<button class="am-btn am-btn-primary am-round" id="add-teacher-btn">从excel文件导入</button>
                    	</div>
                    </div>
                    <div class="am-g">
                        <div class="am-u-sm-12">
                        	
							<table class="am-table am-table-striped am-table-radius am-table-hover table-main">
                                <thead>
                                    <tr>
                                        <th class="table-id">ID</th>
                                        <th class="table-name">姓名</th>
                                        <th class="table-department am-hide-sm-only">所属学院</th>
                                        <th class="table-rank am-hide-sm-only">职称</th>
                                        <th class="table-tel am-hide-sm-only">联系方式</th>
                                        <th class="table-mail am-hide-sm-only">e-mail</th>
                                        <th class="table-identify">角色</th>
                                    </tr>
                                </thead>
                                <tbody class="teacher-tbody">
                                    
                                    
                                    
                                </tbody>
                            </table>
                            <div class="am-cf">

                                <div class="am-fr">
                                    <ul class="am-pagination tpl-pagination" id="pagination-id">
                                    	
                                        <!-- <li><a href="#">«</a></li>
                                        <li class="am-active"><a href="#">1</a></li>
                                       
                                        <li><a href="#">»</a></li> -->
                                    </ul>
                                </div>
                            </div>
                            <hr>
                        </div>

                    </div>
                </div>
                <div class="tpl-alert"></div>
            </div>


        </div>
        
        <div class="am-modal am-modal-no-btn" tabindex="-1" id="detail-modal-1">
		  <div class="am-modal-dialog">
		    <div class="am-modal-hd" id="topic-title">Modal 标题
		      <a href="javascript: void(0)" class="am-close am-close-spin" data-am-modal-close>&times;</a>
		    </div>
		    <div class="am-modal-bd" id="modal-body">
		      <div>
		      	<table class="am-table">
		      		<tr class="am-g">
		      			<td class="am-u-sm-3">编号</td><td class="am-u-sm-9" id="topic-id"></td>
		      		</tr>
		      		<tr class="am-g">
		      			<td class="am-u-sm-3">教师</td><td class="am-u-sm-9" id="topic-teacher"></td>
		      		</tr>
		      		<tr class="am-g">
		      			<td class="am-u-sm-3">类型</td><td class="am-u-sm-9" id="topic-type"></td>
		      		</tr>
		      		<tr class="am-g">
		      			<td class="am-u-sm-3">具体内容</td><td class="am-u-sm-9" id="topic-content"></td>
		      		</tr>
		      		<tr class="am-g">
		      			<td class="am-u-sm-3">要求</td><td class="am-u-sm-9" id="topic-demand"></td>
		      		</tr>
		      		<tr class="am-g">
		      			<td class="am-u-sm-3">提交时间</td><td class="am-u-sm-9" id="topic-uploadtime"></td>
		      		</tr>
		      		<tr class="am-g">
		      			<td class="am-u-sm-3">状态</td><td class="am-u-sm-9"><span id="topic-state" class='label label-xs label-info'></span></td>
		      		</tr>
		      	</table>
			      
		      </div>
		    </div>
		  </div>
		</div>

    </div>
	
	<div class="am-modal am-modal-no-btn" tabindex="-1" id="add-teacher-modal">
		<div class="am-modal-dialog">
			<div class="am-modal-hd" id="topic-title">
				从Excel导入教师信息 <a href="javascript: void(0)"
					class="am-close am-close-spin" data-am-modal-close>&times;</a>
			</div>
			<div class="am-modal-bd" id="modal-body">
				<div>
					<form class="am-form am-form-horizontal">
						<div class="am-form-group">
							<a href="javascript:;" class="file-upload-a">选择文件
								<input type="file" name="newteachers" id="newteachers">
							</a>
						</div>
					</form>
						<label id="warning-msg" style="color:red"></label>
						<div class="am-form-group">
							<button class="am-btn am-btn-secondary am-round" id="commit-excel">提交</button>
						</div>
				</div>
			</div>
		</div>
	</div>

    <script src="${pageContext.request.contextPath}/js/amazeui.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/app.js"></script>
    
</body>

</html>