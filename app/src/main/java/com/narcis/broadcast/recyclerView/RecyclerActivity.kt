package com.narcis.broadcast.recyclerView

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.narcis.broadcast.databinding.ActivityRecyclerBinding

class RecyclerActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivityRecyclerBinding

    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityRecyclerBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        layoutManager = LinearLayoutManager(this)
        mBinding.recyclerList.layoutManager = layoutManager
        adapter = RecyclerAdapter()
        mBinding.recyclerList.adapter = adapter
    }
}
