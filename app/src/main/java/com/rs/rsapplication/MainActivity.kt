package com.rs.rsapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import com.rs.rsapplication.UI.AttendanceModuleFragment
import com.rs.rsapplication.UI.RegistrationModuleFragment

class MainActivity : AppCompatActivity(),View.OnClickListener {
    private var activeFragment: Fragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.homescreen)
        val attendance:CardView = findViewById(R.id.attendance)
        val reg:CardView = findViewById(R.id.reg)
        val exam:CardView = findViewById(R.id.exam)
      //  val report:CardView = findViewById(R.id.report)
        attendance.setOnClickListener(this)
        reg.setOnClickListener(this)
        exam.setOnClickListener(this)
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
    private fun showRegistrationModule() {
        if (activeFragment is RegistrationModuleFragment) return
        val fragmentTransaction = supportFragmentManager.beginTransaction()

        var fragment = supportFragmentManager.findFragmentByTag(RegistrationModuleFragment.TAG) as RegistrationModuleFragment?

        if (fragment == null) {
            fragment = RegistrationModuleFragment.newInstance()
            fragmentTransaction.add(R.id.containerFragment, fragment, RegistrationModuleFragment.TAG)
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
        when(v?.id){
            R.id.attendance->{
                showAttendanceModule()
            }
            R.id.reg->{
                showRegistrationModule()
            }

        }
    }
}