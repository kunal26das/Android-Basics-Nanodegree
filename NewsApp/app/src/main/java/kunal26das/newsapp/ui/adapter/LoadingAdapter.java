package kunal26das.newsapp.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import kunal26das.newsapp.R;

/**
 * Created by kunal on 11-03-2020.
 */
public class LoadingAdapter extends RecyclerView.Adapter<LoadingAdapter.LoadingHolder> {

    @NonNull
    @Override
    public LoadingHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new LoadingHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_loading, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull LoadingHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 1;
    }

    static class LoadingHolder extends RecyclerView.ViewHolder {

        public LoadingHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
