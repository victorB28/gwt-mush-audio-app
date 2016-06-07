package com.mush.corp.MushAudioApp.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.uibinder.client.UiField;

import com.vaadin.polymer.paper.PaperButtonElement;
import com.vaadin.polymer.paper.PaperTabElement;
import com.vaadin.polymer.iron.IronPagesElement;
import com.vaadin.polymer.iron.IronSelectorElement;

import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;
		
import java.util.List;
import java.util.ArrayList;
		
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.Window;

public class Main extends Composite {
  interface MainUiBinder extends UiBinder<HTMLPanel, Main> {
  }

  private static MainUiBinder ourUiBinder = GWT.create(MainUiBinder.class);
  
  @UiField IronPagesElement pages;
  @UiField IronSelectorElement contactSection;
  @UiField PaperButtonElement btnDates,btnContact;
  @UiField PaperTabElement galleriaTab,serviciosTab,paquetesTab;

  private List<Item> contactosList = new ArrayList<>() ;
  
  public Main() {
    initWidget(ourUiBinder.createAndBindUi(this));
    
 


    
    galleriaTab.addEventListener("click", e ->{
    	pages.select("galleria");
    	
    });
    serviciosTab.addEventListener("click", e ->{
    	pages.select("servicios");
    	
    });
    paquetesTab.addEventListener("click", e ->{
    	pages.select("paquetes");
    	
    });
    
    btnDates.addEventListener("click", e ->{
    });
    
    btnContact.addEventListener("click", e ->{
    	fetchDataFromServer();
    	
   	
    }); 
  }
  
 private void fetchDataFromServer() {
      
      try {
           
          RequestBuilder rb = new RequestBuilder(
               RequestBuilder.GET, "/contacto.json");
           
          rb.setCallback(new RequestCallback() {
              @Override
              public void onResponseReceived(Request request, Response response) {
                  parseJsonData(response.getText());
              }
              @Override
              public void onError(Request request, Throwable exception) {
                  Window.alert("Error occurred" + exception.getMessage());
              }
          });
          rb.send();
           
      }
      catch (RequestException e) {
          Window.alert("Error occurred" + e.getMessage());
      }
  }
  
	private void parseJsonData(String json) {
    	
    	JSONValue vendedores = JSONParser.parseLenient(json);
    	
    	JSONObject vendedoresObjt = vendedores.isObject();
    	
    	JSONArray arregloVendedores = vendedoresObjt.get("contactos").isArray();
    	
    	if (arregloVendedores != null) {

    		for (int i=0; i<arregloVendedores.size(); i++) {
    			
    			JSONObject productObj = arregloVendedores.get(i).isObject();
    			
    			String name = productObj.get("name").isString().stringValue();
    			String phone = productObj.get("phone").isString().stringValue();
    			
    			addItem(name,phone);
    						                
    			
    		}
    		
    		
    		
    	}
    }
  
	
    private void addItem(String nombre, String telefono) {
        Item item = new Item();
        item.setCard(nombre);
        item.setNumber(telefono);
        contactSection.appendChild(item.getElement());
        
        contactosList.add(item);
    }
  
  
}