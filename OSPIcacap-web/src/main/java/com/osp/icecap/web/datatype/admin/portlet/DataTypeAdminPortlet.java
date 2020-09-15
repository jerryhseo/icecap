package com.osp.icecap.web.datatype.admin.portlet;


import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.osp.icecap.constants.OSPIcecapPortletKeys;
import com.osp.icecap.web.constants.OSPIcecapWebConstants;

import java.io.IOException;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author DELL
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.osp",
        "com.liferay.portlet.scopeable=true",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"javax.portlet.display-name=Data Type Administration",
		"javax.portlet.expiration-cache=0",
        "javax.portlet.init-param.portlet-title-based-navigation=true",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/DataType/admin-portlet/view-datatype-list.jsp",
		"javax.portlet.name=" + OSPIcecapPortletKeys.DATATYPE_ADMIN_PORTLET_KEY,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=administrator,power-user,user",
		"javax.portlet.supports.mime-type=text/html",
        "com.liferay.portlet.add-default-resource=true"
	},
	service = Portlet.class
)
public class DataTypeAdminPortlet extends MVCPortlet {
	
	@Reference(
			target="(&(javax.portlet.name="+OSPIcecapPortletKeys.DATATYPE_ADMIN_PORTLET_KEY + ")(mvc.command.name="+OSPIcecapWebConstants.MVC_COMMAND_DATATYPE_ADMIN_VIEW_LIST+"))"
	)
	private MVCRenderCommand defaultRenderer;

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		
		String viewPath = defaultRenderer.render(renderRequest, renderResponse);
		
		super.include(viewPath, renderRequest, renderResponse);
	}
}