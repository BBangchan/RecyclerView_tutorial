package com.example.recyclerview_tutorial

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class MyRecyclerAdapter(myRecyclerviewInterface: MyRecyclerviewInterface) : RecyclerView.Adapter<MyViewHolder>() {

    val TAG: String = "로그"

    private var modelList = ArrayList<MyModel>()

    private var myRecyclerviewInterface  : MyRecyclerviewInterface? = null

    // 생성자
    init {
        this.myRecyclerviewInterface  = myRecyclerviewInterface
    }

    // 뷰홀더가 생성 되었을때
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        // 연결할 레이아웃 설정

        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.layout_recycler_item,parent,false), this.myRecyclerviewInterface !!)
    }

    // 뷰와 뷰홀더가 묶였을때 ( 재활용 됬을 때)
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        Log.d(TAG,"MyRecycler - onBindViewHolder() called / position :$position")
        holder.bind(this.modelList[position])
        // 클릭 리스너 설정
        //holder.itemView.setOnClickListener {
        //    Toast.makeText(App.instance, "클릭됨! ${this.modelList[position].name}",Toast.LENGTH_SHORT).show()
        //}
    }

    // 목록의 아이템수
    override fun getItemCount(): Int {
        return this.modelList.size
    }

    // 외부에서 데이터 넘기기
    fun submitList(modelList: ArrayList<MyModel>){
        this.modelList = modelList
    }
}