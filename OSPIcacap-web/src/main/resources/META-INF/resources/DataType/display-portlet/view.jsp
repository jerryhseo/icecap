<%@page import="com.osp.icecap.web.constants.OSPIcecapWebConstants"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.osp.icecap.model.DataType"%>
<%@ include file="../../init.jsp" %>

<%
	String portletWindowState = (String)request.getAttribute("portletWindowState");

	int itemsPerPage = GetterUtil.getInteger(renderRequest.getAttribute(OSPIcecapWebConstants.PARAM_ITEMS_PER_PAGE));
	int startIndex = GetterUtil.getInteger(renderRequest.getAttribute(OSPIcecapWebConstants.PARAM_START_INDEX));
	List<DataType> dataTypes = (List<DataType>)renderRequest.getAttribute(OSPIcecapWebConstants.PARAM_DATATYPE_LIST);
	if( dataTypes == null || dataTypes.size() == 0 )
		System.out.println("No datatypes were found.");
%>

<portlet:renderURL var="editDataTypeRender">
	<portlet:param name="dataTypeId" value="0"/>
	<portlet:param name="mvcRenderCommandName" value="<%= OSPIcecapWebConstants.MVC_COMMAND_DATATYPE_ADMIN_EDIT %>"/>
</portlet:renderURL>

<div class="osp container OSPIcacap-web">
	<div class="row">
		<div class="col-md-12">
			<aui:button icon="plus" value="<%= LanguageUtil.get(request, "new-data-type") %>" href="<%= editDataTypeRender %>"/>
		</div>
	</div>
	<div class="row">
		<div class="col-md-4">
			<div class="osp-table">
					<div id="headerButton" style="text-align: right; margin-bottom: 5px;">
					</div>
					<c:if test="${!empty dataTypes}">
						<div class="table-header">
							<div class="header__item"><liferay-ui:message key="data-type-name"/>/<liferay-ui:message key="version"/></div>
						</div>
					</c:if>
					<div class="table-content">
						<c:choose>
							<c:when test="${!empty dataTypes}">
								<c:forEach items="${dataTypes}" var="dataType">
									<div class="table-row" id="portTypeTr_${dataType.typeId}">
										<div class="table-data">${dataType.name} v. ${dataType.version}</div>
									</div>
								</c:forEach>
							</c:when>
							<c:otherwise>
								<div class="table-row">
									<div class="table-data">
										<liferay-ui:message key="no-datatype-were-found"/>
									</div>
								</div>
							</c:otherwise>
						</c:choose>
					</div>
				</div>
		</div>
		<div class="col-md-8">
			An information viewer will be here!
		</div>
	</div>
</div>

<script>
</script>
