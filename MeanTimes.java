public enum MeanTimes {
	ROUTER_MEAN_CRASH (1000),
	ROUTER_MEAN_RECOV (30),
	WS_MEAN_CRASH (500),
	WS_MEAN_RECOV (60),
	DS_MEAN_CRASH (500),
	DS_MEAN_RECOV (30),
	DD_MEAN_CRASH (150),
	DD_MEAN_RECOV (15),
	DEVICES (9);
	
	public final int minutes;
	
	MeanTimes(int minutes){
		this.minutes = minutes;
	}
	
	public int getMeanTime(){
		return minutes;
	}


}
