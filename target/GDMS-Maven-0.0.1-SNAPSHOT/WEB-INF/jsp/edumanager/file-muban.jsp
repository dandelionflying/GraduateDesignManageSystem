<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html>
<head>
	<meta charset="UTF-8">
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
	<!-- <link rel="stylesheet" href="http://beta.amazeui.org/dist/css/amazeui.css"> -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/amazeui.min.css">
	<%-- <link rel="stylesheet" href="${pageContext.request.contextPath}/css/amazeui.switch.css"/> --%>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/admin.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/app.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/amazeui.upload.css"/>
	<script src="${pageContext.request.contextPath}/js/jquery-3.3.1.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/amazeui.upload.js"></script>
	<script src="${pageContext.request.contextPath}/js/amazeui.upload.template.js"></script>
	<script src="${pageContext.request.contextPath}/js/amazeui.upload.event.js"></script>
	<%-- <script src="${pageContext.request.contextPath}/js/amazeui.switch.min.js"></script> --%>
	<script src="${pageContext.request.contextPath}/js/echarts.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/manager-files.js"></script>
</head>
<body data-type="generalComponents">
	<header class="am-topbar am-topbar-inverse admin-header">
        <div class="am-topbar-brand">
            <a href="javascript:;" class="tpl-logo">
                <img src="${pageContext.request.contextPath}/resource/img/logo.png" alt="">
            </a>
        </div>
        <div class="am-icon-list tpl-header-nav-hover-ico am-fl am-margin-right">

        </div>

        <button class="am-topbar-btn am-topbar-toggle am-btn am-btn-sm am-btn-success am-show-sm-only" data-am-collapse="{target: '#topbar-collapse'}"><span class="am-sr-only">导航切换</span> <span class="am-icon-bars"></span></button>

        <div class="am-collapse am-topbar-collapse" id="topbar-collapse">

            <ul class="am-nav am-nav-pills am-topbar-nav am-topbar-right admin-header-list tpl-header-list">
                <li class="am-dropdown" data-am-dropdown data-am-dropdown-toggle>
                    <a class="am-dropdown-toggle tpl-header-list-link" href="javascript:;">
                        <span class="am-icon-bell-o"></span> 提醒 <span class="am-badge tpl-badge-success am-round">5</span></span>
                    </a>
                    <ul class="am-dropdown-content tpl-dropdown-content">
                        <li class="tpl-dropdown-content-external">
                            <h3>你有 <span class="tpl-color-success">5</span> 条提醒</h3><a href="###">全部</a></li>
                        <li class="tpl-dropdown-list-bdbc"><a href="#" class="tpl-dropdown-list-fl"><span class="am-icon-btn am-icon-plus tpl-dropdown-ico-btn-size tpl-badge-success"></span> 【预览模块】移动端 查看时 手机、电脑框隐藏。</a>
                            <span class="tpl-dropdown-list-fr">3小时前</span>
                        </li>
                        <li class="tpl-dropdown-list-bdbc"><a href="#" class="tpl-dropdown-list-fl"><span class="am-icon-btn am-icon-check tpl-dropdown-ico-btn-size tpl-badge-danger"></span> 移动端，导航条下边距处理</a>
                            <span class="tpl-dropdown-list-fr">15分钟前</span>
                        </li>
                        <li class="tpl-dropdown-list-bdbc"><a href="#" class="tpl-dropdown-list-fl"><span class="am-icon-btn am-icon-bell-o tpl-dropdown-ico-btn-size tpl-badge-warning"></span> 追加统计代码</a>
                            <span class="tpl-dropdown-list-fr">2天前</span>
                        </li>
                    </ul>
                </li>
                
                <li class="am-hide-sm-only"><a href="javascript:;" id="admin-fullscreen" class="tpl-header-list-link"><span class="am-icon-arrows-alt"></span> <span class="admin-fullText">开启全屏</span></a></li>

                <li class="am-dropdown" data-am-dropdown data-am-dropdown-toggle>
                    <a class="am-dropdown-toggle tpl-header-list-link" href="javascript:;">
                        <span class="tpl-header-list-user-nick">runnin4light</span><span class="tpl-header-list-user-ico"> <img src="${pageContext.request.contextPath}/resource/img/user01.png"></span>
                    </a>
                    <ul class="am-dropdown-content">
                        <li><a href="#"><span class="am-icon-bell-o"></span> 资料</a></li>
                        <li><a href="#"><span class="am-icon-cog"></span> 设置</a></li>
                        <li><a href="#"><span class="am-icon-power-off"></span> 退出</a></li>
                    </ul>
                </li>
                <li><a href="###" class="tpl-header-list-link"><span class="am-icon-sign-out tpl-header-list-ico-out-size"></span></a></li>
            </ul>
        </div>
    </header>

	<div class="tpl-page-container tpl-page-header-fixed">


		<div class="tpl-left-nav tpl-left-nav-hover">
			<div class="tpl-left-nav-title">Amaze UI 列表</div>
			<div class="tpl-left-nav-list">
				<ul class="tpl-left-nav-menu">
					<li class="tpl-left-nav-item"><a href="edumanagercenter"
						class="nav-link active"> <i class="am-icon-home"></i> <span>首页</span>
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
								<a href="">
									<i class="am-icon-angle-right"></i><span>答辩</span>
								</a>
								
							</li>
							<li>
								<a href="">
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
							<i class="am-icon-angle-right tpl-left-nav-more-ico am-fr am-margin-right tpl-left-nav-more-ico-rotate"></i>
						</a>
						<ul class="tpl-left-nav-sub-menu" style="display: block">
							<li>
								<a class="active" href="file-muban">
									<i class="am-icon-angle-right"></i><span>模板文件</span>
								</a>
								<a href="file-student">
									<i class="am-icon-angle-right"></i><span>学生文档</span>
								</a>
							</li>
						</ul>
					</li>

					<li class="tpl-left-nav-item"><a href="login.html"
						class="nav-link tpl-left-nav-link-list"> <i
							class="am-icon-key"></i> <span>登录</span>

					</a></li>
				</ul>
			</div>
		</div>

		<div class="tpl-content-wrapper">
			<div class="tpl-content-page-title">模板文件</div><br>
			<ol class="am-breadcrumb">
                <li><a href="edumanagercenter" class="am-icon-home">首页</a></li>
                <li><a href="#">文件管理</a></li>
                <li class="am-active">模板文件</li>
            </ol>
			<div class="tpl-portlet-components">
                <div class="portlet-title">
                    <div class="caption font-green bold">
                        <span class="am-icon-code"></span> 列表
                    </div>

                </div>
                <div class="tpl-block">
                    <div class="am-g">
                        <div class="am-u-sm-12 am-u-md-6">
                            <div class="am-btn-toolbar">
                                <div class="am-btn-group am-btn-group-xs">
                                    <button type="button" class="am-btn am-btn-default am-round am-btn-danger"><span class="am-icon-remove"></span> 批量删除</button>
                                </div>
                                <div class="am-btn-group am-btn-group-xs" id="add-muban-file-btn">
                                    <button type="button" class="am-btn am-btn-default am-round am-btn-primary"><span class="am-icon-plus"></span> 添加文件</button>
                                </div>
                            </div>
                        </div>
                        <div class="am-u-sm-12 am-u-md-3">
                            <div class="am-form-group">
                                <select data-am-selected="{btnSize: 'sm'}" id="-option">
					              	<option value="0">全部</option>
					              	<option value="1">学生</option>
					              	<option value="2">教师</option>
					              	<option value="3">管理员</option>
					            </select>
                            </div>
                        </div>
                        <div class="am-u-sm-12 am-u-md-3">
                            <div class="am-input-group am-input-group-sm">
                                <input type="text" id="key" class="am-form-field" placeholder="根据文件名搜索">
                                <span class="am-input-group-btn">
            						<button class="am-btn  am-btn-default am-btn-success tpl-am-btn-success am-icon-search" id="topic-search" type="button"></button>
          						</span>
                            </div>
                        </div>
                    </div>
                    <ul class="tpl-task-list">
                    <li>
                            <div class="task-checkbox">
                                <input type="hidden" value="1" name="test">
                                <input type="checkbox" class="liChild" value="2" name="test"> </div>
                            <div class="task-title">
                                <span class="task-title-sp"> Amaze UI Icon 组件目前使用了 Font Awesome </span>
                                <span class="label label-sm label-success">技术部</span>
                                <span class="task-bell">
                                            <i class="am-icon-bell-o"></i>
                                        </span>
                            </div>
                            <div class="task-config">
                                <div class="am-dropdown tpl-task-list-dropdown" data-am-dropdown="">
                                    <a href="###" class="am-dropdown-toggle tpl-task-list-hover " data-am-dropdown-toggle="">
                                        <i class="am-icon-cog"></i> <span class="am-icon-caret-down"></span>
                                    </a>
                                    <ul class="am-dropdown-content tpl-task-list-dropdown-ul">
                                        <li>
                                            <a href="javascript:;">
                                                <i class="am-icon-check"></i> 保存 </a>
                                        </li>
                                        <li>
                                            <a href="javascript:;">
                                                <i class="am-icon-pencil"></i> 编辑 </a>
                                        </li>
                                        <li>
                                            <a href="javascript:;">
                                                <i class="am-icon-trash-o"></i> 删除 </a>
                                        </li>
                                    </ul>


                                </div>
                            </div>
                        </li>
                        <!-- <li>
                            <div class="task-checkbox">
                                <input type="hidden" value="1" name="test">
                                <input type="checkbox" class="liChild" value="2" name="test"> </div>
                            <div class="task-title">
                                <span class="task-title-sp">文件名称</span>
                                <span class="label label-sm label-success">学生</span>
                            	<span style="float:right;font-style: italic;">2019-5-5</span>
                            </div>
                        </li> -->
                    </ul>
                    <div class="am-g">
                        <div class="am-u-sm-12">
                        
                            <div class="am-cf">
                                <div class="am-fr">
                                	<ul class="am-pagination tpl-pagination" id="muban-file-page">
                                       
                                    </ul>
                                </div>
                            </div>
                            <hr>
                        </div>
                    </div>
                </div>
                <div class="tpl-alert"></div>
            </div>

			<div class="row">

			</div>
		</div>
	</div>
	<div class="am-modal am-modal-no-btn" tabindex="-1" id="add-muban-modal">
		<div class="am-modal-dialog">
			<div class="am-modal-hd" id="topic-title">
				添加模板文件 <a href="javascript: void(0)"
					class="am-close am-close-spin" data-am-modal-close>&times;</a>
			</div>
			<div class="am-modal-bd" id="modal-body">
				<div>
					<form class="am-form am-form-horizontal">
						<div class="am-form-group">
							<label for="user-name" class="am-u-sm-3 am-form-label">可见角色</label>
							<div class="am-u-sm-9">
								
                                <select id="to-who" data-am-selected="{btnSize: 'sm'}">
                                	<option value="0">全部</option>
                                	<option value="1">学生</option>
									<option value="2">教师</option>
					            </select>
							</div>
						</div>
						
						
						<div class="am-form-group">
							
						
							
						<div id="event"></div>
						</div>

						<div class="am-form-group">
							<div class="am-u-sm-9 am-u-sm-push-3">
								<!-- <button type="button" class="am-btn am-btn-default am-btn-primary am-btn-sm am-round" id="submit-notice-btn">上传</button> -->
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
<script src="http://beta.amazeui.org/dist/js/amazeui.js"></script>
<script src="${pageContext.request.contextPath}/js/iscroll.js"></script>
<script src="${pageContext.request.contextPath}/js/app.js"></script>
</body>
</html>