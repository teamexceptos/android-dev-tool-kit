package com.exceptos.devkits

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.exceptos.devkits.activities.ButtonsActivity
import com.exceptos.devkits.activities.DialogActivity
import com.exceptos.devkits.activities.ProgressBarActivity
import com.exceptos.devkits.activities.ProgressCircleActivity
import com.exceptos.devkits.utils.RecyclerItemClickListener
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var mAdapter: MainAdapter? = null
    val mActivity: Activity = this@MainActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val devItemList = arrayListOf<String>()
        devItemList.addAll(listOf(
            "Progress Circle",
            "Progress Bar",
            "Buttons",
            "Bottom app bar",
            "Bottom Navigation",
            "Bottom Sheet",
            "Seek Bar",
            "Chips",
            "Tool Bar",
            "Ratings",
            "Navigation Drawer",
            "Dialogs",
            "Gird Views",
            "Spinners",
            "Text Views",
            "Layouts",
            "Fonts",
            "Swipes"))

        initialize_rv(devItemList)

    }

    private fun initialize_rv(array: ArrayList<String>) {

        main_recyclerView.visibility = View.VISIBLE
        main_recyclerView.setHasFixedSize(true)
        main_recyclerView.layoutManager = LinearLayoutManager(baseContext)
        mAdapter = MainAdapter(baseContext, array)

        main_recyclerView.addOnItemTouchListener(RecyclerItemClickListener(baseContext, main_recyclerView, object : RecyclerItemClickListener.OnItemClickListener {

            override fun onItemClick(view: View, position: Int) {

                when(array[position]){
                    "Progress Circle" -> {
                        startActivity(Intent(mActivity, ProgressCircleActivity::class.java))
                    }

                    "Progress Bar" -> {
                        startActivity(Intent(mActivity, ProgressBarActivity::class.java))
                    }

                    "Buttons" -> {
                        startActivity(Intent(mActivity, ButtonsActivity::class.java))
                    }

                    "Dialogs" -> {
                        startActivity(Intent(mActivity, DialogActivity::class.java))
                    }
                }

            }

            override fun onLongItemClick(view: View, position: Int) {

            }
        }))

        main_recyclerView.adapter = mAdapter
    }
}
