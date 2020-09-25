package com.bsd.toastylibrary
import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.cardview.widget.CardView


/**
 * Created by Aya Boussaadia on 23,September,2020
 */
class ToastyLib {

    private var color : Int = -0x1000000
    private var colorBackground : Int = -0x1

    companion object {
        var LONG = Toast.LENGTH_LONG
        var SHORT = Toast.LENGTH_SHORT

    }

    enum class Type {
        SUCCESS,
        INFO,
        WARNING,
        DEFAULT
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    fun make(mContext: Context, message: String, duration: Int, type: Type  ) {
        makeToast(mContext, message, duration, type)

    }


    @SuppressLint("UseCompatLoadingForDrawables")
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    fun makeToast(mContext: Context, message: String, duration: Int, type: Type){
        val toast = Toast(mContext)
        val inflater = LayoutInflater.from(mContext)
        val view: View = inflater.inflate(R.layout.custom_toast, null)
        val toastText = view.findViewById(R.id.toast_msg) as TextView
        val toastIcon = view.findViewById(R.id.toast_image) as ImageView
        toastIcon.setColorFilter(color)
        val container = view.findViewById(R.id.container) as CardView
        toastText.setTextColor(color)
        container.backgroundTintMode
        container.setBackgroundColor(colorBackground)

        when(type){
            Type.WARNING -> toastIcon.setImageDrawable(mContext.getDrawable(R.drawable.ic_baseline_warning_24))
            Type.SUCCESS -> toastIcon.setImageDrawable(mContext.getDrawable(R.drawable.ic_baseline_check_circle_24))
            Type.INFO -> toastIcon.setImageDrawable(mContext.getDrawable(R.drawable.ic_baseline_info_24))
            Type.DEFAULT -> toastIcon.visibility = View.GONE

        }

        toastText.text = message
        toast.view = view
        toast.duration = duration
        toast.show()

    }

    fun seTintColor(hexColor: String) : Int {
        color = Color.parseColor(hexColor)
        return color
    }

    fun setBackgroundColor(hexColor: String) : Int {
        colorBackground = Color.parseColor(hexColor)
        return colorBackground
    }



}

