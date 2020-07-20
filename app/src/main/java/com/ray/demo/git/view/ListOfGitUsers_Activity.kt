package com.ray.demo.git.view

import android.app.PendingIntent.getActivity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.*
import com.ray.demo.R
import com.ray.demo.git.view.adapter.GitListAdapter
import com.ray.demo.git.viewmodel.MainViewModel
import com.ray.demo.git.viewmodel.MainViewModel.Companion.savedPosition
import kotlinx.android.synthetic.main.activity_listofgitusers.*

class ListOfGitUsers_Activity : AppCompatActivity() {

    private val TAG = "ListOfGitUsers_Activity"
    lateinit var vm: MainViewModel

    var listView: ListView? = null
    lateinit var mAdapter: GitListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listofgitusers)

        vm = ViewModelProvider(this).get(MainViewModel::class.java)

        vm.listofRepoMutable?.observe(this, Observer { listOfData ->
            listOfData?.let {
                Log.d(TAG, "onCreate:${it.get(0).fullName} ")
                //                test_user.text = it.get(0).fullName
                test_user.visibility = View.GONE

                mAdapter = GitListAdapter(this, it)
                listofgit.adapter = mAdapter

                mAdapter.notifyDataSetChanged()
            }
        })

        listofgit.setOnItemClickListener(object : AdapterView.OnItemClickListener {
            override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                savePositionClicked(position)
                intent= Intent(this@ListOfGitUsers_Activity, IndividualUserData::class.java)
                startActivity(intent)
            }
        })

    }

    fun savePositionClicked(position:Int){
        MainViewModel.savedPosition = position as Integer
    }
}

