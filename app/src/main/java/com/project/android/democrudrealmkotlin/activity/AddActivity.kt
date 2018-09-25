package com.project.android.democrudrealmkotlin.activity

import android.os.Bundle
import android.support.annotation.LayoutRes
import android.view.View
import android.widget.Button
import butterknife.BindView
import butterknife.OnClick
import com.project.android.democrudrealmkotlin.R
import com.project.android.democrudrealmkotlin.bus.DataEvent
import com.project.android.democrudrealmkotlin.model.DataModel
import com.project.android.democrudrealmkotlin.realm.RealmHelper
import com.project.android.democrudrealmkotlin.utils.Constants
import com.rengwuxian.materialedittext.MaterialEditText
import com.squareup.otto.Bus
import javax.inject.Inject

class AddActivity : BaseActivity() {


    @LayoutRes
    override fun getLayoutResId(): Int {
        return R.layout.activity_add
    }

    @BindView(R.id.et_title) lateinit var mEtTitle: MaterialEditText
    @BindView(R.id.et_content) lateinit var mEtContent: MaterialEditText
    @BindView(R.id.btn_delete) lateinit var mBtnDelete: Button

    @Inject lateinit var dataRealmManager: RealmHelper
    @Inject lateinit var bus: Bus

    var noteId = -1L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        appComponent().inject(this)

        val bundle = intent.extras

        if (bundle != null){
            noteId = bundle.getLong(Constants.INTENT_KEY_NOTE_ID)
        }

        if (noteId == -1L){
            supportActionBar?.title = "Create New"
            mBtnDelete.visibility = View.GONE
        }else{
            supportActionBar?.title = "Edit"
            mBtnDelete.visibility = View.VISIBLE
            var dataModel = dataRealmManager.find(noteId)
            mEtTitle.setText(dataModel?.title)
            mEtContent.setText(dataModel?.content)
        }
    }

    @OnClick(R.id.btn_save_update)
    fun onClickBtnSave(){
        if (noteId == -1L){
            dataRealmManager.insert(
                    mEtTitle.text.toString(),
                    mEtContent.text.toString()
            )
            bus.post(DataEvent(DataEvent.ACTION_INSERT))
        }else{
            dataRealmManager.update(noteId,
                    mEtTitle.getText().toString(),
                    mEtContent.getText().toString()
            )
            bus.post(DataEvent(DataEvent.ACTION_UPDATE))
        }
        finish()
    }

    @OnClick(R.id.btn_delete)
    fun onClickBtnDelete(){
        dataRealmManager.delete(noteId)
        bus.post(DataEvent(DataEvent.ACTION_DELETE))

        finish()
    }
}
