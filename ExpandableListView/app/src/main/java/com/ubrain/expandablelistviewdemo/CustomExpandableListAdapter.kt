package com.ubrain.expandablelistviewdemo

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import android.widget.TextView


class CustomExpandableListAdapter : BaseExpandableListAdapter {

    lateinit var context: Context
    lateinit var expandableListTitle: ArrayList<String>
    lateinit var expandableListDetail: HashMap<String, ArrayList<String>>

    constructor(
        context: Context,
        expandableListTitle: ArrayList<String>,
        expandableListDetail: HashMap<String, ArrayList<String>>
    ) {
        this.context = context
        this.expandableListTitle = expandableListTitle
        this.expandableListDetail = expandableListDetail
    }

    override fun getGroup(groupPosition: Int): Any {
        return this.expandableListTitle.get(groupPosition)
    }

    override fun isChildSelectable(groupPosition: Int, childPosition: Int): Boolean {
        return true
    }

    override fun hasStableIds(): Boolean {
        return false
    }

    override fun getChild(groupPosition: Int, childPosition: Int): Any {
        return this.expandableListDetail.get(this.expandableListTitle.get(groupPosition))!!.get(childPosition)
    }

    override fun getChildId(groupPosition: Int, childPosition: Int): Long {
        return childPosition.toLong()
    }

    override fun getChildView(
        groupPosition: Int,
        childPosition: Int,
        isLastChild: Boolean,
        convertView: View?,
        parent: ViewGroup?
    ): View {
        var expandableListText: String = getChild(groupPosition, childPosition) as String

            var itemView = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)



        var txtExpandable = itemView!!.findViewById(R.id.txt_item) as TextView
        txtExpandable.setText(expandableListText)


        return itemView
    }

    override fun getChildrenCount(groupPosition: Int): Int {
        return this.expandableListDetail.get(this.expandableListTitle.get(groupPosition))!!.size
    }

    override fun getGroupCount(): Int {
        return this.expandableListTitle.size
    }

    override fun getGroupId(groupPosition: Int): Long {
        return groupPosition.toLong()
    }

    override fun getGroupView(groupPosition: Int, isExpanded: Boolean, convertView: View?, parent: ViewGroup?): View {
        var listTitle = getGroup(groupPosition) as String
        var itemView = LayoutInflater.from(context).inflate(R.layout.list_group, parent, false)


        var txtExpandableGroup = itemView!!.findViewById(R.id.txt_grp) as TextView
        txtExpandableGroup.setText(listTitle)


        return itemView
    }
}