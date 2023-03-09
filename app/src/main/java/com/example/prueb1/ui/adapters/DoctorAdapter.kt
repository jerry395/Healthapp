package com.example.prueb1.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.prueb1.data.models.DoctorItemModel
import com.example.prueb1.interfaces.OnDoctorClickListener
import com.example.prueb1.databinding.ItemDoctorBinding

class DoctorAdapter(var list: List<DoctorItemModel>): RecyclerView.Adapter<DoctorAdapter.ViewHolder>() {

    var listener: OnDoctorClickListener?= null

    class ViewHolder(val item: ItemDoctorBinding): RecyclerView.ViewHolder(item.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(ItemDoctorBinding.inflate(inflater,parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val doctor = list[position]
        holder.item.itemDoctorName.text = doctor.name
        holder.item.itemDoctorSpecialist.text = doctor.Speciality
        holder.item.itemDoctorSummary.text = doctor.caption
        holder.item.itemDoctorImage.setImageResource(doctor.image.toInt())
        holder.item.itemDoctorStar.rating = (doctor.star / 5.0).toFloat()
        holder.item.root.setOnClickListener {
            listener?.onClick(doctor)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun updateDataset(list: List<DoctorItemModel>){
        this.list=list
        notifyDataSetChanged()
    }

}