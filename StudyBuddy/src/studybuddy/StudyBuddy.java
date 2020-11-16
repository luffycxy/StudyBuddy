package studybuddy;

import java.util.Scanner;

public class StudyBuddy{
	
	Question[] questions;
	int points;
	int correctAns;
	
	StudyBuddy(){
		points = 0;
		correctAns = 0;
		questions = null;
	}
	
	public void study() {
		QuestionMaker qk = new QuestionMaker();
		
		questions = qk.getQuestions();
		
	
		System.out.println("Welcome to StudyBuddy! Press enter when you are ready to select the file holding your study questions.\n***dialog box opens nd the user selects file above***\nThank you!\n");
		
		Scanner in = new Scanner(System.in);
		String num;
		while(true) {
			System.out.println("How many questions would you like to answer?");
			num = in.next();
			boolean f = true;
			for(int i = 0; i < num.length(); i++) {
				if(num.charAt(i)>'9'||num.charAt(i)<'0') {
					System.out.print("\nSorry, that is not a valid input. ");
					f = false;
					break;
				}
			}
			if(f) {
				if(Integer.parseInt(num) <= questions.length) {
					break;
				}
				else {
					System.out.print("\nSorry but you only loaded "+ (questions.length)+" questions. ");
				}
			}
		}
		
		int i = 0;
		boolean[] delayQuestions = new boolean[questions.length];
		for(int j = 0; j < delayQuestions.length; j++) {
			delayQuestions[j] = true;
			
		}
		while(true) {
			if(delayQuestions[i] == true) {
				System.out.println("\nPoints: "+questions[i].getPoints());
				System.out.println(questions[i].typeOfQuestion()+questions[i].getQuestion());
				if(questions[i].typeOfQuestion().equals("Mutiple Choice: ")) {
					String[] choices = ((QuestionMC)questions[i]).getChoices();
					for(int k = 0; k < choices.length;k++) {
						System.out.println((char)('A'+ k) + ")"+choices[k]);
					}
				}
				String ans = in.next();
				ans = ans.toLowerCase();
				if(ans.equals("pass")){
					System.out.println("Ok, let's skip that one.");
					delayQuestions[i] = false;
				}
				else if(ans.equals("delay")) {
					System.out.println("Ok, I will ask that one later.");
				}
				else {
					if(questions[i].isCorrect(ans)) {
						System.out.println("Correct! You get "+questions[i].getPoints()+" points.");
						points += questions[i].getPoints();
						correctAns += 1;
					}
					else {
						System.out.println("Incorrect, the answer was "+questions[i].getCorrectAns()+". You lose "+questions[i].getPoints()+" points.");
						points -= questions[i].getPoints();
					}
					delayQuestions[i] = false;
				}
			}
			
			i = (i+1) % questions.length;
			boolean f = true;
			for(int j = 0; j < delayQuestions.length; j++) {
				if(delayQuestions[j] == true) {
					f = false;
					break;
				}
			}
			if(f) {
				break;
			}
		}
		
		System.out.println("\nOf the "+questions.length+" questions you attempted, you got "+correctAns+" correct.\nYou earned a total of "+points+" points.\nBetter luck next time!");
		
	}
	
	public int getPoints() {
		return points;
	}
	
	public static void main(String arg[]) { 
		StudyBuddy sb = new StudyBuddy();
		sb.study();
	}
	
}
