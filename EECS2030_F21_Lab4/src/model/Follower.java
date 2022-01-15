package model;

public class Follower {

	String status;
	String nameOfFollower;
	//String monitorName;
	int maxChannelsFollowing;
	Channel[] channelsFollowed;
	int nofc; // num of followed channels
	String channelList;
	String[] releasedVideos;
	String videoList;
	int norv; // num of released videos
	


	public Follower(int max) {
		this.maxChannelsFollowing = max;
		this.channelsFollowed = new Channel[this.maxChannelsFollowing];
		this.nofc = 0;
		
		

	}
	
	public void watch(String videoName, int watchTime, String channelName) {
		
	}

	public void followChannel(Channel c) {
		this.channelsFollowed[this.nofc] = c;
		this.nofc++;
		this.channelList = "";
		for(int i = 0; i < this.nofc; i++) {
			if(i < this.nofc - 1) {
				this.channelList += this.channelsFollowed[i].getChannelName() + ", ";
			}
			else {
				this.channelList += this.channelsFollowed[i].getChannelName();
			}

		}


	}
	public void unfollowChannel(Channel c) {
		for(int i = 0; i < this.nofc; i++) {
			if(this.channelsFollowed[i] == c) {
				this.channelsFollowed[i] = null;
				this.nofc--;
				this.channelsFollowed[i] = this.channelsFollowed[i+1];
				this.channelList = "";
				for(int j = 0; j < this.nofc; j++) {
					if(j < this.nofc - 1) {
						this.channelList += this.channelsFollowed[j].getChannelName() + ", ";
					}
					else {
						this.channelList += this.channelsFollowed[j].getChannelName();
					}

				}

			}
		}
	}
	public void releasedVideo(String video) {


}
	

	
	public String getNameOfFollower() {
		return nameOfFollower;
	}
	

	public String toString() {


		return status;
	}
	
	
	
	
	
	

}
