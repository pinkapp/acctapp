<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<table style="margin-left: auto; margin-right: auto; width: 300px;">
	<tr>
		<th width="30%;" align="right">QQ:</th>
		<td><label id="qq">${contactInfo.qq }</label></td>
	</tr>
	<tr>
		<th align="right">电话:</th>
		<td><label id="phone">${contactInfo.phone }</label></td>
	</tr>
	<tr>
		<th align="right">旺旺:</th>
		<td><label id="aliwangwang">${contactInfo.aliwangwang }</label></td>
	</tr>
</table>
