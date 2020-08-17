package com.osp.icecap.web.datatype.admin.portlet;


import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.osp.icecap.constants.OSPIcecapPortletKeys;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

/**
 * @author DELL
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.hidden",
        "com.liferay.portlet.scopeable=true",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"javax.portlet.display-name=Data Type Administration",
		"javax.portlet.expiration-cache=0",
        "javax.portlet.init-param.portlet-title-based-navigation=true",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/DataType/admin/view.jsp",
		"javax.portlet.name=" + OSPIcecapPortletKeys.DATA_TYPE_ADMIN_PORTLET_KEY,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=administrator",
		"javax.portlet.supports.mime-type=text/html",
        "com.liferay.portlet.add-default-resource=true"
	},
	service = Portlet.class
)
public class OSPDataTypeAdminPortlet extends MVCPortlet {
}