package indi.aljet.mymovieguide_master.listing.sorting;

/**
 * Created by PC-LJL on 2018/4/11.
 */

public enum SortType {

    MOST_POPULAR(0) ,HIGHEST_RATED(1),FAVORITES(2);

    private final int value;

    SortType(int value){
        this.value = value;
    }

    public int getValue(){
        return value;
    }

}
