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

class AttendanceModuleFragment() : BaseFragment() {
    companion object{
        const val TAG = "EmpDetailsFragment"

        fun newInstance(): AttendanceModuleFragment {
            val args = Bundle()
            val fragment = AttendanceModuleFragment()
            fragment.arguments = args
            return fragment
        }
    }


    override fun provideLayoutId(): Int = R.layout.attendance_fragment_layout
    override fun setupView(view: View) {
        Log.d(TAG,"ViewCreated")
    }

    override fun setupObservers() {
        TODO("Not yet implemented")
    }

    fun getStudentDetils(){
        var list = listOf<PeopleResponse>(
             PeopleResponse(1,"","8309096963","Jay","Senapati","dnjan@gmail.com","Home","Active"),
        PeopleResponse(2,"","8309096963","Jay","Senapati","dnjan@gmail.com","Home","Active"),
        PeopleResponse(3,"","8309096963","Jay","Senapati","dnjan@gmail.com","Home","Active"),
        PeopleResponse(4,"","8309096963","Jay","Senapati","dnjan@gmail.com","Home","Active"))

        val adapter = AttendanceDeatilsAdapter(list)
        val studentrecycle = view?.findViewById<RecyclerView>(R.id.studentRecycle)
        studentrecycle?.layoutManager = LinearLayoutManager(activity)
        studentrecycle?.adapter = adapter
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val languages = resources.getStringArray(R.array.class_name)
        val spinner = view?.findViewById<Spinner>(R.id.spinner) as Spinner
        val studentrecycle = view?.findViewById<RecyclerView>(R.id.studentRecycle)
        if (studentrecycle != null) {
            studentrecycle.visibility= View.GONE
        }
        val adapter: ArrayAdapter<String> = ArrayAdapter<String>(
            activity as MainActivity,
            android.R.layout.simple_spinner_item,languages)

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.setAdapter(adapter)
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                if(p2==2){
                    if (studentrecycle != null) {
                        studentrecycle.visibility= View.VISIBLE
                    }
                    getStudentDetils()
                }
                else{
                    if (studentrecycle != null) {
                        studentrecycle.visibility= View.GONE
                    }
                }

            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

        }

    }


}