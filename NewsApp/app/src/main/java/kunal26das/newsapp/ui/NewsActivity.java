package kunal26das.newsapp.ui;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import kunal26das.newsapp.R;
import kunal26das.newsapp.dagger.view_model.ViewModelFactory;
import kunal26das.newsapp.ui.adapter.LoadingAdapter;
import kunal26das.newsapp.ui.adapter.NewsAdapter;

public class NewsActivity extends AppCompatActivity {

    @Inject
    ViewModelFactory viewModelFactory;

    private NewsViewModel newsViewModel;
    private NewsAdapter newsAdapter = new NewsAdapter();
    private LoadingAdapter loadingAdapter = new LoadingAdapter();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        final RecyclerView list = findViewById(R.id.list);
        list.setAdapter(loadingAdapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        list.setLayoutManager(layoutManager);
        list.addItemDecoration(new DividerItemDecoration(this, layoutManager.getOrientation()));

        newsViewModel = viewModelFactory.create(NewsViewModel.class);
        newsViewModel.fetchNews();
        newsViewModel.error.observe(this, error -> {
            if (!error.isEmpty()) {
                Snackbar.make(list, error, Snackbar.LENGTH_INDEFINITE)
                        .setAction(R.string.retry, view -> {
                            newsViewModel.fetchNews();
                        }).show();
            }
        });
        newsViewModel.news.observe(this, news -> {
            if (!news.isEmpty()) {
                newsAdapter.setNews(news);
                list.setAdapter(newsAdapter);
            } else {
                list.setAdapter(loadingAdapter);
            }
        });
    }
}
