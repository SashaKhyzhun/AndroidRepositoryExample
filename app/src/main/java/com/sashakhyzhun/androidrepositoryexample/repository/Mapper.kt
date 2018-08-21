package com.sashakhyzhun.androidrepositoryexample.repository

interface Mapper<From, To> {

    fun map(from: From): To

}
