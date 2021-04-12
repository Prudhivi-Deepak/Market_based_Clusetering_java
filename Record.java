
public class Record {
	private int Channel;	
	private int Region;
	private int Fresh;
	private int Milk;
	private int Grocery;	
	private int Frozen;
	private int Detergents_Paper;
	private int Delicassen;
	private int clusterNumber;
	
	public Record(int Channel, int Region, int Fresh,int Milk, int Grocery, int Frozen, int Detergents_Paper,int Delicassen) {
		super();
		this.Channel = Channel;
		this.Region = Region;
		this.Fresh = Fresh;
		this.Milk = Milk;
		this.Grocery = Grocery;
		this.Frozen = Frozen;
		this.Detergents_Paper = Detergents_Paper;
		this.Delicassen = Delicassen;
		
	}
	public int getChannel() {
		return Channel;
	}
	public void setChannel(int channel) {
		Channel = channel;
	}
	public int getRegion() {
		return Region;
	}
	public void setRegion(int region) {
		Region = region;
	}
	public int getFresh() {
		return Fresh;
	}
	public void setFresh(int fresh) {
		Fresh = fresh;
	}
	public int getMilk() {
		return Milk;
	}
	public void setMilk(int milk) {
		Milk = milk;
	}
	public int getGrocery() {
		return Grocery;
	}
	public void setGrocery(int grocery) {
		Grocery = grocery;
	}
	public int getFrozen() {
		return Frozen;
	}
	public void setFrozen(int frozen) {
		Frozen = frozen;
	}
	public int getDetergents_Paper() {
		return Detergents_Paper;
	}
	public void setDetergents_Paper(int detergents_Paper) {
		Detergents_Paper = detergents_Paper;
	}
	public int getDelicassen() {
		return Delicassen;
	}
	public void setDelicassen(int delicassen) {
		Delicassen = delicassen;
	}
	public int getClusterNumber() {
		return clusterNumber;
	}
	public void setClusterNumber(int clusterNumber) {
		this.clusterNumber = clusterNumber;
	}
	@Override
	public String toString() {
		return "\n\tRecord [ ClusterNumber= "+ clusterNumber +" Channel=" + Channel + ", Region=" + Region + ", Fresh=" + Fresh + ", Milk="
		+ Milk + "Grocery=" + Grocery + ", Frozen=" + Frozen + ", Detergents_Paper=" + Detergents_Paper + ", Delicassen=" + Delicassen +
		 "]";
	
	}


}
