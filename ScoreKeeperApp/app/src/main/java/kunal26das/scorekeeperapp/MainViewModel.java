package kunal26das.scorekeeperapp;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * Created by kunal on 15-02-2020.
 */
public class MainViewModel extends ViewModel {

    public MutableLiveData<Integer> teamAScore = new MutableLiveData<>(0);
    public MutableLiveData<Integer> teamBScore = new MutableLiveData<>(0);
    public MutableLiveData<Integer> teamAPenalty = new MutableLiveData<>(0);
    public MutableLiveData<Integer> teamBPenalty = new MutableLiveData<>(0);

}
