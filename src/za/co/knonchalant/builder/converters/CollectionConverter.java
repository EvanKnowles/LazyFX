package za.co.knonchalant.builder.converters;

import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ComboBoxBase;
import javafx.scene.control.Label;
import javafx.stage.Window;
import za.co.knonchalant.builder.TaggedParameters;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Convert a value that represents an item in a collection.
 */
public class CollectionConverter extends BaseConverter<String> {
    @Override
    public Node convert(String object, boolean readOnly, TaggedParameters parameters, Window window) {
        if (readOnly) {
            return new Label(object);
        }

        Collection<String> values;
        if (isTagSet()) {
            values = (Collection<String>) parameters.get(getTag());
        } else {
            values = new ArrayList<>();
        }

        ComboBox<String> box = new ComboBox<>();
        box.getItems().addAll(values);
        box.setValue(object);

        return box;
    }

    @Override
    public String parse(Node node, boolean readOnly) {
        if (ComboBoxBase.class.isAssignableFrom(node.getClass())) {
            ComboBoxBase combo = (ComboBoxBase) node;
            return combo.getValue() == null ? "" : combo.getValue().toString();
        }

        return null;
    }
}
