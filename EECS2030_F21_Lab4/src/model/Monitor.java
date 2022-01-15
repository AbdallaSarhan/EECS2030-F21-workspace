package model;

public class Monitor extends Follower {
	
	int[] watchTime;
	int counterForWatchTime;
	int[] views;
	int counterForViews;
	double[] totalWatchTime;
	int counterForTotWatchTime;
	String modifiedChannel;
	double totalWatchTimeAmount;
	int maxWatchTime;
	String channelTracker = "Cafe Music BGM";
	

	
	public Monitor(String monitorName, int maxChannelsFollowing) {
		super(maxChannelsFollowing);
		this.nameOfFollower = monitorName;
		this.watchTime = new int[maxChannelsFollowing];
		this.totalWatchTime = new double[maxChannelsFollowing];
		this.totalWatchTime = new double[maxChannelsFollowing];
		this.views = new int[100];
		this.modifiedChannel = "";
	}
	
	
	
	public void watch(String videoName, int watchTime, String channelName) {
						
					if(this.maxWatchTime < watchTime) {
						this.maxWatchTime = watchTime;
					
					}
					else {}
					
					this.watchTime[this.counterForWatchTime] = watchTime;

					
					this.totalWatchTime[this.counterForTotWatchTime] = watchTime;
					counterForTotWatchTime++;
					this.totalWatchTimeAmount = 0;
					for(int i = 0; i < this.counterForTotWatchTime; i++) {
						this.totalWatchTimeAmount += this.totalWatchTime[i];
					}
					views[this.counterForViews]++;
					
					this.counterForViews++;
					// 1, max watch time: 20, avg watch time: 20.00}
					//for(int i = 0; i < this.nofc; i++) {}
						// modifiedChannel = "";
					
						if(this.channelTracker.equals(channelName)) {
							modifiedChannel = String.format("%s {#views: %d, max watch time: %d, avg watch time: %.2f}",
									channelName ,this.counterForViews, this.maxWatchTime, this.totalWatchTimeAmount/this.counterForViews);
						}
						else {
							modifiedChannel += String.format("%s {#views: %d, max watch time: %d, avg watch time: %.2f}",
									channelName ,this.counterForViews, this.maxWatchTime, this.totalWatchTimeAmount/this.counterForViews);
						}
					
					channelTracker = channelName;
				
//					modifiedChannel += String.format("%s {#views: %d, max watch time: %d, avg watch time: %.2f}",
//								channelName ,this.counterForViews, this.maxWatchTime, this.totalWatchTimeAmount/this.counterForViews);
					counterForWatchTime++;
					
					for(int i = 0; i < this.nofc; i++) {
						this.channelList = "";
						if(this.channelsFollowed[i].getChannelName().equals(channelName)) {
							
						}
						else {
							if(i < this.nofc - 1) {
								this.channelList += this.channelsFollowed[i].getChannelName() + ", ";
							}
							else {
								this.channelList += this.channelsFollowed[i].getChannelName();
						}
						
						}
					}
					
				}
							
			//this.channelsFollowed[i].getChannelName() +
		
		
	


	public String toString() {
		String part1 = "";
		String part2 = "";
		// need loop to see weather the monitor has statistics or not
		
		if(this.nofc == 0) {
			status = String.format("Monitor %s follows no channels.", this.getNameOfFollower());
		}
		else {
			if(this.nofc > 0 && this.counterForViews == 0){
				status = String.format("Monitor %s follows [%s].", this.getNameOfFollower(), this.channelList);
			}
			else {
				for(int i= 0; i < this.nofc; i++) {
				
				}
				if(this.counterForViews > 0) {
				status = String.format("Monitor %s follows [", this.getNameOfFollower());
				
				if(this.channelList == "") {
					part1 += modifiedChannel;
				}
				else {
					part1 += modifiedChannel + ", " + this.channelList;
				}
					
				
				}
				else {
					part1 += this.channelList;
				}    
				status += part1 + "].";
			}
			
			
			
		}
	
		

		return status;
	}
}
