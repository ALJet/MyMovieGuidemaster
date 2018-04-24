package indi.aljet.mymovieguide_master.listing.sorting;

/**
 * Created by PC-LJL on 2018/4/11.
 */

public class SortingDialogInteractorImpl
        implements SortingDialogInteractor {

    private SortingOptionStore sortingOptionStore;

    public SortingDialogInteractorImpl(SortingOptionStore sortingOptionStore) {
        this.sortingOptionStore = sortingOptionStore;
    }


    @Override
    public int getSelectedSortingOption() {
        return sortingOptionStore.getSelectedOption();
    }

    @Override
    public void setSortingOption(SortType sortType) {
        sortingOptionStore.setSelectedOption(sortType);
    }
}
