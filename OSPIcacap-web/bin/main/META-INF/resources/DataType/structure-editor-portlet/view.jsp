<%@page import="com.osp.icecap.web.constants.OSPIcecapWebConstants"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.osp.icecap.model.DataType"%>
<%@ include file="../../init.jsp" %>

<%
	int dataTypeId = GetterUtil.getInteger(renderRequest.getAttribute(OSPIcecapWebConstants.PARAM_DATATYPE_ID));
	System.out.println("Data Type ID: " + dataTypeId);
%>

<div class="osp container OSPIcacap-web">
</div>

<script>
</script>
