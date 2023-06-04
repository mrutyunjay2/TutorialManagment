package com.rs.rsapplication

import android.os.Bundle
import android.view.View
import android.widget.FrameLayout
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.rs.rsapplication.UI.AttendanceModuleFragment
import com.rs.rsapplication.UI.RegistrationModuleFragment

class MainActivity : AppCompatActivity(),View.OnClickListener {
    private var activeFragment: Fragment? = null
    lateinit var mToolbar:Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.homescreen)
        mToolbar =  findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        supportActionBar?.setDisplayHomeAsUpEnabled(true);
        supportActionBar?.setDisplayShowHomeEnabled(true);
        supportActionBar?.setTitle("Tutorial ManagMent");
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
            R.id.toolbar->{
                onBackPressed()
            }

        }
    }
    override fun onBackPressed() {
        if (supportFragmentManager.getBackStackEntryCount() > 0) {
            getFragmentManager().popBackStack();
            return;
        }
        super.onBackPressed()
    }
}