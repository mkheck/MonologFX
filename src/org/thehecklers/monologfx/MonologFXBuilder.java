package org.thehecklers.monologfx;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.ControlBuilder;
import javafx.util.Builder;


/**
 * Created with IntelliJ IDEA.
 * User: Mark Heckler (mark.heckler@gmail.com, @HecklerMark)
 * Date: 11/7/12
 * Time: 12:43 PM
 * To change this template use File | Settings | File Templates.
 *
 * Mods:
 * Date:
 * Desc:
 */
public class MonologFXBuilder<B extends MonologFXBuilder<B>> extends ControlBuilder<B> implements Builder<MonologFX> {
    private HashMap<String, Property> properties = new HashMap<>();
    private List<MonologFXButton> buttons = new ArrayList<>();
    private List<String> stylesheets = new ArrayList<>();

    
    protected MonologFXBuilder() {
    }

    public static MonologFXBuilder create() {
        return new MonologFXBuilder();
    }

    /**
     * Public method used to add a button to a MonologFX dialog.
     * 
     * @param BUTTON A MonologFXButton object.
     * 
     * @see MonologFXButton
     */
    public final MonologFXBuilder button(final MonologFXButton BUTTON) {
        //properties.put("button", new SimpleObjectProperty<>(BUTTON));
        buttons.add(BUTTON);
        return this;
    }

    public final MonologFXBuilder type(final MonologFX.Type TYPE) {
        properties.put("type", new SimpleObjectProperty<>(TYPE));
        return this;
    }

    public final MonologFXBuilder buttonAlignment(final MonologFX.ButtonAlignment ALIGNBUTTONS) {
        properties.put("alignbuttons", new SimpleObjectProperty<>(ALIGNBUTTONS));
        return this;
    }

    public final MonologFXBuilder message(final String MESSAGE) {
        properties.put("message", new SimpleStringProperty(MESSAGE));
        return this;
    }

    public final MonologFXBuilder modal(final boolean MODAL) {
        properties.put("modal", new SimpleBooleanProperty(MODAL));
        return this;
    }

    public final MonologFXBuilder titleText(final String TITLE_TEXT) {
        properties.put("titleText", new SimpleStringProperty(TITLE_TEXT));
        return this;
    }

    public final MonologFXBuilder stylesheet(final String STYLESHEET) {
        //properties.put("stylesheet", new SimpleStringProperty(STYLESHEET));
        stylesheets.add(STYLESHEET);
        return this;
    }


    @Override
    public MonologFX build() {
        final MonologFX CONTROL = new MonologFX();

        for (String key : properties.keySet()) {
            switch (key) {
//                case "button":
//                    CONTROL.addButton(((SimpleObjectProperty<MonologFXButton>) properties.get(key)).get());
//                    break;
                case "type":
                    CONTROL.setType(((ObjectProperty<MonologFX.Type>) properties.get(key)).get());
                    break;
                case "alignbuttons":
                    CONTROL.setButtonAlignment(((ObjectProperty<MonologFX.ButtonAlignment>) properties.get(key)).get());
                    break;
                case "message":
                    CONTROL.setMessage(((StringProperty) properties.get(key)).get());
                    break;
                case "modal":
                    CONTROL.setModal(((BooleanProperty) properties.get(key)).get());
                    break;
                case "titleText":
                    CONTROL.setTitleText(((StringProperty) properties.get(key)).get());
                    break;
//                case "stylesheet":
//                    CONTROL.addStylesheet(((StringProperty) properties.get(key)).get());
//                    break;
            }
        }

        for ( MonologFXButton mb : buttons ) {
            CONTROL.addButton(mb);
        }
        
        for ( String ss : stylesheets ) {
            CONTROL.addStylesheet(ss);
        }
        
        return CONTROL;
    }
}
