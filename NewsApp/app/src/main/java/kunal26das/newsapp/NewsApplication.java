package kunal26das.newsapp;

import android.app.Activity;
import android.app.Application;

import javax.inject.Inject;

import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import kunal26das.newsapp.dagger.DaggerNewsModules;

/**
 * Created by kunal on 10-03-2020.
 */
public class NewsApplication extends Application implements HasActivityInjector {

    @Inject
    DispatchingAndroidInjector<Activity> dispatchingAndroidInjector;

    @Override
    public DispatchingAndroidInjector<Activity> activityInjector() {
        return dispatchingAndroidInjector;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        DaggerNewsModules.builder()
                .application(this)
                .build()
                .inject(this);
    }
}