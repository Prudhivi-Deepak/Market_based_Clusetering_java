
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
public class KMeans {
	static List<Record> data = new ArrayList<Record>();
	List<Cluster> clusters = new ArrayList<Cluster>();
	Map<Cluster, List<Record>> clusterRecords = new HashMap<Cluster, List<Record>>();
	int count1,count2;
	public static void main(String[] args) {
		int clusterNumber = 3;
		KMeans demo = new KMeans();
		String filename = "C:\\Users\\user\\Documents\\weka_files\\Mall_Customerscopy.csv";
		File file = new File(filename);
		try {
			Scanner i = new Scanner(file);
			i.next();
			while(i.hasNext()) {
				String data1 = i.next();
				String[] values =data1.split(",");
				Record record = new Record(Integer.parseInt(values[0]) , Integer.parseInt(values[1]),
								Integer.parseInt(values[2]) , Integer.parseInt(values[3]),
								Integer.parseInt(values[4]) , Integer.parseInt(values[5]),
								Integer.parseInt(values[6]) , Integer.parseInt(values[7]));
				data.add(record);
			}
			i.close();
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
		}
		demo.initiateClusterAndCentroid(clusterNumber);
		demo.printRecordInformation();
		demo.printClusterInformation();
	}
	private void initiateClusterAndCentroid(int clusterNumber) {
		int counter = 1;
		Iterator<Record> iterator = data.iterator();
		Record record = null;	
		while(iterator.hasNext()) {
			record = iterator.next();
			if(counter <= clusterNumber) {
				record.setClusterNumber(counter);
				initializeCluster(counter, record);
				counter++;
			}else {
				System.out.println(record);
				System.out.println("* Cluster Information *");
				for(Cluster cluster : clusters) {
					System.out.println(cluster);
				}
				System.out.println("*******");
                double minDistance = Integer.MAX_VALUE;
                Cluster whichCluster = null; 
                for(Cluster cluster : clusters) {
                	double distance = cluster.calculateDistance(record);
                	System.out.println(distance);
                	if(minDistance > distance) {
                		minDistance = distance;
                		whichCluster = cluster;
                	}
                }
                record.setClusterNumber(whichCluster.getClusterNumber());
				whichCluster.updateCentroid(record);
				clusterRecords.get(whichCluster).add(record);
			}
			System.out.println("* Cluster Information *");
			for(Cluster cluster : clusters) {
				System.out.println(cluster);
			}
			System.out.println("*******");
		}
	}
	private void initializeCluster(int clusterNumber, Record record) {
		Cluster cluster = new Cluster(clusterNumber,record.getChannel(),record.getRegion(),record.getFresh(),
										record.getMilk(),record.getGrocery(),record.getFrozen(),
										record.getDetergents_Paper(),record.getDelicassen());
		clusters.add(cluster);
		List<Record> clusterRecord = new ArrayList<Record>();
		clusterRecord.add(record);
		clusterRecords.put(cluster, clusterRecord);

	}
	private void printRecordInformation() {
		   System.out.println("** Each Record INFORMATIN ***");
		   int i=0;
		   for(Record record : data) {
			   System.out.println(record);
			   i++;
		   }
		   System.out.println("no. of cluster values = "+i);
	}
	private void printClusterInformation() {
	   System.out.println("** FINAL CLUSTER INFORMATIN ***");
	   for (Map.Entry<Cluster, List<Record>> entry : clusterRecords.entrySet())  {
        System.out.println("Key = " + entry.getKey() + 
                         ", Value = " + entry.getValue()); 
	   }
	}
}