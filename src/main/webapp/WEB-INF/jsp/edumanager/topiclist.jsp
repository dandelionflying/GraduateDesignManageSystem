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
    <script src="${pageContext.request.contextPath}/js/manager-list1.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/amazeui.min.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/admin.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/app.css">
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
                        <span class="tpl-header-list-user-nick">running4light</span><span class="tpl-header-list-user-ico"> <img src="${pageContext.request.contextPath}/resource/img/user01.png"></span>
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
            <div class="tpl-left-nav-title">
                Amaze UI 列表
            </div>
            <div class="tpl-left-nav-list">
               <ul class="tpl-left-nav-menu">
					<li class="tpl-left-nav-item"><a href="edumanagercenter"
						class="nav-link"> <i class="am-icon-home"></i> <span>首页</span>
					</a></li>

					<li class="tpl-left-nav-item">
						<a href="javascript:;" class="nav-link tpl-left-nav-link-list">
							<i class="am-icon-table"></i> <span>课题管理</span>
							<i class="am-icon-angle-right tpl-left-nav-more-ico am-fr am-margin-right tpl-left-nav-more-ico-rotate"></i>
						</a>
						<ul class="tpl-left-nav-sub-menu" style="display: block">
							<li>
								<a class="active" href="topiclist1">
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
							<i class="am-icon-envelope"></i> <span>通知通告</span>
							<i class="am-icon-angle-right tpl-left-nav-more-ico am-fr am-margin-right"></i>
						</a>
						<ul class="tpl-left-nav-sub-menu">
							<li>
								<a href="">
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
								<a href="">
									<i class="am-icon-angle-right"></i><span>文件</span>
								</a>
								
							</li>
						</ul>
					</li>

					<li class="tpl-left-nav-item"><a href="javascript:;"
						class="nav-link tpl-left-nav-link-list"> <i
							class="am-icon-wpforms"></i> <span>表单</span> <i
							class="am-icon-angle-right tpl-left-nav-more-ico am-fr am-margin-right tpl-left-nav-more-ico-rotate"></i>
					</a>
						<ul class="tpl-left-nav-sub-menu" style="display: block;">
							<li><a href="form-amazeui.html"> <i
									class="am-icon-angle-right"></i> <span>Amaze UI 表单</span> <i
									class="am-icon-star tpl-left-nav-content-ico am-fr am-margin-right"></i>
							</a> <a href="form-line.html"> <i class="am-icon-angle-right"></i>
									<span>线条表单</span>
							</a></li>
						</ul></li>

					<li class="tpl-left-nav-item"><a href="login.html"
						class="nav-link tpl-left-nav-link-list"> <i
							class="am-icon-key"></i> <span>登录</span>

					</a></li>
				</ul>
            </div>
        </div>





        <div class="tpl-content-wrapper">
            <div class="tpl-content-page-title">
                未审核课题
            </div>
            <ol class="am-breadcrumb">
                <li><a href="edumanagercenter" class="am-icon-home">首页</a></li>
                <li><a href="#">课题管理</a></li>
                <li class="am-active">待审核</li>
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
                                    <button type="button" class="am-btn am-btn-default am-btn-success"><span class="am-icon-plus"></span> 一键通过</button>
                                </div>
                            </div>
                        </div>
                        <div class="am-u-sm-12 am-u-md-3">
                            <div class="am-form-group">
                                <select data-am-selected="{btnSize: 'sm'}" id="classify-option">
					              	<option value="optionall">全部</option>
					            </select>
                            </div>
                        </div>
                        <div class="am-u-sm-12 am-u-md-3">
                            <div class="am-input-group am-input-group-sm">
                                <input type="text" id="key" class="am-form-field">
                                <span class="am-input-group-btn">
            						<button class="am-btn  am-btn-default am-btn-success tpl-am-btn-success am-icon-search" id="topic-search" type="button"></button>
          						</span>
                            </div>
                        </div>
                    </div>
                    <div class="am-g">
                        <div class="am-u-sm-12">
                        	
							<table class="am-table am-table-striped am-table-radius am-table-hover table-main">
                                <thead>
                                    <tr>
                                        <th class="table-id">ID</th>
                                        <th class="table-title">标题</th>
                                        <th class="table-type">类别</th>
                                        <th class="table-author am-hide-sm-only">作者</th>
                                        <th class="table-date am-hide-sm-only">修改日期</th>
                                        <th class="table-set">操作</th>
                                    </tr>
                                </thead>
                                <tbody class="new-topic-tbody">
                                    
                                </tbody>
                            </table>
                            <div class="am-cf">

                                <div class="am-fr">
                                    <ul class="am-pagination tpl-pagination" id="st-page">
                                        <!-- <li class="am-disabled"><a href="#">«</a></li>
                                        <li class="am-active"><a href="#">1</a></li>
                                        <li><a href="#">2</a></li>
                                       
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


    <script src="${pageContext.request.contextPath}/js/amazeui.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/app.js"></script>
    
</body>

</html>