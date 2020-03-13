package kunal26das.tourguideapp.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

import kunal26das.tourguideapp.R;
import kunal26das.tourguideapp.adapter.Location;
import kunal26das.tourguideapp.adapter.LocationAdapter;

public class BhojtalFragment extends Fragment {

    private LocationAdapter locationAdapter = new LocationAdapter();

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_common, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final AppCompatImageView imageView = view.findViewById(R.id.image_view);
        imageView.setImageDrawable(getResources().getDrawable(R.drawable.location_1));

        final RecyclerView list = view.findViewById(R.id.list);
        list.setAdapter(locationAdapter);
        final LinearLayoutManager layoutManager = new LinearLayoutManager(view.getContext());
        list.setLayoutManager(layoutManager);
        list.addItemDecoration(new DividerItemDecoration(view.getContext(), layoutManager.getOrientation()));
        List<Location> locations = new ArrayList<>();
        locations.add(new Location(getString(R.string.events), getString(R.string.events_bhojtal)));
        locations.add(new Location(getString(R.string.restaurant), getString(R.string.restaurant_bhojtal)));
        locations.add(new Location(getString(R.string.historical_sites), getString(R.string.historical_sites_bhojtal)));
        locations.add(new Location(getString(R.string.source), getString(R.string.source_bhojtal)));
        locationAdapter.setLocations(locations);
    }
}
