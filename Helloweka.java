package weka_api;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import weka.core.Instances;
import weka.clusterers.SimpleKMeans;
import weka.clusterers.ClusterEvaluation;
import weka.core.converters.ConverterUtils.DataSource;
public class Helloweka {
	public static void main(String[] args) throws java.lang.Exception {
		try {
			helloweka1 hk = new helloweka1();
			hk.hellowekamethod();
		}
		catch(Exception e) {
			
		}
	}
}
class helloweka1{
	File file;
    static JPanel p = new JPanel();
    static JPanel p1 = new JPanel();
    static JFrame f = new JFrame();

    private static JTextField pass;

    private static JLabel cluster;
    private static JScrollPane sp;
    private static JButton  Submit;
    private static JButton  Submitup;
    String dataset;
    String dataset1;
    int clusterNumber;
    void hellowekamethod() throws java.lang.Exception{	
        f.setTitle("Kmeans Clustering Using WEKA");
        f.setSize(900, 600);
        p.setBackground(Color.CYAN);
        p.setLayout(null);
        f.add(p);
        
        cluster = new JLabel("No. of Clusters");
        cluster.setBounds(20, 3, 100, 100);
        p.add(cluster);

        pass = new JTextField(); 
		pass.setBounds(120,40, 150, 25);
		p.add(pass);

        JFileChooser file1 = new JFileChooser();
        file1.setBounds(10, 50, 600, 350);
        p.add(file1);
        
        Submit = new JButton("Add the Training Set");
		Submit.setBounds(250,400,200,25);
		Submit.addActionListener(new ActionListener(){	
			@Override
			public void actionPerformed(ActionEvent e) {
                dataset = file1.getSelectedFile().getAbsolutePath();
                try {
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
			}
		});
		p.add(Submit);         		
		Submitup = new JButton("Add Test set and Run");
		Submitup.setBounds(250,450,200,25);
		Submitup.addActionListener(new ActionListener(){	
			@Override
			public void actionPerformed(ActionEvent e) {
			    clusterNumber = Integer.parseInt(pass.getText());
                dataset1 = file1.getSelectedFile().getAbsolutePath();
                p1.setBackground(Color.yellow);
                try {
					kmeansrun();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
			}
		});
		p.add(Submitup);
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
	void kmeansrun() throws java.lang.Exception{
    	DataSource source = new DataSource(dataset);
		Instances data = source.getDataSet();
		SimpleKMeans model = new SimpleKMeans();
		model.setNumClusters(clusterNumber);
		model.buildClusterer(data);
		System.out.println(model);
		
		JTextArea t1 = new JTextArea(1,200);
        sp = new JScrollPane(t1);
        sp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        sp.setPreferredSize(new Dimension(650,500));
        t1.append(String.valueOf(model));
        p1.add(sp);
        f.setContentPane(p1);
        f.setVisible(true);
                			
		ClusterEvaluation clseval = new ClusterEvaluation();
		DataSource source1 = new DataSource(dataset1);
		Instances data1 = source1.getDataSet();
		
		clseval.setClusterer(model);
		clseval.evaluateClusterer(data1);
		System.out.print("No. of Clusters : "+clseval.getNumClusters());
		f.setVisible(true);
    }
}