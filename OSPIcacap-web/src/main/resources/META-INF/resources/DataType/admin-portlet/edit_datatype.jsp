<%@page import="com.osp.icecap.constants.OSPIcecapPortletKeys"%>
<%@page import="com.osp.icecap.constants.OSPIcecapActionKeys"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.osp.icecap.web.constants.OSPIcecapWebConstants"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="com.osp.icecap.model.DataType"%>
<%@page import="java.util.List"%>
<%@page import="com.osp.icecap.service.DataTypeLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@ include file="../../init.jsp" %>

<portlet:actionURL var="addDataTypeURL" name="<%= OSPIcecapWebConstants.MVC_COMMAND_DATATYPE_ADMIN_ADD %>">
</portlet:actionURL>
<portlet:actionURL var="updateDataTypeURL" name="<%= OSPIcecapWebConstants.MVC_COMMAND_DATATYPE_ADMIN_UPDATE %>">
</portlet:actionURL>
<portlet:actionURL var="deleteDataTypeURL" name="<%= OSPIcecapWebConstants.MVC_COMMAND_DATATYPE_ADMIN_DELETE %>">
</portlet:actionURL>

<%
	DataType dataType = (DataType)renderRequest.getAttribute(OSPIcecapWebConstants.PARAM_DATATYPE);
	String action = OSPIcecapActionKeys.UPDATE_DATATYPE;
	String actionURL = updateDataTypeURL;
	String submitButtonLabel = LanguageUtil.get(request, "update");
	if( Validator.isNull(dataType)){
		action = OSPIcecapActionKeys.ADD_DATATYPE;
		actionURL = addDataTypeURL;
		submitButtonLabel = LanguageUtil.get(request, "add");
	}
	
	String showback = GetterUtil.get(renderRequest.getAttribute(OSPIcecapWebConstants.PARAM_SHOWBACK), "");
%>




<aui:container cssClass="osp OSPIcacap-web">
	<aui:form action = "<%= actionURL %>" method="post" name="fm">
		<aui:fieldset>
			<clay:label label="<%= LanguageUtil.get(request, "back") %>" href="<%= showback %>"/>
		</aui:fieldset>
		<aui:fieldset>
			<aui:input name="command" value="<%= action %>" type="hidden"></aui:input>
			<aui:input name="showback" value="<%= showback %>" type="hidden"></aui:input>
		</aui:fieldset>
		
		<aui:fieldset>
			<aui:row>
				<aui:col md="4">
					<aui:input name="dataTypeName" label="name" required="true" helpMessage="English only, under 32 characters"></aui:input>
				</aui:col>
				<aui:col md="2">
					<aui:input name="dataTypeVersion" label="version" required="true" helpMessage="x.x.x, x:integer"></aui:input>
				</aui:col>
				<aui:col md="2">
					<aui:input name="dataTypeExtension" label="extension" helpMessage="English only, under 8 characters"></aui:input>
				</aui:col>
			</aui:row>
				<aui:col md="12">
					<liferay-portlet:renderURL var="dataTypeStructureEditorURL" portletName="<%= OSPIcecapPortletKeys.DATATYPE_STRUCTURE_EDITOR_PORTLET_KEY %>">
						<portlet:param name="dataTypeId" value="0"/>
						<portlet:param name="mvcRenderCommandName" value="<%= OSPIcecapWebConstants.MVC_COMMAND_DATATYPE_STRUCTURE_EDITOR %>"/>
						<portlet:param name="showback" value="<%= themeDisplay.getURLCurrent() %>"/>
					</liferay-portlet:renderURL>
					<aui:button value="define-datatype-structure" href="<%= dataTypeStructureEditorURL %>"></aui:button>
				</aui:col>
			<aui:row>
			</aui:row>
			<aui:row>
				<aui:col md="11">
					<aui:input name="dataTypeDescription" type="textarea" localized="true" label="description"></aui:input>
				</aui:col>
			</aui:row>
		</aui:fieldset>
		<aui:fieldset>
			<aui:row>
				<aui:col md="12">
					<aui:input type="file" name="sampleFile" enctype = "multipart/form-data" helpMessage="sample-file-help"></aui:input>
				</aui:col>
			</aui:row>
		</aui:fieldset>
		<aui:button-row>
			<aui:button type="submit" value="<%= submitButtonLabel %>"></aui:button>
		</aui:button-row>	
	</aui:form>
</aui:container>