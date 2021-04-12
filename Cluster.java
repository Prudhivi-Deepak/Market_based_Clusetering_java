public class Cluster {
	private int ChannelCentroid;	
	private int RegionCentroid;
	private int FreshCentroid;
	private int MilkCentroid;
	private int GroceryCentroid;	
	private int FrozenCentroid;
	private int Detergents_PaperCentroid;
	private int DelicassenCentroid;
	private int clusterNumber;
	
	public Cluster(int clusterNumber, int ChannelCentroid, int RegionCentroid, int FreshCentroid,
					int MilkCentroid, int GroceryCentroid, int FrozenCentroid,
					int Detergents_PaperCentroid, int DelicassenCentroid) {
		super();
		this.clusterNumber = clusterNumber;
		this.ChannelCentroid = ChannelCentroid;
		this.RegionCentroid = RegionCentroid;
		this.FreshCentroid = FreshCentroid;
		this.MilkCentroid = MilkCentroid;
		this.GroceryCentroid = GroceryCentroid;
		this.FrozenCentroid = FrozenCentroid;
		this.Detergents_PaperCentroid = Detergents_PaperCentroid;
		this.DelicassenCentroid = DelicassenCentroid;
		
	}
	
	public int getChannelCentroid() {
		return ChannelCentroid;
	}
	public void setChannelCentroid(int channelCentroid) {
		ChannelCentroid = channelCentroid;
	}
	public int getRegionCentroid() {
		return RegionCentroid;
	}
	public void setRegionCentroid(int regionCentroid) {
		RegionCentroid = regionCentroid;
	}
	public int getFreshCentroid() {
		return FreshCentroid;
	}
	public void setFreshCentroid(int freshCentroid) {
		FreshCentroid = freshCentroid;
	}
	public int getMilkCentroid() {
		return MilkCentroid;
	}
	public void setMilkCentroid(int milkCentroid) {
		MilkCentroid = milkCentroid;
	}
	public int getGroceryCentroid() {
		return GroceryCentroid;
	}
	public void setGroceryCentroid(int groceryCentroid) {
		GroceryCentroid = groceryCentroid;
	}
	public int getFrozenCentroid() {
		return FrozenCentroid;
	}
	public void setFrozenCentroid(int frozenCentroid) {
		FrozenCentroid = frozenCentroid;
	}
	public int getDetergents_PaperCentroid() {
		return Detergents_PaperCentroid;
	}
	public void setDetergents_PaperCentroid(int detergents_PaperCentroid) {
		Detergents_PaperCentroid = detergents_PaperCentroid;
	}
	public int getDelicassenCentroid() {
		return DelicassenCentroid;
	}
	public void setDelicassenCentroid(int delicassenCentroid) {
		DelicassenCentroid = delicassenCentroid;
	}
	public int getClusterNumber() {
		return clusterNumber;
	}
	public void setClusterNumber(int clusterNumber) {
		this.clusterNumber = clusterNumber;
	}
	@Override
	public String toString() {	
		return "\nCluster [ClusterNumber= " + clusterNumber + ", ChannelCentroid=" + ChannelCentroid + ", RegionCentroid="
		+ RegionCentroid + ", FreshCentroid=" + FreshCentroid + "MilkCentroid=" + MilkCentroid + ", GroceryCentroid=" +
		GroceryCentroid + ", FrozenCentroid=" + FrozenCentroid + ", Detergents_PaperCentroid=" + Detergents_PaperCentroid + ", DelicassenCentroid=" + DelicassenCentroid +"]";
	}
	
	// Euclidean distance calculation
	public double calculateDistance(Record record) {
		return Math.sqrt(Math.pow((getChannelCentroid() - record.getChannel()), 2) + 
						Math.pow((getRegionCentroid() - record.getRegion()), 2) + 
						Math.pow((getFreshCentroid() - record.getFresh()), 2) + 
						Math.pow((getMilkCentroid() - record.getMilk()), 2) + 
						Math.pow((getGroceryCentroid() - record.getGrocery()), 2) + 
						Math.pow((getFrozenCentroid() - record.getFrozen()), 2) + 
						Math.pow((getDetergents_PaperCentroid() - record.getDetergents_Paper()), 2)+
						Math.pow((getDelicassenCentroid() - record.getDelicassen()), 2));
	}

	public void updateCentroid(Record record) {
		setChannelCentroid((getChannelCentroid() + record.getChannel())/ 2) ;
		setRegionCentroid((getRegionCentroid() + record.getRegion())/ 2) ;
		setFreshCentroid((getFreshCentroid() + record.getFresh())/2) ;
		setMilkCentroid((getMilkCentroid() + record.getMilk())/ 2) ;
		setGroceryCentroid((getGroceryCentroid() + record.getGrocery())/2) ;
		setFrozenCentroid((getFrozenCentroid() + record.getFrozen())/2)  ;
		setDetergents_PaperCentroid((getDetergents_PaperCentroid() + record.getDetergents_Paper())/ 2);
		setDelicassenCentroid((getDelicassenCentroid() + record.getDelicassen())/2);
		
		
	}

}
