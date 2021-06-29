package pakiet.arkadiuszzimny.retrofitxmltest;

import org.simpleframework.xml.ElementList;

import java.util.ArrayList;
import java.util.List;

public class ItemContainer {

    @ElementList(name = "item", inline = true, required = false)
    private List<Item> item = new ArrayList<>();

    public List<Item> getItems() {
        return item;
    }

    public void setItems(List<Item> items) {
        this.item = items;
    }

    @Override
    public String toString() {
        return "ItemContainer{" +
                "items=" + item +
                '}';
    }
}
