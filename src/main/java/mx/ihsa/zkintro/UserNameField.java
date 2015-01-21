/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ihsa.zkintro;

import org.zkoss.zul.Div;
import org.zkoss.zul.Label;
import org.zkoss.zul.Span;
import org.zkoss.zul.Textbox;

/**
 *
 * @author mrojas
 */
public class UserNameField extends Div {
    
    Textbox username = null;
    
    public UserNameField() {
        super();
        zkInit();
    }
    
    private void zkInit() {
        setClass("input-group");

        //Span is one of the most lightweight container to group child component 
        //for, say, assigning CSS or making more sophisticated layout. It is the 
        //same as HTML SPAN tag.
        // http://books.zkoss.org/wiki/ZK%20Component%20Reference/Containers/Span
        Span addOn = new Span();
        addOn.setClass("input-group-addon");
        addOn.setParent(this);
        
        Label arroba = new Label("@");
        arroba.setParent(addOn);
        
        username = new Textbox();
        username.setParent(this);
        username.setClass("form-control");
        username.setPlaceholder("Username");
    }
    
    public String getValue() {
        return username.getValue();
    }
}