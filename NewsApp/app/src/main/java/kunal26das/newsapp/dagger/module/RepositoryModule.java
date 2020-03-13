package kunal26das.newsapp.dagger.module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import kunal26das.newsapp.source.repository.NewsRepository;
import kunal26das.newsapp.source.service.NewsService;

/**
 * Created by kunal on 10-03-2020.
 */
@Module
public class RepositoryModule {

    @Provides
    @Singleton
    NewsRepository provideNewsRepository(NewsService newsService) {
        return new NewsRepository(newsService);
    }
}
