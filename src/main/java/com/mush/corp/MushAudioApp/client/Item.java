package com.mush.corp.MushAudioApp.client;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.dom.client.Text;
import com.google.gwt.dom.client.Element;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.vaadin.polymer.paper.PaperCardElement;
import com.google.gwt.dom.client.ImageElement;

public class Item {

    private final DivElement element;
   

    interface ItemUiBinder extends UiBinder<DivElement, Item> {
    }

    private static ItemUiBinder ourUiBinder = GWT.create(ItemUiBinder.class);

    @UiField PaperCardElement card;
    @UiField Element number;



    public String getNumber() {
        return number.getInnerText();
    }

    public void setNumber(String s) {
        number.setInnerText(s);
    }

	public String getCard() {
		return card.getHeading();
	}




	public void setCard(String s) {
		card.setHeading(s);
	}




	public Item() {
        element = ourUiBinder.createAndBindUi(this);


    }




    public DivElement getElement() {
        return element;
    }
}
