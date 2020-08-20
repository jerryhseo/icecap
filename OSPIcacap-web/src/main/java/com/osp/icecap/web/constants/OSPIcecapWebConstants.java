package com.osp.icecap.web.constants;

public class OSPIcecapWebConstants {
	public static final String JSP_PATH_EDIT_DATATYPE="/DataType/admin-portlet/edit_datatype.jsp";
	public static final String JSP_PATH_DATATYPE_ADMIN_VIEW="/DataType/admin-portlet/view-datatype-list.jsp";
	public static final String JSP_PATH_DATATYPE_DISPLAY_VIEW="/DataType/admin-portlet/view.jsp";
	public static final String JSP_PATH_DATATYPE_STRUCTURE_EDITOR="/DataType/structure-editor-portlet/view.jsp";
	public static final String JSP_FOLDER_PATH_DATATYPE_PORTLET_ASSET = "/DataType/asset/";
	
	// Parameter Names
	public static final String PARAM_MVCPATH = "mvcPath";
	public static final String PARAM_DATATYPE = "dataType";
	public static final String PARAM_DATATYPE_ID = "dataTypeId";
	public static final String PARAM_DATATYPE_NAME = "dataTypeName";
	public static final String PARAM_DATATYPE_VERSION = "dataTypeVersion";
	public static final String PARAM_DATATYPE_DESCRIPTION = "dataTypeDescription";
	public static final String PARAM_COMMAND = "command";
	public static final String PARAM_SHOWBACK = "showback";
	public static final String PARAM_REDIRECT = "redirect";
	public static final String PARAM_START_INDEX = "startIndex";
	public static final String PARAM_ITEMS_PER_PAGE = "itemsPerPage";
	public static final String PARAM_DATATYPE_LIST = "dataTypeList";
	
	//Attribute Names
	public static final String ATTR_DATATYPE = "dataType";
	public static final String ATTR_HTML_UTIL = "HtmlUtil";
	public static final String ATTR_STRING_UTIL = "StringUtil";
	
	//MVC Command names
	public static final String MVC_COMMAND_DATATYPE_ADMIN_VIEW_LIST = "/datatype/admin/view_list";
	public static final String MVC_COMMAND_DATATYPE_ADMIN_EDIT = "/datatype/admin/edit_datatype";
	public static final String MVC_COMMAND_DATATYPE_DISPLAY_VIEW_LIST = "/datatype/display/view_list";
	public static final String MVC_COMMAND_DATATYPE_STRUCTURE_EDITOR = "/datatype/structure/editor";
	
	//Default values
	public static final int DEFAULT_START_INDEX = 0;
	public static final int DEFAULT_ITEMS_PER_PAGE = 10;
	public static final int ZERO = 0;
}
