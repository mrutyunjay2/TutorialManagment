package com.rs.rsapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.rs.rsapplication.UI.AttendanceModuleFragment

class MainActivity : AppCompatActivity(),OnClickListener {
    private var activeFragment: Fragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.homescreen)
       var text:TextView = findViewById(R.id.textGrid)
        text.setOnClickListener {
            showAttendanceModule()
        }

    }




    private fun showAttendanceModule() {
        if (activeFragment is AttendanceModuleFragment) return
        val fragmentTransaction = supportFragmentManager.beginTransaction()

        var fragment = supportFragmentManager.findFragmentByTag(AttendanceModuleFragment.TAG) as AttendanceModuleFragment?

        if (fragment == null) {
            fragment = AttendanceModuleFragment.newInstance()
            fragmentTransaction.add(R.id.containerFragment, fragment, AttendanceModuleFragment.TAG)
           val frameLayout:FrameLayout = findViewById(R.id.containerFragment)
           val mainGridLayout:LinearLayout = findViewById(R.id.mainGrid)
            frameLayout.visibility = View.VISIBLE
            mainGridLayout.visibility = View.GONE
        } else {
            fragmentTransaction.show(fragment)
        }

        if (activeFragment != null) fragmentTransaction.hide(activeFragment as Fragment)

        fragmentTransaction.commit()

        activeFragment = fragment
    }
    private fun showExamModule() {
       // Log.d(TAG,"ViewCreated")
    }

    override fun onClick(v: View?) {

        when(v?.getId()){
            R.id.attendance->showAttendanceModule()

        }
    }
}