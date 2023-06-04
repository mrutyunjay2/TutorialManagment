package com.rs.rsapplication.UI.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.rs.rsapplication.R
import com.rs.rsapplication.Room.RegistrationData

class AttendanceDeatilsAdapter (private var dataList: List<RegistrationData>): RecyclerView.Adapter<AttendanceDeatilsAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.cards_layout, parent, false)

        return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val ItemsViewModel = dataList[position]
        holder.name.text = "Name :" +ItemsViewModel.firstName + ItemsViewModel.lastName
        holder.mob.text =  "Mob.No :" +ItemsViewModel.mobNo
        holder.email.text = "Email :" + ItemsViewModel.email

    }

    override fun getItemCount(): Int = dataList.size


    class ViewHolder(itemLayoutView: View) : RecyclerView.ViewHolder(itemLayoutView) {
        val slNo: TextView = itemView.findViewById(R.id.SNoTv)
        val name: TextView = itemView.findViewById(R.id.name)
        val jobTitle: TextView = itemView.findViewById(R.id.jobTitle)
        val mob: TextView = itemView.findViewById(R.id.mobile_no)
        val email: TextView = itemView.findViewById(R.id.email)


    }
}