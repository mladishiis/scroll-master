package com.sakovkid.android_touch_fling

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.horizontal_view.view.*

class NewsAdapter(private val mNews: List<String>,val mStories: List<String>
): RecyclerView.Adapter<NewsAdapter.MyViewHolder>(){

    companion object {
        const val TYPE_NORMAL = 0
        const val TYPE_LIST = 1
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        if(viewType == TYPE_LIST) {
            var view: View
            view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.horizontal_view, parent, false)
            return ListViewHolder(view)

        }else{
            var view: View
            view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
            return MyViewHolder(view)
        }
    }

    override fun getItemCount(): Int {
        return  mNews.size
    }

    override fun getItemViewType(position: Int): Int {
        if (mNews[position] == "LIST") return TYPE_LIST
        return TYPE_NORMAL
    }

    override fun onBindViewHolder(view: MyViewHolder, position: Int) {
        view.populate(mNews[position])
    }

    open class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        open fun populate(color: String) {
            //itemView.container.setBackgroundColor(Color.parseColor(color))
            itemView.setOnClickListener {
                Log.d("TraceTouch", "MyViewHolder is clicked")
                Toast.makeText(itemView.context, "MyViewHolder is clicked", Toast.LENGTH_SHORT).show()
            }
        }
    }

    class ListViewHolder(private val view: View) : MyViewHolder( view) {
        override fun populate(color: String) {
            view.view_list_horizontal.layoutManager =
                LinearLayoutManager(view.context, LinearLayoutManager.HORIZONTAL, false)
            view.view_list_horizontal.adapter = StoriesAdapter()
        }
    }
}