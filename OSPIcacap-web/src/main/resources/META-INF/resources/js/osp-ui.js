(function (root, factory) {
    if (typeof define === 'function' && define.amd) {
        define(['jquery', 'osp'], factory);
    } else if (typeof exports === 'object') {
        module.exports = factory(require('jquery', require('osp')));
    } else {
        root.returnExports = factory(root.jQuery, root.OSP);
    }
}(this, function ($, OSP) {
	if( !OSP ){
		OSP = {};
	}
	
	if( !OSP.UI ){
		OSP.UI = {};
	}
	
	let UI = OSP.UI;
	
	
	
    return UI;
}));