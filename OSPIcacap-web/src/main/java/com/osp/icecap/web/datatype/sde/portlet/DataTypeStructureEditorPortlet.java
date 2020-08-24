package com.osp.icecap.web.datatype.sde.portlet;


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
        "com.liferay.portlet.scopeable=true",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"javax.portlet.display-name=Data Type Structure Editor",
		"javax.portlet.expiration-cache=0",
        "javax.portlet.init-param.portlet-title-based-navigation=true",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/DataType/structure-editor-portlet/view.jsp",
		"javax.portlet.name=" + OSPIcecapPortletKeys.DATATYPE_STRUCTURE_EDITOR_PORTLET_KEY,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user",
		"javax.portlet.supports.mime-type=text/html",
        "com.liferay.portlet.add-default-resource=true"
	},
	service = Portlet.class
)
public class DataTypeStructureEditorPortlet extends MVCPortlet {
}