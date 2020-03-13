package kunal26das.newsapp.ui.adapter;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import kunal26das.newsapp.R;
import kunal26das.newsapp.source.model.News;

/**
 * Created by kunal on 10-03-2020.
 */
public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsHolder> {

    private List<News> news = new ArrayList<>();

    public void setNews(List<News> news) {
        this.news = news;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public NewsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new NewsHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull NewsHolder holder, int position) {
        holder.update(news.get(position));
        holder.itemView.setOnClickListener(view -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(news.get(position).getWebUrl()));
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            holder.itemView.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return news.size();
    }

    static class NewsHolder extends RecyclerView.ViewHolder {

        private AppCompatTextView headline;
        private AppCompatTextView sectionName;
        private AppCompatTextView webPublicationDate;

        public NewsHolder(@NonNull View itemView) {
            super(itemView);
            headline = itemView.findViewById(R.id.web_title);
            sectionName = itemView.findViewById(R.id.section_name);
            webPublicationDate = itemView.findViewById(R.id.web_publication_date);
        }

        public void update(News news) {
            headline.setText(String.format("%s\n", news.getWebTitle()));
            sectionName.setText(String.format("- %s", news.getSectionName()));
            webPublicationDate.setText(news.getWebPublicationDate());
        }
    }
}
