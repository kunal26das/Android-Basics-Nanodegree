package kunal26das.newsapp.source.repository;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;
import kunal26das.newsapp.source.model.DebatesResponse;
import kunal26das.newsapp.source.service.NewsService;

/**
 * Created by kunal on 10-03-2020.
 */
@Singleton
public class NewsRepository {

    private NewsService newsService;

    @Inject
    public NewsRepository(NewsService newsService) {
        this.newsService = newsService;
    }

    public Single<DebatesResponse> getNews(String topic) {
        return newsService.getNews(topic, 1, "f2ac803a-e8ab-4693-b3f7-f6b13bd6b6cb");
    }

}
