package kunal26das.tourguideapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import kunal26das.tourguideapp.R;

/**
 * Created by kunal on 12-03-2020.
 */
public class LocationAdapter extends RecyclerView.Adapter<LocationAdapter.LocationHolder> {

    private List<Location> locations = new ArrayList<>();

    @NonNull
    @Override
    public LocationHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new LocationHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_location, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull LocationHolder holder, int position) {
        holder.update(locations.get(position));
    }

    @Override
    public int getItemCount() {
        return locations.size();
    }

    public void setLocations(List<Location> locations) {
        this.locations = locations;
        notifyDataSetChanged();
    }

    static class LocationHolder extends RecyclerView.ViewHolder {

        private AppCompatTextView name;
        private AppCompatTextView info;

        public LocationHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            info = itemView.findViewById(R.id.info);
        }

        public void update(Location location) {
            name.setText(location.getName());
            info.setText(location.getInfo());
        }
    }
}
