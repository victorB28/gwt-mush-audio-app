package com.mush.corp.MushAudioApp.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

import com.vaadin.polymer.Polymer;
import com.vaadin.polymer.elemental.Function;
import com.vaadin.polymer.paper.PaperHeaderPanelElement;
import com.vaadin.polymer.paper.PaperDrawerPanelElement;
import com.vaadin.polymer.paper.PaperToolbarElement;
import com.vaadin.polymer.paper.PaperIconButtonElement;
import com.vaadin.polymer.paper.PaperButtonElement;
import com.vaadin.polymer.paper.PaperCardElement;
import com.vaadin.polymer.paper.PaperDialogElement;
import com.vaadin.polymer.paper.PaperTabsElement;
import com.vaadin.polymer.paper.PaperTabElement;
import com.vaadin.polymer.iron.IronSelectorElement;
import com.vaadin.polymer.iron.IronIconElement;
import com.vaadin.polymer.iron.IronPagesElement;
import java.util.Arrays;


public class mushaudioapp implements EntryPoint {

	  public void onModuleLoad() {


	    Polymer.importHref("paper-styles/demo-pages.html");
		  
		
	    Polymer.importHref(Arrays.asList(	
	    		"iron-icons/iron-icons.html",
	                PaperHeaderPanelElement.SRC,
	                PaperTabsElement.SRC,
	                PaperDialogElement.SRC,
	                PaperCardElement.SRC,
	                PaperTabElement.SRC,
	                PaperDrawerPanelElement.SRC,
	                PaperIconButtonElement.SRC,
	                IronIconElement.SRC,
	                IronPagesElement.SRC,
	                PaperButtonElement.SRC,
	                IronSelectorElement.SRC,
	                PaperToolbarElement.SRC
	    		),
	    		new Function() {
	      public Object call(Object arg) {
	        // The app is executed when all imports succeed.
	        startApplication();
	        return null;
	      }
	    });
	    

	  }

	  private void startApplication() {
	    RootPanel.get().add(new Main());
	  }
	}











