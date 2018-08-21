package com.sashakhyzhun.androidrepositoryexample.specification.sql

import com.sashakhyzhun.androidrepositoryexample.repository.sql.SqlSpecification

/**
 * @author SashaKhyzhun
 * Created on 8/21/18.
 */
class NewestNewsesSpecification : SqlSpecification {

    override fun toSQLQuery(): String = String.format(
            "SELECT * FROM %1\$s ORDER BY `%2\$s` DESC;",
            "NewsTable.TABLE_NAME",
            "NewsTable.Fields.DATA"
    )


}