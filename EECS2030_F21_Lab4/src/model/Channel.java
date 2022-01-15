package model;

public class Channel {
	private String channelName;
	private int maxFollowers;
	private int maxUploads;
	private String update;
	private String[] videos;
	private int nov; // num of videos
	private String releasedVideos;
	private Follower[] followers;
	private int nof; // num of followers;
	private String followerList;


	public Channel(String channelName, int maxFollowers, int maxUploads) {

		this.channelName = channelName;
		this.maxFollowers = maxFollowers;
		this.maxUploads = maxUploads;
		this.videos = new String[maxUploads];
		this.nov = 0;
		this.followers = new Follower[this.maxFollowers];
		this.nof = 0;
		

		this.update = String.format("%s released no videos and has no followers.", this.channelName);

	}
	
	public void passToMonitor(String videoName, int watchTime) {
		for(int i =0; i < this.nof; i++) {
			if(followers[i] instanceof Monitor) {
				followers[i].watch(videoName, watchTime, this.channelName);
			}
		}
		
		
	}
	
	public int getMaxUploads() {
		return this.maxUploads;
	}
	
	public String getChannelName() {
		return this.channelName;
	}
	// "Cafe Music BGM released <Monday Jazz> and has no followers."
	
	public void releaseANewVideo(String video) {
		this.videos[this.nov] = video;
		this.nov++;
		for(int i = 0; i < this.nof; i++) {
			followers[i].releasedVideo(video);
			
		}
		
	}
	public String getReleasedVideosAt(int i) {
//		String rv = "";
//		for(int j = 0; j < this.nov; j++) {
//			if(this.videos[j] == this.videos[i]) {
//				rv = this.videos[j];
//			}
//			
//			
//		}
		return this.videos[i];
	}
	
//	public String getReleasedVideos() {
//		return 
//	}
	
	public void follow(Follower f) {
		this.followers[this.nof] = f;
		this.nof++;
		f.followChannel(this);
	
	}
	
	public void unfollow(Follower f) {
		for(int i = 0; i < this.nof; i++) {
			if(this.followers[i] == f) {
				this.followers[i] = null;
				this.nof--;
				this.followers[i] = this.followers[i+1];
				f.unfollowChannel(this);
			}
			else {}
		}
	}

	public String toString() {
		String part1 = "";
		String part2 = "";
		if(this.nov == 0 && this.nof == 0) {
			this.update = String.format("%s released no videos and has no followers.", this.channelName);
		}
	
		 if(this.nov > 0){
			this.releasedVideos = "";
			for(int j = 0; j < this.nov; j++) {
				
				if(j < this.nov - 1) {
					this.releasedVideos += this.videos[j] + ", " ;
				}
				else {
					this.releasedVideos += this.videos[j]; 
				}

			}

		 part1 = String.format("%s released <%s>", this.channelName, this.releasedVideos);
		}
		else {
			part1 = String.format("%s released no videos", this.channelName);
		}
	
		if(this.nof > 0) {
			this.followerList = "";
			for(int i = 0; i < this.nof; i++) {
				if(this.followers[i] instanceof Monitor) {
					if(i < this.nof -1) {

					this.followerList += "Monitor " + this.followers[i].getNameOfFollower() + ", ";
					}
					else {
						this.followerList += "Monitor " + this.followers[i].getNameOfFollower();
					}
				}
					else if(this.followers[i] instanceof Subscriber) {
						if(i < this.nof- 1) {
							
						this.followerList += "Subscriber " + this.followers[i].getNameOfFollower() + ", ";
					}
						else {
							this.followerList += "Subscriber " + this.followers[i].getNameOfFollower();
						}
				
			}
			}
			 part2 = String.format(" and is followed by [%s].", this.followerList);
			
		}
		else {
			part2 = String.format(" and has no followers.");
			
		}
		this.update = part1 + part2;
		return this.update;

	}
}
