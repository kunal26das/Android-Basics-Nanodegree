package kunal26das.musicalstructureapp.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
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
public class SongsFragment extends Fragment {

    private CustomAdapter songsAdapter = new CustomAdapter();
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
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(view.getContext());
        recyclerView.setAdapter(songsAdapter);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(view.getContext(), linearLayoutManager.getOrientation()));

        CustomObject album = viewModel.album.getValue();
        if (album != null) {
            if (getString(R.string.coldplay_parachutes).equals(album.getTitle())) {
                songsAdapter.setStrings(Arrays.asList(getResources().getStringArray(R.array.parachutes)));
            } else if (getString(R.string.a_rush_of_blood_to_the_head).equals(album.getTitle())) {
                songsAdapter.setStrings(Arrays.asList(getResources().getStringArray(R.array.a_rush_of_blood_to_the_head)));
            } else if (getString(R.string.x_and_y).equals(album.getTitle())) {
                songsAdapter.setStrings(Arrays.asList(getResources().getStringArray(R.array.x_and_y)));
            } else if (getString(R.string.viva_la_vida_or_death_and_all_his_friends).equals(album.getTitle())) {
                songsAdapter.setStrings(Arrays.asList(getResources().getStringArray(R.array.viva_la_vida_or_death_and_all_his_friends)));
            } else if (getString(R.string.mylo_xyloto).equals(album.getTitle())) {
                songsAdapter.setStrings(Arrays.asList(getResources().getStringArray(R.array.mylo_xyloto)));
            } else if (getString(R.string.ghost_stories).equals(album.getTitle())) {
                songsAdapter.setStrings(Arrays.asList(getResources().getStringArray(R.array.ghost_stories)));
            } else if (getString(R.string.a_head_full_of_dreams).equals(album.getTitle())) {
                songsAdapter.setStrings(Arrays.asList(getResources().getStringArray(R.array.a_head_full_of_dreams)));
            } else if (getString(R.string.everyday_life).equals(album.getTitle())) {
                songsAdapter.setStrings(Arrays.asList(getResources().getStringArray(R.array.everyday_life)));
            } else if (getString(R.string.sadnecessary).equals(album.getTitle())) {
                songsAdapter.setStrings(Arrays.asList(getResources().getStringArray(R.array.sadnecessary)));
            } else if (getString(R.string.blossom).equals(album.getTitle())) {
                songsAdapter.setStrings(Arrays.asList(getResources().getStringArray(R.array.blossom)));
            } else if (getString(R.string.mind_the_moon).equals(album.getTitle())) {
                songsAdapter.setStrings(Arrays.asList(getResources().getStringArray(R.array.mind_the_moon)));
            }
        }
        songsAdapter.setOnCustomObjectItemClickListener(new OnCustomObjectItemClickListener() {
            @Override
            public void onClick(CustomObject song) {
                viewModel.song.setValue(song);
                viewModel.switchBottomSheet();
                viewModel.play();
            }
        });
    }
}
