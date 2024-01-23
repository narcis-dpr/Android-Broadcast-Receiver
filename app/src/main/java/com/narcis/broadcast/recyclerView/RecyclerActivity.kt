package com.narcis.broadcast.recyclerView

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.narcis.broadcast.databinding.ActivityRecyclerBinding

class RecyclerActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivityRecyclerBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityRecyclerBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

    }
}
