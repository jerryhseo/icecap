<%@page import="com.osp.icecap.web.constants.OSPIcecapWebConstants"%>
<%@page import="com.osp.icecap.model.DataType"%>
<%@include file="../../init.jsp"%>

<%
	DataType dataType = (DataType)request.getAttribute(OSPIcecapWebConstants.ATTR_DATATYPE);
	dataType = dataType.toEscapedModel();
%>

<h3>Preview</h3>
<dl>
	<dt>Name</dt>
	<dd><%= dataType.getName() %></dd>
</dl>