package ro.usv.rf;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 double[][] learningSet = FileUtils.readFromFile("in.txt");     
		 FileUtils.writeLearningSetToFile("out.csv", normalizeLearningSet(learningSet)); 

	}
	
	private static double[][] normalizeLearningSet(double[][] learningSet) {
		double[][] normalizedLearningSet = new double[learningSet.length][learningSet[0].length];

		
		
		for (int i = 0; i < learningSet.length; i++) {
			for (int j = 0; j < learningSet[i].length; j++) {
				normalizedLearningSet[i][j] = (learningSet[i][j] - minimColoana(learningSet, j))
						/ (maximColoana(learningSet, j) - minimColoana(learningSet, j));
			}
		}

		return normalizedLearningSet;
	}
	
	private static double maximColoana(double[][] learningSet,int indice) {
		double maxim=-9999999;
		for(int i=0;i<learningSet.length;i++) {
			if(learningSet[i][indice]>=maxim) {
				maxim = learningSet[i][indice];
			}
		}
		return maxim;
	}
	
	private static double minimColoana(double[][] learningSet,int indice) {
		double minim=99999999;
		for(int i=0;i<learningSet.length;i++) {
			if(learningSet[i][indice]<=minim) {
				minim = learningSet[i][indice];
			}
		}
		return minim;
	}
}
