package com.sashakhyzhun.androidrepositoryexample.specification.sql

import com.sashakhyzhun.androidrepositoryexample.repository.sql.SqlSpecification
import com.sashakhyzhun.androidrepositoryexample.specification.Category


/**
 * @author SashaKhyzhun
 * Created on 8/21/18.
 */
class NewsesByCategorySpecification(private val category: Category) : SqlSpecification {

    override fun toSQLQuery(): String {
        return String.format(
                "SELECT * FROM %1\$s WHERE `%2\$s` = '%3\$d'",
                "NewsTable.TABLE_NAME",
                "NewsTable.Fields.CATEGORY_ID",
                category.getId()
        )
    }


}