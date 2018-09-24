package com.project.android.democrudrealmkotlin.activity

import android.content.Intent
import android.os.Bundle
import android.provider.SyncStateContract
import android.support.annotation.LayoutRes
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import butterknife.BindView
import butterknife.OnClick
import com.project.android.democrudrealmkotlin.R
import com.project.android.democrudrealmkotlin.adapter.BookAdapter
import com.project.android.democrudrealmkotlin.realm.RealmHelper
import com.project.android.democrudrealmkotlin.utils.Constants
import com.squareup.otto.Bus
import com.squareup.otto.Subscribe
import io.reactivex.disposables.Disposable
import javax.inject.Inject

class MainActivity : BaseActivity() {

    @LayoutRes
    override fun getLayoutResId(): Int{
        return R.layout.activity_main
    }

    @BindView(R.id.recyclerview) lateinit var recyclerView: RecyclerView
    private val adapter = BookAdapter()

    @Inject lateinit var realmHelper: RealmHelper
    @Inject lateinit var bus: Bus

    private var subscrible: Disposable? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        appComponent().inject(this)

        bus.register(this)
        val layoutManager =  LinearLayoutManager(applicationContext)
        recyclerView.layoutManager = layoutManager
        recyclerView.itemAnimator = DefaultItemAnimator()

        recyclerView.adapter = adapter
        adapter.items = realmHelper.findAll()
        adapter.notifyDataSetChanged()

        subscrible = adapter.clickEvent.subscribe{
            var intent = Intent(this, AddActivity::class.java)
            intent.putExtra(Constants.INTENT_KEY_NOTE_ID, it.id)
            startActivity(intent)
        }
    }

    @OnClick(R.id.fab)
    fun onClick(){
        val intent =  Intent(this, AddActivity::class.java)
        intent.putExtra(Constants.INTENT_KEY_NOTE_ID, -1L)
        startActivity(intent)
    }
}
