package studybuddy;


public class QuestionMaker {
	Question[] questions;
	
	public Question[] getQuestions() {
		
		FileReader FR = new FileReader();
		
		questions = new Question[FR.lines];
		int i = 0;
		while(FR.fileHasNextLine()) {
			String str = FR.getNextLineOfFile();
			String[] s = str.split(";");
			Question q;
			if(s[0].equals("TF")) {
				q = new QuestionTF(s[1],s[2],Integer.parseInt(s[3]));
			}
			else if(s[0].equals("FB")) {
				q = new QuestionFB(s[1],s[2],Integer.parseInt(s[3]));
			}
			else {
				String[] choices= new String[Integer.parseInt(s[2])];
				for(int j = 0; j < Integer.parseInt(s[2]); j++) {
					choices[j] = s[3+j];
				}
				q = new QuestionMC(s[1],Integer.parseInt(s[2]),choices,s[3+Integer.parseInt(s[2])],Integer.parseInt(s[4+Integer.parseInt(s[2])]));
			}
			questions[i] = q;
			i++;
		}
		return questions;
	}
}
