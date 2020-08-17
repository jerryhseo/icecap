<%@page import="com.osp.icecap.service.DataTypeLocalServiceUtil"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.osp.icecap.model.DataType"%>
<%@ include file="../../init.jsp" %>

<%
	String portletWindowState = (String)request.getAttribute("portletWindowState");

	int pagenationSize = 10;
	int startItem = 0;
	List<DataType> dataTypes = DataTypeLocalServiceUtil.getDataTypes(startItem, startItem+pagenationSize-1);
	if( dataTypes == null || dataTypes.size() == 0 )
		System.out.println("No datatypes were found.");
%>

<div class="osp container OSPIcacap-web">
	<div class="row">
		<h1><liferay-ui:message key="new-data-type"/></h1>
		<clay:button label="new-data-type" />
	</div>
	<div class="row">
		<div class="col-md-4">
			<div class="osp-table">
					<div id="headerButton" style="text-align: right; margin-bottom: 5px;">
					</div>
					<div class="table-header">
						<div class="header__item"><liferay-ui:message key="data-type-name"/>/<liferay-ui:message key="version"/></div>
					</div>
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
