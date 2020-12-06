package com.sakovkid.android_touch_fling

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast


class StoriesAdapter (
): RecyclerView.Adapter<StoriesAdapter.MyViewHolder>(){

    val mStories = listOf("#FF0000", "#00FF00", "#0000FF", "#FFFF00", "#FF00FF", "#00FFFF")

    private val MSG_TYPE_LEFT = 0
    private val MSG_TYPE_RIGHT = 1

    private val LEFT_SIDE = "left_side"
    private val RIGHT_SIDE = "right_side"

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var view: View
        view = LayoutInflater.from(parent.context).inflate(R.layout.horizontal_cell, parent, false)
        return MyViewHolder(view)

    }


    override fun getItemCount(): Int {
        return  mStories.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.populate(mStories[position])

    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        open fun populate(color: String) {
            //itemView.container.setBackgroundColor(Color.parseColor(color))
            itemView.setOnClickListener {
                Log.d("TraceTouch", "MyViewHolder is clicked")
                Toast.makeText(itemView.context, "MyViewHolder is clicked", Toast.LENGTH_SHORT).show()
            }
        }
    }
}