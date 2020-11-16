package studybuddy;

public class QuestionFB implements Question{

	String ques;
	String ans;
	int points;
	
	public QuestionFB() {
		ques = "";
		ans = "";
		points = 0;
	}
	
	public QuestionFB(String ques,String ans,int points) {
		this.ques = ques;
		this.ans = ans;
		this.points = points;
	}
	
	
	@Override
	public String getQuestion() {
		// TODO Auto-generated method stub
		return ques;
	}

	@Override
	public boolean isCorrect(String ans) {
		// TODO Auto-generated method stub
		if(ans.equals(this.ans)) {
			return true;
		}
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

	@Override
	public String typeOfQuestion() {
		// TODO Auto-generated method stub
		return "Fill in the Blank: ";
	}
	
}
