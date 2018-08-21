package com.sashakhyzhun.androidrepositoryexample.specification.sql

import com.sashakhyzhun.androidrepositoryexample.repository.sql.SqlSpecification



/**
 * @author SashaKhyzhun
 * Created on 8/21/18.
 */
class NewsByIdSpecification(private val id: Int) : SqlSpecification {

    override fun toSQLQuery(): String {
        return String.format(
                "SELECT * FROM %1\$s WHERE `%2\$s` = %3\$d';",
                "NewsTable.TABLE_NAME",
                "NewsTable.Fields.ID",
                id
        )
    }

}