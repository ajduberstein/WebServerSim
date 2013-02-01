public class Device {
	private String item_type;
	private int id_num;
	private boolean active;
	private int total_downtime;	
	
	Device(int id, String item_type){
		this.item_type = item_type;
		this.id_num = id;
		this.active = true;
		this.total_downtime = 0;
	}
	

	public String getItem_type() {
		return item_type;
	}

	public void setItem_type(String item_type) {
		this.item_type = item_type;
	}

	public int getId_num() {
		return id_num;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public int getTotal_downtime() {
		return total_downtime;
	}

	public void bumpTotal_downtime(int total_downtime) {
		this.total_downtime += total_downtime;
	}
}
