package com.sashakhyzhun.androidrepositoryexample.specification.realm

import com.sashakhyzhun.androidrepositoryexample.model.NewsRealm
import io.realm.RealmResults
import com.sashakhyzhun.androidrepositoryexample.repository.realm.RealmSpecification
import io.realm.Realm


/**
 * @author SashaKhyzhun
 * Created on 8/21/18.
 */
class NewsByIdSpecification() : RealmSpecification {

    override fun toRealmResults(realm: Realm): RealmResults<NewsRealm> {
        return realm.where(NewsRealm::class.java)
                .equalTo("NewsRealm.Fields.ID", "id")
                .findAll()
    }

}