package com.rs.rsapplication.UI

import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.LinearLayout
import android.widget.Spinner
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rs.rsapplication.MainActivity
import com.rs.rsapplication.R
import com.rs.rsapplication.UI.adapter.AttendanceDeatilsAdapter
import mtj.example.vmapplication.Base.BaseFragment

class RegistrationModuleFragment() : BaseFragment() {
    companion object{
        const val TAG = "RegistrationFragment"

        fun newInstance(): RegistrationModuleFragment {
            val args = Bundle()
            val fragment = RegistrationModuleFragment()
            fragment.arguments = args
            return fragment
        }
    }


    override fun provideLayoutId(): Int = R.layout.regpage_admin
    override fun setupView(view: View) {
        Log.d(TAG,"ViewCreated")
    }

    override fun setupObservers() {
        TODO("Not yet implemented")
    }



    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val classNames = resources.getStringArray(R.array.class_name)
        val spinner = view?.findViewById<Spinner>(R.id.spinner) as Spinner

        val adapter: ArrayAdapter<String> = ArrayAdapter<String>(
            activity as MainActivity,
            android.R.layout.simple_spinner_item,classNames)

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.setAdapter(adapter)
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {

            }
            override fun onNothingSelected(p0: AdapterView<*>?) {

            }
        }

    }


}