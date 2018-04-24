package indi.aljet.mymovieguide_master.util;

import io.reactivex.disposables.Disposable;

/**
 * Created by PC-LJL on 2018/4/4.
 */

public class RxUtils {

    public static void unsubscribe(Disposable subscription){
        if(subscription != null && !subscription
                .isDisposed()){
            subscription.dispose();
        }
    }

    public static void unsubscribe(Disposable... subscriptions){
        for(Disposable subscription : subscriptions){
            unsubscribe(subscription);
        }
    }
}
