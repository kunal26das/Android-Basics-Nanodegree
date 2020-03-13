package kunal26das.newsapp.dagger.module;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import kunal26das.newsapp.ui.NewsActivity;

/**
 * Created by kunal on 10-03-2020.
 */
@Module
public abstract class ActivityModule {

    @ContributesAndroidInjector()
    abstract NewsActivity contributeNewsActivity();
}
