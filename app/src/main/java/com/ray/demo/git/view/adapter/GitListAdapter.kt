package com.ray.demo.git.view.adapter

import android.content.Context
import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.LayoutInflater.*
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.ray.demo.R
import com.ray.demo.git.repository.data.GithubResponse
import kotlinx.android.synthetic.main.github_list_each_view.view.*
import java.net.URL

class GitListAdapter(val context: Context, val data:List<GithubResponse>): BaseAdapter() {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view:View
        val holder:ViewHolder
        var options:RequestOptions

        if (convertView == null){
            view = LayoutInflater.from(context).inflate(R.layout.github_list_each_view, parent, false)

            holder = ViewHolder()
            holder.userImage = view.findViewById(R.id.user_image_each)
            holder.userID = view.findViewById(R.id.user_id_each)
            holder.userName = view.findViewById(R.id.user_name_each)

            view.tag = holder

            //bind/connect each data to each view
           // val image = BitmapFactory.decodeStream(URL(data[position].owner.avatarUrl).openConnection().getInputStream())
            // holder.userImage.setImageBitmap(image)
            options = RequestOptions()
                .centerCrop()
                .placeholder(R.mipmap.ic_launcher_round)
                .error(R.mipmap.ic_launcher_round)


            Glide.with(context)
                .load(data[position].owner.avatarUrl)
                .apply(options)
                .into(holder.userImage)

            holder.userID.text = data[position].id.toString()
            holder.userName.text = data[position].fullName

            return view
        }else{
            view = convertView
            holder = convertView.tag as ViewHolder
        }
            return view

    }

    override fun getItem(position: Int): Any {
        return data[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return data.size
    }

    private class ViewHolder{
        lateinit var userImage: ImageView
        lateinit var userName:TextView
        lateinit var userID:TextView
    }

}

