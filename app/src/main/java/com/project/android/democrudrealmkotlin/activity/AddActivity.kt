package com.project.android.democrudrealmkotlin.activity

import android.os.Bundle
import android.support.annotation.LayoutRes
import com.project.android.democrudrealmkotlin.R

class AddActivity : BaseActivity() {

    @LayoutRes
    override fun getLayoutResId(): Int {
        return R.layout.activity_add

    }

    var noteId = -1L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        appComponent().inject(this)

    }
}
