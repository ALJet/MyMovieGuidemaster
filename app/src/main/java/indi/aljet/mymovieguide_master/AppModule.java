package indi.aljet.mymovieguide_master;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by PC-LJL on 2018/4/9.
 */

@Module
public class AppModule {

    private Context context;

    public AppModule(Application application) {
        context = application;
    }

    @Provides
    @Singleton
    public Context provideContext(){
        return context;
    }


    @Provides
    @Singleton
    public  Resources provideResources(Context context){
        return context.getResources();
    }


}
