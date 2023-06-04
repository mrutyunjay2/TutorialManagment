package com.rs.rsapplication.UI

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.lifecycle.ViewModelProviders
import com.rs.rsapplication.MainActivity
import com.rs.rsapplication.R
import com.rs.rsapplication.Room.RegistrationData
import com.rs.rsapplication.UI.Registration.RegistrationModuleViewmodel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import mtj.example.vmapplication.Base.BaseFragment


class RegistrationModuleFragment() : BaseFragment() {

    private lateinit var rvm: RegistrationModuleViewmodel
   var standard:String? = null


    //private lateinit var adapter: NoteAdapter
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
        rvm = ViewModelProviders.of(this)[RegistrationModuleViewmodel::class.java]
      /*  rvm.getAllNotes().observe(this, Observer {
            Log.i("Observed data", "$it")
    })*/

      val register =   view.findViewById(R.id.idBtnRegister) as Button
        register.setOnClickListener {
            saveStudentData()
        }


    }

    private fun saveStudentData(){

        var fName : EditText? = view?.findViewById(R.id.idEdtStudentFirstName)
        var lName :EditText? = view?.findViewById(R.id.idEdtStudentLastName)
        var email :EditText? = view?.findViewById(R.id.idEdtStudentEmail)
        //var className :EditText? = view?.findViewById(R.id.idEdtStudentFirstName)
        var mobNo :EditText? = view?.findViewById(R.id.idEdtStudentMob)
        var genderRadioGroup: RadioGroup? = view?.findViewById(R.id.genderRadioGroup)
        lateinit var selectedRadioButtonGender: RadioButton
        var boardRadioGroup :RadioGroup? = view?.findViewById(R.id.boardRadioGroup)
        lateinit var selectedRadioButtonBoard: RadioButton


        val fnameStr = fName?.text.toString()
        val lnameStr = lName?.text.toString()
        val emailStr = email?.text.toString()
        val mobNoStr = mobNo?.text.toString()
        val selectedRadioButtonIdGender: Int = genderRadioGroup?.checkedRadioButtonId!!
        val selectedRadioButtonIdBoard: Int = boardRadioGroup?.checkedRadioButtonId!!
        var genderStr: String? = null
        var boardStr: String? = null
        if (selectedRadioButtonIdGender != -1) {
            selectedRadioButtonGender = view?.findViewById(selectedRadioButtonIdGender)!!
             genderStr = selectedRadioButtonGender?.text.toString()
        }
        else {
            genderStr = "-1"
        }
        if (selectedRadioButtonIdBoard != -1) {
            selectedRadioButtonBoard = view?.findViewById(selectedRadioButtonIdBoard)!!
            boardStr = selectedRadioButtonBoard?.text.toString()
        }
        else {
            boardStr = "-1"
        }

       val res=GlobalScope.launch(Dispatchers.Main) {
           val result =
           rvm.insert(RegistrationData(firstName = fnameStr, lastName = lnameStr, email = emailStr, mobNo = mobNoStr, gender = genderStr, boardType = boardStr, standard =standard!! ))
          Log.d(TAG, result.toString())
           if (result!= -1L){
               fName?.setText("")
               lName?.setText("")
               mobNo?.setText("")
               email?.setText("")
               Toast.makeText(activity,"Registration Done Successfully with id $result",Toast.LENGTH_LONG).show()
           }
       }


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
                standard = (classNames[p2]).toString()
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {

            }
        }

    }


}