package com.project.android.democrudrealmkotlin.model

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

/**
 * Created by agung on 21/09/18.
 */
open class DataModel : RealmObject() {

    @PrimaryKey
    var id : Long = 0
    var title : String = ""
    var content : String = ""
}