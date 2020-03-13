package kunal26das.newsapp.dagger.module;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;
import kunal26das.newsapp.dagger.view_model.ViewModelFactory;
import kunal26das.newsapp.dagger.view_model.ViewModelKey;
import kunal26das.newsapp.ui.NewsViewModel;

/**
 * Created by kunal on 10-03-2020.
 */
@Module
public abstract class ViewModelModule {

    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelFactory factory);

    @Binds
    @IntoMap
    @ViewModelKey(NewsViewModel.class)
    protected abstract ViewModel movieListViewModel(NewsViewModel moviesListViewModel);
}
