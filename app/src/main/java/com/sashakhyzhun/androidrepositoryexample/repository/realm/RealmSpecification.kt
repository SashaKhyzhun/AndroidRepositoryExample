package com.sashakhyzhun.androidrepositoryexample.repository.realm

import com.sashakhyzhun.androidrepositoryexample.model.News
import com.sashakhyzhun.androidrepositoryexample.model.NewsRealm
import io.realm.Realm
import io.realm.RealmResults

interface RealmSpecification {

    fun toRealmResults(realm: Realm): RealmResults<NewsRealm>

}
