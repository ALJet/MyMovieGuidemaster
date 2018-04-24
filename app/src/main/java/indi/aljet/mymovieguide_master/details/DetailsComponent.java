package indi.aljet.mymovieguide_master.details;

import dagger.Subcomponent;

/**
 * Created by PC-LJL on 2018/4/11.
 */

@DetailsScope
@Subcomponent(modules = {DetailsModult.class})
public interface DetailsComponent {
    void inject(MovieDetailsFragment target);
}
