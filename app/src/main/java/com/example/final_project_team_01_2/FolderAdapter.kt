package com.example.final_project_team_01_2

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import android.view.View
import android.widget.TextView

class FolderAdapter(private val folderList: ArrayList<FolderItem>) :
    RecyclerView.Adapter<FolderAdapter.FolderViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FolderViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.folder_item_view, parent, false)
        return FolderViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: FolderViewHolder, position: Int) {
        val currentItem = folderList[position]
        holder.folderNameText.text = currentItem.folderName
        holder.numOfCardsText.text = currentItem.numOfCards
    }

    override fun getItemCount(): Int {
        return folderList.size
    }

    class FolderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val folderNameText : TextView = itemView.findViewById(R.id.foldername)
        val numOfCardsText : TextView= itemView.findViewById(R.id.numberofcards)
    }


}