package kunal26das.musicalstructureapp.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Arrays;

import kunal26das.musicalstructureapp.R;
import kunal26das.musicalstructureapp.adapter.CustomObject;
import kunal26das.musicalstructureapp.adapter.OnCustomObjectItemClickListener;
import kunal26das.musicalstructureapp.adapter.CustomAdapter;
import kunal26das.musicalstructureapp.ui.MainActivity;
import kunal26das.musicalstructureapp.ui.MainViewModel;

/**
 * Created by kunal on 28-02-2020.
 */
public class ArtistsFragment extends Fragment {

    private NavController navController;
    private CustomAdapter artistsAdapter = new CustomAdapter();
    private MainViewModel viewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        MainActivity activity = (MainActivity) getActivity();
        if (activity != null) {
            viewModel = activity.getViewModel();
        }
        return inflater.inflate(R.layout.fragment_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(view);

        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(view.getContext());
        recyclerView.setAdapter(artistsAdapter);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(view.getContext(), linearLayoutManager.getOrientation()));

        artistsAdapter.setStrings(Arrays.asList(getResources().getStringArray(R.array.artists)));
        artistsAdapter.setOnCustomObjectItemClickListener(new OnCustomObjectItemClickListener() {
            @Override
            public void onClick(CustomObject artist) {
                viewModel.artist.setValue(artist);
                navController.navigate(R.id.action_artistsFragment_to_albumsFragment);
            }
        });
    }
}
