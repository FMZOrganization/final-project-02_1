package com.example.final_project_team_01_2

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Window
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FoldersScreenView : AppCompatActivity() {
    // variables for the scrolling folders
    private lateinit var newRecyclerView: RecyclerView
    private lateinit var newArrayList: ArrayList<FolderItem>
    private lateinit var folderName: ArrayList<String>
    private lateinit var numOfCards: ArrayList<String>

    // variables for the Create New Folder popup
    private lateinit var createFolderBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_folders_screen_view)

        // Code for the scrolling folders
        folderName = arrayListOf("math", "biology", "physics")
        numOfCards = arrayListOf("1", "2", "3")

        newRecyclerView = findViewById(R.id.recyclerview)
        newRecyclerView.layoutManager = LinearLayoutManager(this)
        newRecyclerView.setHasFixedSize(true)
        newArrayList = arrayListOf<FolderItem>()

        getFolderData()
        // ------------------------------


        // Code for the Create New Folder popup
        createFolderBtn = findViewById(R.id.openCreateFolderButton)

        createFolderBtn.setOnClickListener {
            val dialogPopup = layoutInflater.inflate(R.layout.create_folder_popup, null)

            val dialog = Dialog(this)
            dialog.setContentView(dialogPopup)

            dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            dialog.show()
        }
        //-------------------------------
    }

    // Gets Folder Names for the RecyclerView
    private fun getFolderData(){
        for(i in folderName.indices){
            val folders = FolderItem(folderName[i], numOfCards[i])

            newArrayList.add(folders)
        }
        newRecyclerView.adapter = FolderAdapter(newArrayList)
    }
    //----------------------------------------


}
