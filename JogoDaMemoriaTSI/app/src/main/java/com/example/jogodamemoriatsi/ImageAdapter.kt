package com.example.jogodamemoriatsi

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.AbsListView
import android.widget.BaseAdapter
import android.widget.ImageView

class ImageAdapter(private val context: Context) : BaseAdapter() {

    override fun getCount(): Int {
        return 16
    }

    override fun getItem(position: Int): Any? {
        return null
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val imageView: ImageView

        if (convertView == null) {
            imageView = ImageView(this.context)
            imageView.setLayoutParams(AbsListView.LayoutParams(150,150))
            imageView.scaleType = ImageView.ScaleType.FIT_XY
        } else {
            imageView = convertView as ImageView
            imageView.setImageResource(R.drawable.hidden)
        }
        return imageView
    }


}