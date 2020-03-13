package kunal26das.newsapp.dagger;

import android.app.Application;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.support.AndroidSupportInjectionModule;
import kunal26das.newsapp.NewsApplication;
import kunal26das.newsapp.dagger.module.ActivityModule;
import kunal26das.newsapp.dagger.module.NetworkingModule;
import kunal26das.newsapp.dagger.module.RepositoryModule;
import kunal26das.newsapp.dagger.module.ViewModelModule;

/**
 * Created by kunal on 10-03-2020.
 */
@Component(modules = {
        ActivityModule.class,
        ViewModelModule.class,
        RepositoryModule.class,
        NetworkingModule.class,
        AndroidSupportInjectionModule.class})
@Singleton
public interface NewsModules {

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);
        NewsModules build();
    }

    void inject(NewsApplication newsApplication);
}
