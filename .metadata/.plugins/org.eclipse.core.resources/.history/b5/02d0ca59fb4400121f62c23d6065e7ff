<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<form id="ff" action="../ajax/goods_edit" method="post">
	<table class="formtable2">
		<caption>商品修改</caption>
		<tr>
			<th><label for="goodsType">商品类型</label></th>
			<td><input name="goodsType" id="goodsType"
				class="easyui-combobox"
				data-options="valueField:'typeId',textField:'typeName',url:'../ajax/goodsType_gets'"
				value="${goods.goodsType }" /></td>
		</tr>
		<tr>
			<th><label for="goodsProp">商品属性</label></th>
			<td><input name="goodsProp" id="goodsProp"
				class="easyui-combobox"
				data-options="valueField:'typeId',textField:'typeName',url:'../ajax/goodsProp_gets'"
				value="${goods.goodsProp }" /></td>
		</tr>
		<tr>
			<th><label for="goodsPrice">商品价格</label></th>
			<td><input name="goodsPrice" id="goodsPrice"
				class="easyui-numberbox" data-options="min:0,precision:2"
				value="${goods.goodsPrice }" /></td>
		</tr>
		<tr>
			<th><label for="valid">是否有效</label></th>
			<td><s:radio name="valid" list="#{false:'无效',true:'有效'}"
					value="%{goods.valid }" />
		</tr>
		<tr>
			<th valign="top"><label for="note">备注</label></th>
			<td><textarea name="note" id="note">${goods.note }</textarea></td>
		</tr>
		<tr>
			<th>&nbsp;<input name="goodsId" type="hidden"
				value="${goods.goodsId }" /></th>
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
