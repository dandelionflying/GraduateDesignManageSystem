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
    <script src="${pageContext.request.contextPath}/js/notice.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/amazeui.min.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/admin.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/app.css">
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
							<i class="am-icon-angle-right tpl-left-nav-more-ico am-fr am-margin-right"></i>
						</a>
						<ul class="tpl-left-nav-sub-menu">
							<li>
								<a href="teacherManage">
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
							<i class="am-icon-angle-right tpl-left-nav-more-ico am-fr am-margin-right tpl-left-nav-more-ico-rotate"></i>
						</a>
						<ul class="tpl-left-nav-sub-menu" style="display: block">
							<li>
								<a class="active" href="toNotice">
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
                通知通告
            </div>
            <ol class="am-breadcrumb">
                <li><a href="edumanagercenter" class="am-icon-home">首页</a></li>
                <li><a href="#">--</a></li>
                <li class="am-active">--</li>
            </ol>
            <div class="tpl-portlet-components">
                <div class="tpl-block">
                    <div class="am-g" style="margin-bottom:15px">
                        <div class="am-u-sm-12 am-u-md-6">
                            <div class="am-btn-toolbar">
                                <div class="am-btn-group am-btn-group-xs">
                                    <button type="button" class="am-btn am-btn-default am-round am-btn-primary" id="btn-addnotice"><span class="am-icon-plus"></span> 写通知</button>
                                </div>
                            </div>
                        </div>
                       
                    </div>

					<ul class="tpl-task-list tpl-task-remind" id="notice-ul">
						
					</ul>
				</div>
                <div class="tpl-alert"></div>
            </div>

        </div>
        
    </div>

	<div class="am-modal am-modal-no-btn" tabindex="-1" id="addnotice-modal-1">
		<div class="am-modal-dialog">
			<div class="am-modal-hd" id="topic-title">
				发布通知 <a href="javascript: void(0)"
					class="am-close am-close-spin" data-am-modal-close>&times;</a>
			</div>
			<div class="am-modal-bd" id="modal-body">
				<div>
					<form class="am-form am-form-horizontal">
						<div class="am-form-group">
							<label for="user-name" class="am-u-sm-3 am-form-label">通知对象</label>
							<div class="am-u-sm-9">
								
                                <select id="to-who" data-am-selected="{btnSize: 'sm'}">
                                	<option value="0">全部</option>
                                	<option value="1">学生</option>
									<option value="2">教师</option>
					            </select>
							</div>
						</div>

						<div class="am-form-group">
							<label for="user-intro" class="am-u-sm-3 am-form-label">通知内容</label>
							<div class="am-u-sm-9">
								<textarea id="notice-content" rows="5" id="user-intro" placeholder="输入通知"></textarea>
								<small>50字以内</small>
							</div>
						</div>

						<div class="am-form-group">
							<div class="am-u-sm-9 am-u-sm-push-3">
								<button type="button" class="am-btn am-btn-default am-btn-primary am-btn-sm am-round" id="submit-notice-btn">发布</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>

	<script src="${pageContext.request.contextPath}/js/amazeui.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/app.js"></script>
    
</body>

</html>