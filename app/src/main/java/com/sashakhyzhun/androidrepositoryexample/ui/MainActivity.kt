package com.sashakhyzhun.androidrepositoryexample.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.sashakhyzhun.androidrepositoryexample.model.News
import com.sashakhyzhun.androidrepositoryexample.R
import com.sashakhyzhun.androidrepositoryexample.repository.Repository

class MainActivity : AppCompatActivity(), LatestNewsesView {

    private lateinit var presenter: LatestNewsesPresenter
    private lateinit var repository: Repository<News>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //presenter = LatestNewsesPresenter(this, ... )
    }


    override fun setNewses(newses: List<News>) {
        // view.text = newses.first() for instance.
    }
}
