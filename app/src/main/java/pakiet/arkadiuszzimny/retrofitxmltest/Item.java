package pakiet.arkadiuszzimny.retrofitxmltest;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.ElementMap;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;

@Root(name="item", strict = false)
public class Item {

    @Path("item")
    @Element(name = "description")
    private String description;

    @Path("item")
    @Element(name = "guid")
    private String guid;

    @Path("item")
    @Element(name = "link")
    private String link;

    @Path("item")
    @Element(name = "pubDate")
    private String pubDate;

    @Path("item")
    @Element(name = "title")
    private String title;

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Item{" +
                "description='" + description + '\'' +
                ", guid='" + guid + '\'' +
                ", link='" + link + '\'' +
                ", pubDate='" + pubDate + '\'' +
                ", title='" + title + '\'' +
                '}';
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
