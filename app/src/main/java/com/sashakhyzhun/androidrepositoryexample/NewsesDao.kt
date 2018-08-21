package com.sashakhyzhun.androidrepositoryexample

import com.sashakhyzhun.androidrepositoryexample.model.News

/**
 * @author SashaKhyzhun
 * Created on 8/21/18.
 */
interface NewsesDao {

    fun add(news: News)
    fun update(news: News)
    fun remove(news: News)

    fun getById(): News

    fun getNewest(): List<News>
    fun getAll(): List<News>
    fun getByCategory(): List<News>
    fun getNewerThan(): List<News>


}




