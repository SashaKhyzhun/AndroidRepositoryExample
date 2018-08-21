package com.sashakhyzhun.androidrepositoryexample.ui

import com.sashakhyzhun.androidrepositoryexample.model.News
import com.sashakhyzhun.androidrepositoryexample.repository.Repository
import com.sashakhyzhun.androidrepositoryexample.specification.sql.NewestNewsesSpecification
import com.sashakhyzhun.androidrepositoryexample.specification.sql.NewsByIdSpecification

/**
 * @author SashaKhyzhun
 * Created on 8/21/18.
 */
class LatestNewsesPresenter(
        private val view: LatestNewsesView,
        private val repository: Repository<News>
): Presenter<LatestNewsesView> {


    override fun onCreate() {
        val newses = repository.query(NewestNewsesSpecification()) // change to realm if needed
        view.setNewses(newses)
    }

    override fun onDestroy() {

    }


}