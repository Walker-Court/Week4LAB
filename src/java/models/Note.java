/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.beans.*;
import java.io.Serializable;

/**
 *
 * @author WCour
 */
public class Note implements Serializable {
    
    public static final String PROP_SAMPLE_PROPERTY = "sampleProperty";
    
    private String title;
    private String content;
    
    private PropertyChangeSupport propertySupport;
    
    public Note() {
        propertySupport = new PropertyChangeSupport(this);
    }
    
    public String getTitle() {
        return title;
    }
    
    public void setText(String value) {
        String oldValue = title;
        title = value;
        propertySupport.firePropertyChange(PROP_SAMPLE_PROPERTY, oldValue, title);
    }
     public void setContent(String value) {
         String oldValue = content;
        content = value;
        propertySupport.firePropertyChange(PROP_SAMPLE_PROPERTY, oldValue, content);
    }

    public String getContent() {
       return content;
    }
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertySupport.addPropertyChangeListener(listener);
    }
    
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertySupport.removePropertyChangeListener(listener);
    }

   
    
}
