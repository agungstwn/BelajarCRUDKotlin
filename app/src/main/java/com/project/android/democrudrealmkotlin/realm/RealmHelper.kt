package com.project.android.democrudrealmkotlin.realm

import com.project.android.democrudrealmkotlin.model.DataModel
import io.realm.Realm
import io.realm.RealmConfiguration

/**
 * Created by agung on 21/09/18.
 */
class RealmHelper {

    val realm: Realm by lazy {
        val config = RealmConfiguration.Builder()
                .name("agung.realm")
                .schemaVersion(0)
                .build()
        Realm.getInstance(config)
    }

    // insert
     fun insert (title: String, content: String){
        realm.beginTransaction()
        var newId : Long = 1
        if (realm.where(DataModel::class.java).max("id") != null){
            newId = realm.where(DataModel::class.java).max("id") as Long + 1
        }
        val note = realm.createObject(DataModel::class.java, newId)
        note.title = title
        note.content = content
        realm.commitTransaction()
    }

    //find
    fun find(id:Long): DataModel?{
        return realm.where(DataModel::class.java).equalTo("id", id).findFirst()
    }

    //findAll
    fun findAll() : List<DataModel>{
        return realm.where(DataModel::class.java).findAll()
    }

    //update
    fun update(id: Long, title: String, content: String){
        realm.beginTransaction()
        val book = find(id)
        book?.title = title
        book?.content = content

        realm.commitTransaction()
    }

    //delete
    fun delete(id: Long){
        realm.beginTransaction()
        val result = realm.where(DataModel::class.java!!).equalTo("id", id).findAll()
        result.deleteAllFromRealm()
        realm.commitTransaction()
    }
}