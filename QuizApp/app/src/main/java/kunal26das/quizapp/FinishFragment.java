package kunal26das.quizapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import kunal26das.quizapp.databinding.FragmentFinishBinding;

/**
 * Created by kunal on 20-02-2020.
 */
public class FinishFragment extends Fragment {

    private FragmentFinishBinding dataBinding;
    private MainViewModel viewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        dataBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_finish, container, false);
        MainActivity activity = (MainActivity) getActivity();
        if (activity != null) {
            viewModel = activity.viewModel;
            dataBinding.setViewModel(viewModel);
            dataBinding.setLifecycleOwner(this);
        }
        return dataBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
        viewModel.evaluate();
    }
}
