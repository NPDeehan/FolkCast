package nd.create.folkcast.model;

import java.util.ArrayList;
import java.util.List;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/*
 * Stores an RSS feed
 */
public class Feed {

  final String title;
  final String link;
  final String description;
  final String language;
  final String copyright;
  final String pubDate;
  final String author;
  final String image;

  final List<FeedMessage> entries = new ArrayList<FeedMessage>();

  public Feed(String title, String link, String description, String language,
      String copyright, String pubDate, String author, String image) {
    this.title = title;
    this.link = link;
    this.description = description;
    this.language = language;
    this.copyright = copyright;
    this.pubDate = pubDate;
    this.author = author;
    this.image = image;
  }

  public List<FeedMessage> getMessages() {
    return entries;
  }

  public String getTitle() {
    return title;
  }
  
 public StringProperty getTitleAsStringProperty(){
		StringProperty thisString = new SimpleStringProperty(title);
		
		return thisString;
	}

  public String getLink() {
    return link;
  }

  public String getDescription() {
    return description;
  }

  public String getLanguage() {
    return language;
  }

  public String getCopyright() {
    return copyright;
  }

  public String getPubDate() {
    return pubDate;
  }
  
  public String getAuthor(){
	  return author;
  }

  @Override
  public String toString() {
    return "Feed [copyright=" + copyright + ", description=" + description
        + ", language=" + language + ", link=" + link + ", pubDate="
        + pubDate + ", title=" + title + "]";
  }

} 

