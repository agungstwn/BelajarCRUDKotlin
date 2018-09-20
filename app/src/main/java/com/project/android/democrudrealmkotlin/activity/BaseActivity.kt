package com.project.android.democrudrealmkotlin.activity

import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v7.app.AppCompatActivity
import butterknife.ButterKnife
import com.project.android.democrudrealmkotlin.App
import com.project.android.democrudrealmkotlin.R
import com.project.android.democrudrealmkotlin.component.AppComponent

/**
 * Created by agung on 20/09/18.
 */
open class BaseActivity : AppCompatActivity() {

    @LayoutRes
    protected open fun getLayoutResId(): Int {
        return R.layout.activity_base
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutResId())
        ButterKnife.bind(this)
    }

    protected fun appComponent() : AppComponent {
        return (application as App).component
    }
}