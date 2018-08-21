package com.sashakhyzhun.androidrepositoryexample.repository.sql

import android.content.ContentValues
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.sashakhyzhun.androidrepositoryexample.model.News
import com.sashakhyzhun.androidrepositoryexample.repository.Mapper
import com.sashakhyzhun.androidrepositoryexample.repository.Repository
import com.sashakhyzhun.androidrepositoryexample.repository.Specification
import java.util.*

/**
 * @author SashaKhyzhun
 * Created on 8/21/18.
 */
class NewsSqlRepository(
        private val openHelper: SQLiteOpenHelper,
        private val toContentValueMapper: Mapper<News, ContentValues>,
        private val toNewsMapper: Mapper<Cursor, News>
) : Repository<News> {

    override fun add(item: News) {
        add(Collections.singletonList(item))
    }

    override fun add(items: Iterable<News>) {
        val database: SQLiteDatabase = openHelper.writableDatabase
        database.beginTransaction()

        try {
            items.forEach {
                val cv = toContentValueMapper.map(it)
                database.insert("NewsTable.TABLE_NAME", null, cv)
            }
            database.setTransactionSuccessful()
        } finally {
            database.endTransaction()
            database.close()
        }
    }

    override fun update(item: News) {}

    override fun remove(item: News) {}

    override fun remove(specification: Specification) {}

    override fun query(specification: Specification): List<News> {
        val sqlSpecification = specification as SqlSpecification
        val db = openHelper.readableDatabase
        val newses = mutableListOf<News>()


        db.use { database ->
            val cursor = database.rawQuery(sqlSpecification.toSQLQuery(), arrayOf("", "", ""))

            for (i in 0..cursor.count) {
                cursor.moveToPosition(i)
                newses.add(toNewsMapper.map(cursor))
            }

            cursor.close()

            return newses
        }


    }

}