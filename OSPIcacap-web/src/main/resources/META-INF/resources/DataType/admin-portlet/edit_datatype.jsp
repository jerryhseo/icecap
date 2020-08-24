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

<%
	DataType dataType = (DataType)renderRequest.getAttribute(OSPIcecapWebConstants.PARAM_DATATYPE);
	String action = OSPIcecapActionKeys.UPDATE_DATATYPE;
	String submitButtonLabel = LanguageUtil.get(request, "update");
	if( Validator.isNull(dataType)){
		action = OSPIcecapActionKeys.ADD_DATATYPE;
		submitButtonLabel = LanguageUtil.get(request, "add");
	}
	
	String showback = GetterUtil.get(renderRequest.getAttribute(OSPIcecapWebConstants.PARAM_SHOWBACK), "");
%>

<portlet:actionURL var="editDataTypeURL" name="<%= OSPIcecapWebConstants.MVC_COMMAND_DATATYPE_ADMIN_EDIT %>">
</portlet:actionURL>

<aui:container cssClass="osp OSPIcacap-web">
	<aui:form action = "<%= editDataTypeURL %>" method="post" name="fm">
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
			<aui:row>
				<aui:col md="11">
					<aui:input name="dataTypeDescription" type="textarea" localized="true" label="description"></aui:input>
				</aui:col>
			</aui:row>
		</aui:fieldset>
		<aui:fieldset>
			<aui:row>
				<aui:col md="12">
					<aui:input type="file" name="uploadSampleFile" required="true" enctype = "multipart/form-data"></aui:input>
				</aui:col>
			</aui:row>
		</aui:fieldset>
		<aui:button-row>
			<aui:button type="submit" value="<%= submitButtonLabel %>"></aui:button>
		</aui:button-row>	
	</aui:form>
</aui:container>