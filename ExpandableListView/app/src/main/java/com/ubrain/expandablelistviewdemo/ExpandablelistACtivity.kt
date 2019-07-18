package com.ubrain.expandablelistviewdemo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ExpandableListView

class ExpandablelistACtivity : AppCompatActivity() {

    lateinit var expandableListView: ExpandableListView
    lateinit var customExpandableListAdapter: CustomExpandableListAdapter
    lateinit var expandableListTitle: ArrayList<String>
    lateinit var expandableListDetail: HashMap<String, ArrayList<String>>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.expandablelist_activity)


        expandableListView=findViewById(R.id.expandable_listview) as ExpandableListView

        expandableListDetail= ExpandableListData().getData()

        expandableListTitle=ArrayList<String>(expandableListDetail.keys)


        customExpandableListAdapter= CustomExpandableListAdapter(this@ExpandablelistACtivity,expandableListTitle,expandableListDetail)
        expandableListView.setAdapter(customExpandableListAdapter)



    }
}
