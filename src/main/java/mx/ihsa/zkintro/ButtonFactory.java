/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ihsa.zkintro;

import org.zkoss.zul.Button;

/**
 * Generamos difrentes clases de botones de acuerdo a los estilos definidos
 * por Bootstrap
 * @author mrojas
 */
public class ButtonFactory {
    
    //http://www.zkoss.org/zk-bootstrap/#btn-groups-themes
    public static String BTN_DEFAULT = "btn-default";
    public static String BTN_PRIMARY = "btn-primary";
    public static String BTN_SUCCESS = "btn-success";
    public static String BTN_INFO = "btn-info";
    public static String BTN_WARNING = "btn-warning";
    public static String BTN_DANGER = "btn-danger";
    
    
    public static Button getDefaultButton(String label) {
        return getButton(BTN_DEFAULT, label);
    }
    
    public static Button getPrimaryButton(String label) {
        return getButton(BTN_PRIMARY, label);
    }
    
    public static Button getSuccessButton(String label) {
        return getButton(BTN_SUCCESS, label);
    }
    
    public static Button getInfoButton(String label) {
        return getButton(BTN_INFO, label);
    }
    
    
    public static Button getWarningButton(String label) {
        return getButton(BTN_WARNING, label);
    }
    
    public static Button getDangerButton(String label) {
        return getButton(BTN_DANGER, label);
    }
    
    public static Button getButton(String type, String label) {
        Button button = new Button(label);
        button.setSclass(type);
        
        return button;
    }
    
}
