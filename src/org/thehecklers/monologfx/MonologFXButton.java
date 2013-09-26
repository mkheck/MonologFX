package org.thehecklers.monologfx;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * @author Mark Heckler (mark.heckler@gmail.com, @HecklerMark)
 */
public class MonologFXButton {

    /**
     * Type of button, with several built-in options and three custom ones.
     */
    public enum Type {
        OK, CANCEL, ABORT, RETRY, IGNORE, YES, NO, CUSTOM1, CUSTOM2, CUSTOM3
    }
    private static HashMap<Type, String> defaultLabels;

    static {
        defaultLabels = new HashMap<>();
        ResourceBundle res = ResourceBundle.getBundle("org/thehecklers/monologfx/MonologFXButton", Locale.getDefault());
        defaultLabels.put(Type.OK, res.getString("OK"));
        defaultLabels.put(Type.CANCEL, res.getString("CANCEL"));
        defaultLabels.put(Type.ABORT, res.getString("ABORT"));
        defaultLabels.put(Type.RETRY, res.getString("RETRY"));
        defaultLabels.put(Type.IGNORE, res.getString("IGNORE"));
        defaultLabels.put(Type.YES, res.getString("YES"));
        defaultLabels.put(Type.NO, res.getString("NO"));
        defaultLabels.put(Type.CUSTOM1, res.getString("CUSTOM1"));
        defaultLabels.put(Type.CUSTOM2, res.getString("CUSTOM2"));
        defaultLabels.put(Type.CUSTOM3, res.getString("CUSTOM3"));
    }

    private Type type = MonologFXButton.Type.OK;    // Defaults to OK(-type) button
    private String label = "";
    private Node icon;
    private boolean defaultButton = false;
    private boolean cancelButton = false;

    /**
     * Default constructor for a MonologFX button. Plain button,
     * no label or icon and no default or cancel designation(s).
     */
    public MonologFXButton() {
        // Refactor.
    }

    /**
     * Returns the type of this button.
     *
     * @return type MonologFXButton.Type designation.
     * @see Type
     */
    public Type getType() {
        return type;
    }

    /**
     * Sets the type of this button.
     *
     * @param type MonologFXButton.Type designation.
     * @see Type
     */
    public void setType(Type type) {
        this.type = type;
        this.label = defaultLabels.get(type);
    }

    /**
     * Returns the appropriate button label according to the following rules:
     * <p/>
     * If the developer specifies a label, it returns that text.
     * <p/>
     * If not, the button checks for a resource with i18n (internationalization)
     * text to use for this type of button. If it finds the file and the key
     * corresponding to this button type, it returns the i18n value.
     * <p/>
     * If none of the above conditions are met, it returns default text.
     *
     * @return label String consisting of the button's text.
     */
    public String getLabel() {
        if (!label.isEmpty()) {
            return label;
        } else {
            String labelToReturn = defaultLabels.get(getType());
            return labelToReturn;
        }
    }

    /**
     * Sets the label text for the button.
     * <p/>
     * To assign a shortcut key, simply place an underscore character ("_")
     * in front of the desired shortcut character.
     *
     * @param label String consisting of the desired button text.
     */
    public void setLabel(String label) {
        this.label = label;
    }

    /**
     * Returns the graphic file (if one is assigned) for this button.
     *
     * @return icon Node consisting of the button's graphic element.
     */
    public Node getIcon() {
        return icon;
    }

    /**
     * Sets the graphic for use on the button, either alone or with text.
     * Graphic format must be .png, .jpg (others?) supported by ImageView.
     *
     * @param iconFile String containing the location and name of a graphic file
     *                 (.png, .jpg) for use as an icon on the button face.
     * @see ImageView
     */
    public void setIcon(String iconFile) {
        try {
            this.icon = new ImageView(new Image(getClass().getResourceAsStream(iconFile)));
        } catch (Exception e) {
            System.err.println("Exception trying to load button icon:" + e.getMessage());
        }
    }

    /**
     * Indicates if this button is designated as the "default" button.
     *
     * @return defaultButton Boolean.
     */
    public boolean isDefaultButton() {
        return defaultButton;
    }

    /**
     * Designates this button as the "default" button - or not.
     *
     * @param defaultButton Boolean.
     */
    public void setDefaultButton(boolean defaultButton) {
        this.defaultButton = defaultButton;
    }

    /**
     * Indicates if this button is designated as the "cancel" button.
     *
     * @return cancelButton Boolean.
     */
    public boolean isCancelButton() {
        return cancelButton;
    }

    /**
     * Designates this button as the "cancel" button - or not.
     *
     * @param cancelButton Boolean.
     */
    public void setCancelButton(boolean cancelButton) {
        this.cancelButton = cancelButton;
    }
}
