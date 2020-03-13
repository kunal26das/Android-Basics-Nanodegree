package kunal26das.musicalstructureapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import kunal26das.musicalstructureapp.R;

/**
 * Created by kunal on 28-02-2020.
 */
public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.StringHolder> {

    private List<CustomObject> objects = new ArrayList<>();
    private OnCustomObjectItemClickListener onCustomObjectItemClickListener;

    public void setObjects(List<CustomObject> objects) {
        this.objects = objects;
        notifyDataSetChanged();
    }

    public void setStrings(List<String> strings) {
        this.objects = new ArrayList<>();
        for(String string: strings) {
            objects.add(new CustomObject(string, ""));
        }
    }

    public void setOnCustomObjectItemClickListener(OnCustomObjectItemClickListener onCustomObjectItemClickListener) {
        this.onCustomObjectItemClickListener = onCustomObjectItemClickListener;
    }

    @NonNull
    @Override
    public StringHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new StringHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_string, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull StringHolder holder, final int position) {
        holder.update(objects.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onCustomObjectItemClickListener.onClick(objects.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return objects.size();
    }

    static class StringHolder extends RecyclerView.ViewHolder {

        private AppCompatTextView textView;

        public StringHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.text_view);
        }

        public void update(CustomObject object) {
            textView.setText(object.getTitle());
        }
    }
}

