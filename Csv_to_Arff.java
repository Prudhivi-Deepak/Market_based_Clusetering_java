package weka_api;
import weka.core.Instances;
import weka.core.converters.ArffSaver;
import weka.core.converters.CSVLoader;
import java.io.File;
public class Csv_to_Arff {
	public static void main(String[] args) throws Exception {
		CSVLoader loader = new CSVLoader();
		loader.setSource(new File("C:\\Users\\user\\Documents\\weka_files\\Mall_Customerscopy.csv"));
		Instances data = loader.getDataSet();
		
		ArffSaver saver = new ArffSaver();
		saver.setInstances(data);
		saver.setFile(new File("C:\\Users\\user\\Documents\\weka_files\\Mall_Customerscopy.arff"));
		saver.writeBatch();
		
	}

}
