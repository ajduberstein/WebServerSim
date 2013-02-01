
public class Simulation {
	public static final int MINUTES = 525600;
	public static void main(String[] args){
		ServerSystem sys = new ServerSystem();
		for (int run = 0; run < 10; run++){
			for(int min = 0; min < MINUTES; min++){
				sys.update();
			} 
			System.out.println("TOTAL SYSTEM DOWNTIME: " + sys.getTotal_time_down());
			sys.reset();
		}
	}
}