/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ihsa.zkintro;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Borderlayout;
import org.zkoss.zul.Button;
import org.zkoss.zul.Center;
import org.zkoss.zul.Div;
import org.zkoss.zul.Hbox;
import org.zkoss.zul.Image;
import org.zkoss.zul.Label;
import org.zkoss.zul.North;
import org.zkoss.zul.Panel;
import org.zkoss.zul.Panelchildren;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Toolbarbutton;
import org.zkoss.zul.Vbox;
import org.zkoss.zul.Vlayout;
import org.zkoss.zul.West;
import org.zkoss.zul.Window;

/**
 * Ventana principal de la aplicación
 * @author mrojas
 */
public class Main extends Window {
    //A window is, like HTML DIV tag, used to group components. Unlike other 
    //components, a window has the following characteristics.
    //
    //  * A window is an owner of an ID space.Any component contained in a window, 
    //    including itself, could be found by use of Component.getFellow(String), 
    //    if it is assigned with an identifier.
    //  * A window could be overlapped, popup, and embedded.
    //  * A window could be a modal dialog.
    //http://books.zkoss.org/wiki/ZK%20Component%20Reference/Containers/Window
    
    //The layout component is a nested component. The parent component is 
    //borderlayout, and its children components include north, south, center, 
    //west, and east. All extra space is placed in the center area.
    //http://books.zkoss.org/wiki/ZK_Component_Reference/Layouts/Borderlayout
    private Borderlayout mainLayout;
    
    //A center region of a border layout and only allows one component as its 
    // child.
    // http://books.zkoss.org/wiki/ZK%20Component%20Reference/Layouts/Borderlayout/Center
    private Center centerPanel;
    
    //A west region of a border layout and only allows one component as its child.
    //http://books.zkoss.org/wiki/ZK%20Component%20Reference/Layouts/Borderlayout/West
    private West westPanel;

    //A north region of a border layout and only allows one component as its child.
    //http://books.zkoss.org/wiki/ZK%20Component%20Reference/Layouts/Borderlayout/North
    private North northPanel;
    
    public Main() {
        zkInit();
    }

    /**
     * Inicialización global
     */
    private void zkInit() {
        
        //alto y ancho de la página es del 100%
        setWidth("100%");
        setHeight("100%");
        // sin borde
        setBorder("0");
        
        buildMainLayout();
    }
    
    private void buildMainLayout() {
        mainLayout = new Borderlayout();
        mainLayout.setParent(this);
        
        northPanel = buildNorth();
        northPanel.setParent(mainLayout);
        
        centerPanel = buildCenter();
        mainLayout.appendChild(centerPanel);
        
        westPanel = buildWest();
        mainLayout.appendChild(westPanel);
    }
    
    private North buildNorth() {
        northPanel = new North();
        northPanel.setSize("90px");
        northPanel.setBorder("0");
        
        //Div is one of the most lightweight container to group child component 
        //for, say, assigning CSS or making more sophisticated layout. It is the 
        //same as HTML DIV tag. 
        //http://books.zkoss.org/wiki/ZK_Component_Reference/Containers/Div
        Div container = new Div();
        container.setParent(northPanel);
        
        //An image component is used to display an image at the browser.
        // http://books.zkoss.org/wiki/ZK%20Component%20Reference/Essential%20Components/Image
        Image logo = new Image("http://www.zkoss.org/zkdemo/images/ZK-Logo.gif");
        
        //A label component represents a piece of text.
        // http://books.zkoss.org/wiki/ZK%20Component%20Reference/Essential%20Components/Label
        Label label = new Label("ZK Project");
        
        Div internal = new Div();
        internal.setStyle("float:right");
        
        //A textbox is used to let users input textual data.
        // http://books.zkoss.org/wiki/ZK%20Component%20Reference/Input/Textbox
        Textbox searchBox = new Textbox();
        searchBox.setParent(internal);
                
        //You could assign a label and an image to a button by the label and 
        // image properties.
        // http://books.zkoss.org/wiki/ZK_Component_Reference/Essential_Components/Button
        Button searchBtn = new Button("Search");
        searchBtn.setParent(internal);
        //clase de bootstrap
        searchBtn.setSclass("btn-info");
        
        logo.setParent(container);
        label.setParent(container);
        internal.setParent(container);
        
        return northPanel;
    }

    
    private West buildWest() {
        westPanel = new West();
        // sin borde
        westPanel.setBorder("0");
        // 200 pixeles de ancho
        westPanel.setWidth("200px");
        // puede ajustarse el ancho del panel
        westPanel.setSplittable(true);
        westPanel.setMargins("0,5,0,0");
        westPanel.setHflex("true");
        westPanel.setVflex("true");
        
        //The vlayout component is a simple vertical oriented layout. Added 
        //components will be placed underneath each other in a column.
        //http://books.zkoss.org/wiki/ZK_Component_Reference/Layouts/Vlayout
        Vlayout container = new Vlayout();
        container.setSpacing("0");
        
        // Panel is a container that has specific functionality and structural 
        // components that make it the perfect building block for application-oriented 
        // user interfaces. 
        //http://books.zkoss.org/wiki/ZK_Component_Reference/Containers/Panel
        Panel panel = new Panel();
        panel.setCollapsible(true);
        panel.setWidth("100%");
        panel.setTitle("Navigation");
        panel.setParent(container);
        panel.setSclass("panel-primary");
        
        Panelchildren children = new Panelchildren();
        children.setStyle("padding:5px");
        children.setParent(panel);
        
        // The vbox component is used to create a vertically oriented box. Added 
        // components will be placed underneath each other in a column.
        // http://books.zkoss.org/wiki/ZK_Component_Reference/Layouts/Vbox
        Vbox botonera = new Vbox();
        botonera.setParent(children);
        botonera.setClass("btn-group-vertical");
        botonera.setWidth("100%");

        // The behavior of Toolbarbutton is similar to the button except the 
        // appearance is different
        // http://books.zkoss.org/wiki/ZK_Component_Reference/Essential_Components/Toolbarbutton
        Toolbarbutton btn1 = new Toolbarbutton("Home");
        btn1.setParent(botonera);
        btn1.setSclass("btn-info");
        btn1.setWidth("100%");
        
        
        container.setParent(westPanel);
        return westPanel;
    }
    
    private Center buildCenter() {
        centerPanel = new Center();
        centerPanel.setHflex("true");
        centerPanel.setBorder("0");
        
        // The hbox component is used to create a horizontally oriented box. 
        // Each component placed in the hbox will be placed horizontally in a row.
        // http://books.zkoss.org/wiki/ZK_Component_Reference/Layouts/Hbox
        Hbox container = new Hbox();
        container.setParent(centerPanel);
        
        Button boton = new Button();
        boton.setTooltiptext("Don't click on me ;)");
        boton.setImage("go-home.svg");
        // atrapamos el evento de click en el botón
        boton.addEventListener(Events.ON_CLICK, new EventListener<Event>() {
            public void onEvent(Event t) throws Exception {
                // mostramos una ventana de alerta
                Clients.alert("You've clicked on the button.");
            }
        });
        container.appendChild(boton);
      
        // Componente a la medida
        UserNameField userNameField = new UserNameField();
        userNameField.setParent(container);
        
        // boton generado por medio de una clase "Factory" hecha a la medida
        Button btnSave = ButtonFactory.getPrimaryButton("Save User");
        btnSave.setParent(container);
        
        Button btnDelete = ButtonFactory.getDangerButton("Delete User");
        btnDelete.setParent(container);
        
        return centerPanel;
    }    
}