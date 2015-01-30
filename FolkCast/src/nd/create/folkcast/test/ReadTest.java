package nd.create.folkcast.test;

import nd.create.folkcast.model.Feed;
import nd.create.folkcast.model.FeedMessage;
import nd.create.folkcast.utils.RSSFeedParser;

public class ReadTest {
	
	
	  public static void main(String[] args) 
	  {
	    RSSFeedParser parser = new RSSFeedParser("http://downloads.bbc.co.uk/podcasts/radio4/fricomedy/rss.xml");
	    Feed feed = parser.readFeed();
	    System.out.println(feed);
	    
	    for (FeedMessage message : feed.getMessages()) {
	      System.out.println(message);

	    }

	  }
	} 

