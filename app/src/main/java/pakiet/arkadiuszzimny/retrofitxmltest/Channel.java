package pakiet.arkadiuszzimny.retrofitxmltest;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.ArrayList;
import java.util.List;

@Root(name = "channel", strict = false)
public class Channel {

    @ElementList(inline = true, required = false)
    public List<Item> items = new ArrayList<>();

    @Element(name = "copyright", required = false)
    public String copyright;

    @Element(name = "description", required = false)
    public String description;


    public Channel(List<Item> items, String copyright, String description) {
        this.items = items;
        this.copyright = copyright;
        this.description = description;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Channel{" +
                "items=" + items +
                ", copyright='" + copyright + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
