<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%> 
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath %>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<title>Online Charge System</title>
<link id="easyuiTheme" rel="stylesheet" type="text/css"
	href="easyUI/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="easyUI/themes/icon.css">
<script type="text/javascript" src="easyUI/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="easyUI/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="easyUI/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="js/jquery.cookie.js"></script>
<style type="text/css">
* {
	padding: 0;
	margin: 0
}
</style>
</head>
<body class="easyui-layout">
	<!-- 北-start -->
	<div data-options="region:'north',border:false"
		style="height: 60px; padding: 10px">
		<h1>Online Charge System</h1>
		<div id="sessionInfoDiv"
			style="position: absolute; right: 5px; top: 10px;">
			[<strong id="userName"></strong>]，欢迎你！您使用[<strong id="ipAddress"></strong>]IP登录！
		</div>
		<div style="position: absolute; right: 0px; bottom: 0px;">
			<a href="javascript:void(0);" class="easyui-menubutton"
				menu="#layout_north_pfMenu" iconCls="icon-ok">更换皮肤</a> <a
				href="javascript:void(0);" class="easyui-menubutton"
				menu="#layout_north_kzmbMenu" iconCls="icon-help">控制面板</a> <a
				href="javascript:void(0);" class="easyui-menubutton"
				menu="#layout_north_zxMenu" iconCls="icon-back">注销</a>
		</div>
		<div id="layout_north_pfMenu" style="width: 120px; display: none;">
			<div onclick="sy.changeTheme('default');">default</div>
			<div onclick="sy.changeTheme('gray');">gray</div>
			<div onclick="sy.changeTheme('metro');">metro</div>
		</div>
		<div id="layout_north_kzmbMenu" style="width: 100px; display: none;">
			<div onclick="showUserInfo();">个人信息</div>
			<div class="menu-sep"></div>
			<div>
				<span>更换主题</span>
				<div style="width: 120px;">
					<div onclick="sy.changeTheme('default');">default</div>
					<div onclick="sy.changeTheme('gray');">gray</div>
					<div onclick="sy.changeTheme('metro');">metro</div>
				</div>
			</div>
		</div>
		<div id="layout_north_zxMenu" style="width: 100px; display: none;">
			<div onclick="logout(true);">锁定窗口</div>
			<div class="menu-sep"></div>
			<div onclick="logout(true);">注销用户</div>
		</div>
		<script type="text/javascript">
	    $(function(){
		    $.ajax({
				type : 'POST',
				url : 'ajax/getSessionInfo',
				success : function(result) {
				    $('#userName').html(result.userName);
				    $('#ipAddress').html(result.ipAddress);
				},
				dataType:'json'
			  });
	    });
		function logout(b) {
			$.post('ajax/logout', function() {
			    location.replace(sy.bp());
			});
		}
	
		function showUserInfo() {
			$('<div/>').window({
				modal : true,
				title : '当前用户信息',
				width : 350,
				height : 300,
				collapsible : false,
				minimizable : false,
				maximizable : false,
				href : 'showUserInfo.htm',
				onClose : function() {
					$(this).window('destroy');
				}
			});
		}
		</script>
	</div>
	<!-- 北-end -->
	<!-- 西-start -->
	<div data-options="region:'west',split:true,title:'功能导航'"
		style="width: 200px; padding: 10px;">
		<ul id="menu-tree"></ul>
		<script type="text/javascript">
			$(function()
			{
			  $('#menu-tree').tree(
			  {
			    url:'ajax/tree_menu_getdata',
				onSelect: function(node)
				{  
				  if(node.attributes.link != '')
				  {
				    //$('#ss').panel({'title' : 'Online Charge Syste >>' + node.text});
		            $('#center').attr('src', node.attributes.link); 
		          }			
		        },
		        onLoadError: function(err){
		          //alert('数据加载错误');
		        }
		      });
			});
		</script>
	</div>
	<!-- 西-end -->
	<!-- 东-start -->
	<!--<div data-options="region:'east',split:true,title:'日历'" style="width:180px;">
		<div class="easyui-layout" fit="true" border="false">
			<div region="north" border="false" style="height:180px;overflow: hidden;">
				<div id="calendar"></div>
			</div>
			<div region="center" border="false" style="overflow: hidden;">
				<div id="onlinePanel" fit="true" border="false" title="用户在线列表">
					<table id="onlineDatagrid"></table>
				</div>
			</div>
			<div id="userOnlineInfoDialog" style="display: none;width: 250px;height: 130px;">
				<table id="userOnlineInfoDataGrid"></table>
			</div>
		</div>
		<script type="text/javascript" >
		$('#calendar').calendar(
	      {
	      	current:new Date(),
	      	border:false
	      });
		</script>
	</div>
	-->
	<!-- 东-end -->
	<!-- 南-start -->
	<div data-options="region:'south',border:false"
		style="height: 50px; padding: 10px;">
		<span style="position: absolute; right: 50px; top: 10px;">&#169;
			2012 XXXX（软件）公司 版权所有</span>
	</div>
	<!-- 南-end -->
	<!-- 中-start -->
	<div data-options="region:'center',title:'控制台'"
		style="overflow: hidden">
		<iframe id="center" style="width: 100%; height: 100%;border: 0;"></iframe>
	</div>
	<!-- 中-end -->
</body>
</html>