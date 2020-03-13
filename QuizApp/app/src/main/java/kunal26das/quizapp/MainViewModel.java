package kunal26das.quizapp;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * Created by kunal on 20-02-2020.
 */
public class MainViewModel extends ViewModel {

    // Correct Answers
    final static int question1answer = 1;
    final static boolean question2answer1 = true;
    final static boolean question2answer2 = false;
    final static boolean question2answer3 = true;
    final static boolean question2answer4 = false;
    final static int question3answer = 3;
    final static boolean question4answer1 = false;
    final static boolean question4answer2 = true;
    final static boolean question4answer3 = false;
    final static boolean question4answer4 = true;

    // Selected Answers
    public MutableLiveData<Integer> question1option = new MutableLiveData<>(0);
    public MutableLiveData<Boolean> question2option1 = new MutableLiveData<>(false);
    public MutableLiveData<Boolean> question2option2 = new MutableLiveData<>(false);
    public MutableLiveData<Boolean> question2option3 = new MutableLiveData<>(false);
    public MutableLiveData<Boolean> question2option4 = new MutableLiveData<>(false);
    public MutableLiveData<Integer> question3option = new MutableLiveData<>(0);
    public MutableLiveData<Boolean> question4option1 = new MutableLiveData<>(false);
    public MutableLiveData<Boolean> question4option2 = new MutableLiveData<>(false);
    public MutableLiveData<Boolean> question4option3 = new MutableLiveData<>(false);
    public MutableLiveData<Boolean> question4option4 = new MutableLiveData<>(false);

    // Score
    public MutableLiveData<Integer> score = new MutableLiveData<>(0);

    public void evaluate() {
        score.setValue(0);
        if (question1option.getValue() != null &&
                question1option.getValue() == MainViewModel.question1answer) {
            incrementScore();
        }
        if (question2option1.getValue() != null &&
                question2option1.getValue() == MainViewModel.question2answer1) {
            incrementScore();
        }
        if (question2option2.getValue() != null &&
                question2option2.getValue() == MainViewModel.question2answer2) {
            incrementScore();
        }
        if (question2option3.getValue() != null &&
                question2option3.getValue() == MainViewModel.question2answer3) {
            incrementScore();
        }
        if (question2option4.getValue() != null &&
                question2option4.getValue() == MainViewModel.question2answer4) {
            incrementScore();
        }
        if (question3option.getValue() != null &&
                question3option.getValue() == MainViewModel.question3answer) {
            incrementScore();
        }
        if (question4option1.getValue() != null &&
                question4option1.getValue() == MainViewModel.question4answer1) {
            incrementScore();
        }
        if (question4option2.getValue() != null &&
                question4option2.getValue() == MainViewModel.question4answer2) {
            incrementScore();
        }
        if (question4option3.getValue() != null &&
                question4option3.getValue() == MainViewModel.question4answer3) {
            incrementScore();
        }
        if (question4option4.getValue() != null &&
                question4option4.getValue() == MainViewModel.question4answer4) {
            incrementScore();
        }
    }
    
    public void incrementScore() {
        if (score.getValue() != null) {
            score.setValue(score.getValue() + 1);
        }
    }
}
