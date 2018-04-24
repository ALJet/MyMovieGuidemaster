package indi.aljet.mymovieguide_master.listing.sorting;

import dagger.Module;
import dagger.Provides;

/**
 * Created by PC-LJL on 2018/4/11.
 */

@Module
public class SortingModule {
    @Provides
    SortingDialogInteractor providesSortingDialogInteractor
            (SortingOptionStore store){
        return new SortingDialogInteractorImpl(store);
    }


    @Provides
    SortingDialogPresenter providePresenter
            (SortingDialogInteractor interactor){
                return new SortingDialogPresenterImpl
                        (interactor);
    }

}
