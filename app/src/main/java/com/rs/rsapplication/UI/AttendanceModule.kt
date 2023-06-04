package com.rs.rsapplication.UI

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rs.rsapplication.MainActivity
import com.rs.rsapplication.R
import com.rs.rsapplication.UI.Registration.RegistrationModuleViewmodel
import com.rs.rsapplication.UI.adapter.AttendanceDeatilsAdapter
import mtj.example.vmapplication.Base.BaseFragment

class AttendanceModuleFragment() : BaseFragment() {
    private lateinit var rvm: RegistrationModuleViewmodel
    lateinit var mToolbar: Toolbar

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

    }

    override fun setupObservers() {
        TODO("Not yet implemented")
    }

    fun getStudentDetils(stand:String){
        val studentrecycle = view?.findViewById<RecyclerView>(R.id.studentRecycle)
        studentrecycle?.layoutManager = LinearLayoutManager(activity)
        rvm.getStudentsBasedonClass(stand).observe(this, Observer {
            val adapter = AttendanceDeatilsAdapter(it)
            studentrecycle?.adapter = adapter
        })




    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val classNames = resources.getStringArray(R.array.class_name)
        val spinner = view?.findViewById<Spinner>(R.id.spinner) as Spinner
        val studentrecycle = view?.findViewById<RecyclerView>(R.id.studentRecycle)
        rvm = ViewModelProviders.of(this)[RegistrationModuleViewmodel::class.java]
        if (studentrecycle != null) {
            studentrecycle.visibility= View.GONE
        }
        val adapter: ArrayAdapter<String> = ArrayAdapter<String>(
            activity as MainActivity,
            android.R.layout.simple_spinner_item,classNames)

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.setAdapter(adapter)
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                if (studentrecycle != null) {
                    studentrecycle.visibility= View.VISIBLE
                    val standard = (classNames[p2]).toString()
                    getStudentDetils(standard)
                }




            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

        }

    }


}