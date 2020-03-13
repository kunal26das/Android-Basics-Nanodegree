package kunal26das.newsapp.ui;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import kunal26das.newsapp.source.model.DebatesResponse;
import kunal26das.newsapp.source.model.News;
import kunal26das.newsapp.source.repository.NewsRepository;

/**
 * Created by kunal on 10-03-2020.
 */
public class NewsViewModel extends ViewModel {

    private NewsRepository newsRepository;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    public MutableLiveData<String> error = new MutableLiveData<>("");
    public MutableLiveData<List<News>> news = new MutableLiveData<>(new ArrayList<>());
    public MutableLiveData<String> topic = new MutableLiveData<>("debate");

    @Inject
    public NewsViewModel(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    public void fetchNews() {
        newsRepository.getNews(topic.getValue())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<DebatesResponse>() {
                    @Override
                    public void onSubscribe(Disposable disposable) {
                        compositeDisposable.add(disposable);
                    }

                    @Override
                    public void onSuccess(DebatesResponse debatesResponse) {
                        news.setValue(debatesResponse.getNewsResponse().getResults());
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                        error.setValue(e.getMessage());
                    }
                });
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        compositeDisposable.clear();
    }
}
