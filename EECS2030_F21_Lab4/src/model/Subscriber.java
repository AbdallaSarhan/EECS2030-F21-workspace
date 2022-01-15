package model;

public class Subscriber extends Follower {
	
	
	int maxRecommendedVids;
	

	
	public Subscriber(String name, int maxChannelFollow, int maxRecommendedVids) {
		super(maxChannelFollow);
		
		this.nameOfFollower = name;
		this.releasedVideos = new String[maxRecommendedVids];
		this.maxRecommendedVids = maxRecommendedVids;
		this.norv = 0;
	}
	
	
	public void releasedVideo(String video) {
		this.releasedVideos[norv] = video;
		this.norv++;
		this.videoList = "";
		for(int i = 0; i < this.norv; i++) {
			if(i < this.norv-1) {
				this.videoList += this.releasedVideos[i] + ", ";
			}
			else {
				this.videoList += this.releasedVideos[i];
			}	
		}

}
		public void watch(String videoName, int watchTime) {
			for(int i = 0; i < this.norv; i ++) {
				if(releasedVideos[i].equals(videoName)) {
					for(int j = 0; j < this.norv; j++) {
						for(int l = 0; l < this.norv; l++) {
							if(videoName.equals(channelsFollowed[j].getReleasedVideosAt(l))) {
								channelsFollowed[j].passToMonitor(videoName, watchTime);
						}
						
						}
					}
					
					
				}
				}
		
	}

	

	
	public String toString() {
		String part1 = "";
		String part2 = "";
		if (this.nofc == 0 && this.norv == 0) {
			status = String.format("Subscriber %s follows no channels and has no recommended videos.", this.nameOfFollower);
		}
		if(this.nofc > 0) {
			part1 = String.format("Subscriber %s follows [%s]", this.nameOfFollower, this.channelList);
		}
		else {
			part1 = String.format("Subscriber %s follows no channels", this.nameOfFollower);
		}
		if(this.norv > 0) {
			part2 = String.format(" and is recommended <%s>.", this.videoList);
		}
		else {
			part2= String.format(" and has no recommended videos.");
		}
		this.status = part1 + part2;
		return status;
	}



	
}

