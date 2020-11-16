package studybuddy;

public interface Question {
	
	public String getQuestion();
	public boolean isCorrect(String ans);
	public String getCorrectAns();
	public int getPoints();
	public String typeOfQuestion();
}
