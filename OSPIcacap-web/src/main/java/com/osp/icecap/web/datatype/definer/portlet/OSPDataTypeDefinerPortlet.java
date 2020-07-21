package com.osp.icecap.web.datatype.definer.portlet;


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
		"com.liferay.portlet.display-category=category.osp",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=OSPDataTypeDefiner",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/DataType/Definer/view.jsp",
		"javax.portlet.name=" + OSPIcecapPortletKeys.OSPDATATYPEDEFINER,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class OSPDataTypeDefinerPortlet extends MVCPortlet {
}