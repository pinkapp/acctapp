<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<form id="ff" action="../ajax/cardType_edit" method="post">
	<table class="formtable2">
		<caption>充值卡类型修改</caption>
		<tr>
			<th><label for="typeName">类型名称</label></th>
			<td><input name="typeName"
				data-options="required:true,missingMessage:'请填写类型名称'" id="typeName"
				class="easyui-validatebox" value="${cardType.typeName }"
				maxlength="32" tabindex="1" /></td>
		</tr>
		<tr>
			<th><label for="goodsType">商品类型</label></th>
			<td><input name="goodsType" id="goodsType"
				class="easyui-combobox"
				data-options="valueField:'typeId',textField:'typeName',url:'../ajax/goodsType_gets'"
				value="${cardType.goodsType }" /></td>
		</tr>
		<tr>
			<th><label for="faceValue">面值</label></th>
			<td><input name="faceValue" id="faceValue"
				class="easyui-numberbox" data-options="min:0,precision:0"
				value="${cardType.faceValue }" /></td>
		</tr>
		<tr>
			<th><label for="price">价格</label></th>
			<td><input name="price" id="price" class="easyui-numberbox"
				data-options="min:0,precision:2" value="${cardType.price }" /></td>
		</tr>
		<tr>
			<th><label for="valid">是否有效</label></th>
			<td><s:radio name="valid" list="#{false:'无效',true:'有效'}"
					value="%{cardType.valid }" />
		</tr>
		<tr>
			<th valign="top"><label for="note">备注</label></th>
			<td><textarea name="note" id="note">${cardType.note }</textarea></td>
		</tr>
		<tr>
			<th>&nbsp;<input name="typeId" type="hidden"
				value="${cardType.typeId }" /></th>
			<td><input type="submit" value="提交" /></td>
		</tr>
	</table>
</form>
<script type="text/javascript">
$(function(){
	$('#ff').form({
		success:function(data){
			$.messager.show({
								title:'提示',
								msg:data,
								timeout:2000,
								showType:'slide'
							});
		}
	});
});
</script>
