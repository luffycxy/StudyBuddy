package studybuddy;

public class QuestionMC implements Question{

	String ques;
	int numberOfChoices;
	String[] choices;
	String ans;
	int points;
	
	public QuestionMC() {
		ques = "";
		numberOfChoices = 0;
		choices = null;
		ans = "";
		points = 0;
	}
	
	public QuestionMC(String ques,int numberOfChoices,String[] choices,String ans,int points) {
		this.ques = ques;
		this.points = points;
		this.numberOfChoices = numberOfChoices;
		this.ans = ans;
		this.choices = new String[numberOfChoices];
		for(int i = 0; i < choices.length; i++) {
			this.choices[i] = choices[i];
		}
	}
	
	
	@Override
	public String getQuestion() {
		// TODO Auto-generated method stub
		return ques;
	}
	
	@Override
	public boolean isCorrect(String ans) {
		// TODO Auto-generated method stub
		if(ans.equals(this.ans)||ans.toUpperCase().equals(this.ans))
			return true;
		return false;
	}

	@Override
	public String getCorrectAns() {
		// TODO Auto-generated method stub
		return ans;
	}

	@Override
	public int getPoints() {
		// TODO Auto-generated method stub
		return points;
	}

	public String[] getChoices() {
		return choices;
	}

	@Override
	public String typeOfQuestion() {
		// TODO Auto-generated method stub
		return "Mutiple Choice: ";
	}
	
	
}
