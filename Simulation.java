
public class Simulation {
	public static final int MINUTES = 525600;
	public static void main(String[] args) {
		ServerSystem sys = new ServerSystem();
		for(int min = 0; min < MINUTES; min++){
			sys.update();
		} 
		sys.printSystemState();
		System.out.println("TOTAL SYSTEM DOWNTIME: " + sys.getTotal_time_down());
	}
}
