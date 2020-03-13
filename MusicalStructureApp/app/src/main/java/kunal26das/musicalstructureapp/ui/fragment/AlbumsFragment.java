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

import java.util.ArrayList;
import java.util.List;

import kunal26das.musicalstructureapp.R;
import kunal26das.musicalstructureapp.adapter.CustomObject;
import kunal26das.musicalstructureapp.adapter.OnCustomObjectItemClickListener;
import kunal26das.musicalstructureapp.adapter.CustomAdapter;
import kunal26das.musicalstructureapp.ui.MainActivity;
import kunal26das.musicalstructureapp.ui.MainViewModel;

/**
 * Created by kunal on 28-02-2020.
 */
public class AlbumsFragment extends Fragment {

    private NavController navController;
    private CustomAdapter albumsAdapter = new CustomAdapter();
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
        recyclerView.setAdapter(albumsAdapter);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(view.getContext(), linearLayoutManager.getOrientation()));

        final CustomObject artist = viewModel.artist.getValue();
        if (artist != null) {
            List<CustomObject> objects = new ArrayList<>();
            if (getString(R.string.coldplay).equals(artist.getTitle())) {
                objects.add(new CustomObject(getString(R.string.parachutes), getString(R.string.album_cover_parachutes)));
                objects.add(new CustomObject(getString(R.string.a_rush_of_blood_to_the_head), getString(R.string.album_cover_a_rush_of_blood_to_the_head)));
                objects.add(new CustomObject(getString(R.string.x_and_y), getString(R.string.album_cover_x_and_y)));
                objects.add(new CustomObject(getString(R.string.viva_la_vida_or_death_and_all_his_friends), getString(R.string.album_cover_viva_la_vida_or_death_and_all_his_friends)));
                objects.add(new CustomObject(getString(R.string.mylo_xyloto), getString(R.string.album_cover_mylo_xyloto)));
                objects.add(new CustomObject(getString(R.string.ghost_stories), getString(R.string.album_cover_ghost_stories)));
                objects.add(new CustomObject(getString(R.string.a_head_full_of_dreams), getString(R.string.album_cover_a_head_full_of_dreams)));
                objects.add(new CustomObject(getString(R.string.everyday_life), getString(R.string.album_cover_everyday_life)));
            } else if (getString(R.string.milky_chance).equals(artist.getTitle())) {
                objects.add(new CustomObject(getString(R.string.sadnecessary), getString(R.string.album_cover_sadnecessary)));
                objects.add(new CustomObject(getString(R.string.blossom), getString(R.string.album_cover_blossom)));
                objects.add(new CustomObject(getString(R.string.mind_the_moon), getString(R.string.album_cover_mind_the_moon)));
            }
            albumsAdapter.setObjects(objects);
        }
        albumsAdapter.setOnCustomObjectItemClickListener(new OnCustomObjectItemClickListener() {
            @Override
            public void onClick(CustomObject album) {
                viewModel.album.setValue(album);
                navController.navigate(R.id.action_albumsFragment_to_songsFragment);
            }
        });
    }
}
