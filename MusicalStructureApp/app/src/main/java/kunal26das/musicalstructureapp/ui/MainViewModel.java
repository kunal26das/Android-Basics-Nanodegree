package kunal26das.musicalstructureapp.ui;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import kunal26das.musicalstructureapp.adapter.CustomObject;

/**
 * Created by kunal on 28-02-2020.
 */
public class MainViewModel extends ViewModel {

    public MutableLiveData<CustomObject> song = new MutableLiveData<>();
    public MutableLiveData<CustomObject> album = new MutableLiveData<>();
    public MutableLiveData<CustomObject> artist = new MutableLiveData<>();

    MutableLiveData<Boolean> flagBottomSheet = new MutableLiveData<>(false);
    MutableLiveData<Boolean> flagPlayback = new MutableLiveData<>(false);

    public void switchBottomSheet() {
        Boolean flag = flagBottomSheet.getValue();
        if (flag != null) {
            flagBottomSheet.setValue(!flag);
        }
    }

    public void switchPlayback() {
        Boolean flag = flagPlayback.getValue();
        if (flag != null) {
            flagPlayback.setValue(!flag);
        }
    }

    public void play() { flagPlayback.setValue(true); }

    public void pause() {
        flagPlayback.setValue(false);
    }
}
