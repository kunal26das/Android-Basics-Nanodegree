package kunal26das.quizapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import kunal26das.quizapp.databinding.FragmentQuestion2Binding;

/**
 * Created by kunal on 19-02-2020.
 */
public class Question2Fragment extends Fragment {

    private NavController navController;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentQuestion2Binding dataBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_question_2, container, false);
        MainActivity activity = (MainActivity) getActivity();
        if (activity != null) {
            dataBinding.setViewModel(activity.viewModel);
            dataBinding.setLifecycleOwner(this);
        }
        return dataBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
        Button startButton = view.findViewById(R.id.startButton);
        startButton.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_question2_to_question3);
            }
        });
    }
}
