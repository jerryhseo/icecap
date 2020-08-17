package com.osp.icecap.web.datatype.admin.portlet;

import com.liferay.application.list.BasePanelApp;
import com.liferay.application.list.PanelApp;
import com.liferay.portal.kernel.model.Portlet;
import com.osp.icecap.constants.OSPIcecapPortletKeys;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
		 immediate = true,
		    property = {
		        "panel.app.order:Integer=300",
		        "panel.category.key=" + "OSPControlPanelCategories"
		    },
		    service = PanelApp.class
)
public class DataTypeAdminPanelApp extends BasePanelApp {

	@Override
	public String getPortletId() {
		return OSPIcecapPortletKeys.DATA_TYPE_ADMIN_PORTLET_KEY;
	}

	@Override
    @Reference(
        target = "(javax.portlet.name=" + OSPIcecapPortletKeys.DATA_TYPE_ADMIN_PORTLET_KEY + ")",
        unbind = "-"
    )
    public void setPortlet(Portlet portlet) {
        super.setPortlet(portlet);
    }
}
