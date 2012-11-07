package org.thehecklers.monologfx;

import java.util.HashMap;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.Node;
import javafx.scene.control.ControlBuilder;
import javafx.util.Builder;


/**
 * Created with IntelliJ IDEA.
 * User: Mark Heckler (mark.heckler@gmail.com, @HecklerMark)
 * Date: 11/7/12
 * Time: 2:08 PM
 * To change this template use File | Settings | File Templates.
 * <p/>
 * Mods:
 * Date:
 * Desc:
 */
public class MonologFXButtonBuilder<B extends MonologFXButtonBuilder<B>> extends ControlBuilder<B> implements Builder<MonologFXButton> {
    private HashMap<String, Property> properties = new HashMap<>();

    protected MonologFXButtonBuilder() {
    }

    public static MonologFXButtonBuilder create() {
        return new MonologFXButtonBuilder();
    }

    public final MonologFXButtonBuilder type(final MonologFXButton.Type TYPE) {
        properties.put("type", new SimpleObjectProperty<>(TYPE));
        return this;
    }

    public final MonologFXButtonBuilder label(final String LABEL) {
        properties.put("label", new SimpleStringProperty(LABEL));
        return this;
    }

    public final MonologFXButtonBuilder icon(final Node ICON) {
        properties.put("icon", new SimpleObjectProperty<>(ICON));
        return this;
    }

    public final MonologFXButtonBuilder defaultButton(final boolean DEFAULTBUTTON) {
        properties.put("defaultButton", new SimpleBooleanProperty(DEFAULTBUTTON));
        return this;
    }

    public final MonologFXButtonBuilder cancelButton(final boolean CANCELBUTTON) {
        properties.put("cancelButton", new SimpleBooleanProperty(CANCELBUTTON));
        return this;
    }


    @Override
    public MonologFXButton build() {
        final MonologFXButton CONTROL = new MonologFXButton();

        for (String key : properties.keySet()) {
            switch (key) {
                case "type":
                    CONTROL.setType(((ObjectProperty<MonologFXButton.Type>) properties.get(key)).get());
                    break;
                case "label":
                    CONTROL.setLabel(((StringProperty) properties.get(key)).get());
                    break;
                case "icon":
                    CONTROL.setIcon(((ObjectProperty<Node>) properties.get(key)).get());
                    break;
                case "defaultButton":
                    CONTROL.setDefaultButton(((BooleanProperty) properties.get(key)).get());
                    break;
                case "cancelButton":
                    CONTROL.setCancelButton(((BooleanProperty) properties.get(key)).get());
                    break;
            }
        }

        return CONTROL;
    }
}
