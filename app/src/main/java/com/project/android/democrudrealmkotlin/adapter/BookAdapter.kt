package com.project.android.democrudrealmkotlin.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.project.android.democrudrealmkotlin.R
import com.project.android.democrudrealmkotlin.model.DataModel
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject

/**
 * Created by agung on 21/09/18.
 */
class BookAdapter : RecyclerView.Adapter<BookAdapter.MyViewHolder>() {

    var items: List<DataModel> = ArrayList()

    private val clickSubject = PublishSubject.create<DataModel>()

    val clickEvent: Observable<DataModel> = clickSubject

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent?.context)
                .inflate(R.layout.item_book, parent, false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder?.bind(items[position])
    }

    inner class MyViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        var mTitle: TextView? = null
        var mContent: TextView? = null

        init {
            this.mTitle = itemView?.findViewById<TextView>(R.id.tv_title)
            this.mContent = itemView?.findViewById<TextView>(R.id.tv_content)

            itemView?.setOnClickListener {
                clickSubject.onNext(items[layoutPosition])
            }
        }

        fun bind(book: DataModel){
            mTitle?.text = book.title
            mContent?.text = book.content
        }

    }
}