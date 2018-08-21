package com.sashakhyzhun.androidrepositoryexample.repository.realm

import com.sashakhyzhun.androidrepositoryexample.model.News
import com.sashakhyzhun.androidrepositoryexample.model.NewsRealm
import com.sashakhyzhun.androidrepositoryexample.repository.Mapper
import com.sashakhyzhun.androidrepositoryexample.repository.Repository
import com.sashakhyzhun.androidrepositoryexample.repository.Specification
import io.realm.Realm
import io.realm.RealmConfiguration
import java.util.*

/**
 * @author SashaKhyzhun
 * Created on 8/21/18.
 */
class NewsRealmRepository(
        private val realmConfiguration: RealmConfiguration,
        private val toNewsMapper: Mapper<NewsRealm, News>
) : Repository<News> {


    override fun add(item: News) {
        val realm = Realm.getInstance(realmConfiguration)
        realm.executeTransaction {
            val newsRealm = realm.createObject(NewsRealm::class.java)
            newsRealm.id = Random().nextInt()
            newsRealm.title = Random().nextBoolean().toString()
        }
        realm.close()
    }

    override fun add(items: Iterable<News>) {}

    override fun update(item: News) {}

    override fun remove(item: News) {}

    override fun remove(specification: Specification) {}

    override fun query(specification: Specification): List<News> {
        val realmSpecification = specification as RealmSpecification

        val realm = Realm.getInstance(realmConfiguration)
        val realmResults = realmSpecification.toRealmResults(realm)

        val newses = mutableListOf<News>()

        realmResults.forEach {
            newses.add(toNewsMapper.map(it))
        }

        realm.close()

        return newses
    }

}