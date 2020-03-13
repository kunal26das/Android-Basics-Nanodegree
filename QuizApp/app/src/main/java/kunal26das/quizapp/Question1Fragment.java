package kunal26das.quizapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

/**
 * Created by kunal on 19-02-2020.
 */
public class Question1Fragment extends Fragment {

    private NavController navController;
    private MainViewModel viewModel = null;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        MainActivity activity = (MainActivity) getActivity();
        if (activity != null) {
            viewModel = activity.viewModel;
        }
        return inflater.inflate(R.layout.fragment_question_1, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
        Button startButton = view.findViewById(R.id.startButton);
        final RadioGroup radioGroup = view.findViewById(R.id.radioGroup2);
        startButton.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (viewModel != null) {
                    switch (radioGroup.getCheckedRadioButtonId()) {
                        case R.id.option1: {
                            viewModel.question1option.setValue(1);
                            break;
                        }
                        case R.id.option2: {
                            viewModel.question1option.setValue(2);
                            break;
                        }
                        case R.id.option3: {
                            viewModel.question1option.setValue(3);
                            break;
                        }
                        case R.id.option4: {
                            viewModel.question1option.setValue(4);
                            break;
                        }
                    }
                }
                navController.navigate(R.id.action_question1_to_question2);
            }
        });
    }

}
