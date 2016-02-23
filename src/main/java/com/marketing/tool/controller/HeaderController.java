package com.marketing.tool.controller;

import org.apache.tiles.AttributeContext;
import org.apache.tiles.preparer.ViewPreparer;
import org.apache.tiles.request.Request;


public class HeaderController implements ViewPreparer {

	
	@Override
	public void execute(Request tilesContext, AttributeContext attributeContext) {
		/*attributeContext.putAttribute(
	            "message",
	            new Attribute("This is the value added by the ViewPreparer"));*/
		//List<String> scopes= tilesContext.getAvailableScopes();
		tilesContext.getContext(Request.REQUEST_SCOPE).put("message","from tiles preparer");
		
	}
	
	
}