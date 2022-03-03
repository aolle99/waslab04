package twitter;

import java.io.IOException;
import java.util.Date;

import twitter4j.FilterQuery;
import twitter4j.ResponseList;
import twitter4j.StallWarning;
import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.StatusListener;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;

public class SimpleClient {
	/*
	public static void main(String[] args) throws Exception {
		
		final Twitter twitter = new TwitterFactory().getInstance();
		
		Date now = new Date();
		String latestStatus = "Hey @fib_was, we've just completed task #4 [timestamp: "+now+"]";
		Status status = twitter.updateStatus(latestStatus);
		System.out.println("Successfully updated the status to: " + status.getText());   
		
		
		ResponseList<Status> list  = twitter.getUserTimeline("fib_was");
		long id = list.get(0).getId();
		System.out.println(list.get(0).getText());
		twitter.retweetStatus(id);
		
	}*/
	public static void main(String[] args) throws TwitterException, IOException{
	    StatusListener listener = new StatusListener(){
	        public void onStatus(Status status) {
	            System.out.println(status.getUser().getName() + " : " + status.getText());
	        }
	        @Override
	        public void onDeletionNotice(StatusDeletionNotice statusDeletionNotice) {}
	        @Override
	        public void onTrackLimitationNotice(int numberOfLimitedStatuses) {}
	        @Override
	        public void onException(Exception ex) {
	            ex.printStackTrace();
	        }
			
	        @Override
			public void onScrubGeo(long arg0, long arg1) {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void onStallWarning(StallWarning arg0) {
				// TODO Auto-generated method stub
				
			}
	    };
	    TwitterStream twitterStream = new TwitterStreamFactory().getInstance();
	    twitterStream.addListener(listener);
	    
	    String[] keywords = {"#covid19"};
	    FilterQuery filterQuery = new FilterQuery();
	    filterQuery.track(keywords);
	    twitterStream.filter(filterQuery);
	}

}
