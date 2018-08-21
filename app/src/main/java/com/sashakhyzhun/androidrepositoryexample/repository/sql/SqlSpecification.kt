package com.sashakhyzhun.androidrepositoryexample.repository.sql

import com.sashakhyzhun.androidrepositoryexample.repository.Specification

/**
 * @author SashaKhyzhun
 * Created on 8/21/18.
 */
interface SqlSpecification : Specification {

    fun toSQLQuery(): String

}