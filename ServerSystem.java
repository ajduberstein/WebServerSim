import java.util.ArrayList;
import java.util.Random;

public class ServerSystem {
	private int total_time_down_;
	private Device[] devices_;
	private Random r;
	
	public ServerSystem(){
		r = new Random(187);
		total_time_down_ = 0;
		devices_ = new Device[]{new Device(1, "ROUTER"), 
				new Device(2, "ROUTER"), new Device(1, "WEB SERVER"),
				new Device(2, "WEB SERVER"), new Device(1, "DATA SERVER"), 
				new Device(2, "DATA SERVER"), new Device(1, "DATA DISK"), 
				new Device(2, "DATA DISK"), new Device(3, "DATA DISK")};
		}
	
	public void printSystemState(){
		for (int i = 0; i < 9; i++){
			System.out.println(
					devices_[i].getItem_type() + " " + devices_[i].getId_num()
					+ " DOWNTIME: " + devices_[i].getTotal_downtime());
		}
	}
	
	public void update(){
		double recovProbability;
		double downProbability;
		for (int i = 0; i < 9; i++){
			//CASE 1 - Device is down
			if (devices_[i].isActive() == false){
				//Determine which device is down
				if (devices_[i].getItem_type() == "WEB SERVER"){
					recovProbability = 1./MeanTimes.WS_MEAN_RECOV.getMeanTime();
				}
				else if (devices_[i].getItem_type() == "DATA SERVER"){
					recovProbability = 1./MeanTimes.DS_MEAN_RECOV.getMeanTime();
				}
				else if (devices_[i].getItem_type() == "ROUTER"){
					recovProbability = 1./MeanTimes.ROUTER_MEAN_RECOV.getMeanTime();
				}
				else{
					recovProbability = 1./MeanTimes.DD_MEAN_RECOV.getMeanTime();
				}
				//Determine whether the device has recovered.
				if (r.nextDouble() <= recovProbability){
					devices_[i].setActive(true);
				}
				else{
					devices_[i].bumpTotal_downtime(1);
				}
			}
			//CASE 2 - Device is active
			else{
				//Determine whether the device will fail				
				if (devices_[i].getItem_type() == "WEB SERVER"){
					downProbability = 1./MeanTimes.WS_MEAN_CRASH.getMeanTime();
				}
				else if (devices_[i].getItem_type() == "DATA SERVER"){
					downProbability = 1./MeanTimes.DS_MEAN_CRASH.getMeanTime();
				}
				else if (devices_[i].getItem_type() == "ROUTER"){
					downProbability = 1./MeanTimes.ROUTER_MEAN_CRASH.getMeanTime();
				}
				else{
					downProbability = 1./MeanTimes.DD_MEAN_CRASH.getMeanTime();
				}
				if (r.nextDouble() <= downProbability){
					devices_[i].setActive(false);
					devices_[i].bumpTotal_downtime(1);
				}
			}
			//Finally, check if the system is down
			if(allDown("WEB SERVER") || allDown("DATA SERVER") || allDown ("DATA DISK") || allDown("ROUTER")){
				total_time_down_++;
			}
	
		}
	}
	
	public int getTotal_time_down(){
		return total_time_down_;
	}
	
	public boolean allDown(String id){
		ArrayList<Device> list = new ArrayList<Device>();
		for (int i = 0; i < 9; i++){
			if(devices_[i].getItem_type() == id){
				list.add(devices_[i]);
			}
		}
		int down_items = 0;
		for(Device d : list){
			if(d.isActive() == false){
				down_items++;
			}
		}
		return list.size() == down_items;
	}
}
