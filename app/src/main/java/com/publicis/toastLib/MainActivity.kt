package com.publicis.toastLib

import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.bsd.toastylibrary.ToastyLib
import com.bsd.toastylibrary.ToastyLib.Type
import com.publicis.toastLib.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var toastLibSuccess: ToastyLib
    private lateinit var toastLibDefault: ToastyLib
    private lateinit var toastLibWarning: ToastyLib
    private lateinit var toastLibInfo: ToastyLib


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)
        initToasts()

    }

   private fun initToasts() {
        toastLibSuccess = ToastyLib()
        toastLibSuccess.seTintColor("#000000")
        toastLibSuccess.setBackgroundColor("#ffddffbb")
       toastLibDefault = ToastyLib()
       toastLibWarning = ToastyLib()
       toastLibInfo = ToastyLib()


    }


    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    fun showToastSuccess(view: View) {
        toastLibSuccess.make(
            mContext = this,
            message = "TOAST SUCCESS",
            duration = ToastyLib.LONG,
            type = Type.SUCCESS
        )

    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    fun showToastDefault(view: View) {
        toastLibDefault.make(this, "TOAST DEFAULT", ToastyLib.LONG, Type.DEFAULT)

    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    fun showToastWarning(view: View) {
        toastLibWarning.make(this, "TOAST WARNING", ToastyLib.LONG, Type.WARNING)

    }


    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    fun showToastInfo(view: View) {
        toastLibInfo.make(this, "TOAST INFO", ToastyLib.SHORT, Type.INFO)

    }


}