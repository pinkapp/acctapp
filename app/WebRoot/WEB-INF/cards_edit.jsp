<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<form id="ff" action="../ajax/cards_edit" method="post">
	<table class="formtable2">
		<caption>充值卡修改</caption>
		<tr>
			<th><label for="cardType">充值卡类型</label></th>
			<td><input name="cardType" id="cardType" class="easyui-combobox"
				data-options="valueField:'typeId',textField:'typeName',url:'../ajax/cardType_gets'"
				value="${card.cardType }" /></td>
		</tr>
		<tr>
			<th><label for="cardState">状态</label></th>
			<td><input name="cardState" id="cardState"
				class="easyui-combobox"
				data-options="valueField:'stateId',textField:'stateName',url:'../ajax/cardState_gets'"
				value="${card.cardState }" /></td>
		</tr>
		<tr>
			<th><label for="valid">是否有效</label></th>
			<td><s:radio name="valid" list="#{false:'无效',true:'有效'}"
					value="%{card.valid }" />
		</tr>
		<tr>
			<th valign="top"><label for="note">备注</label></th>
			<td><textarea name="note" id="note">${card.note }</textarea></td>
		</tr>
		<tr>
			<th>&nbsp;<input name="cardId" type="hidden"
				value="${card.cardId }" /></th>
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
