package com.example.taskmanagercompose

import android.util.Log
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

private const val TAG = "UtilsXX"

object Utils {

    fun getCurrentDate(): String {
        val date = Date()

        val formatter = SimpleDateFormat("MM dd yyyy", Locale.getDefault())
        val formattedDate = formatter.format(date)

        val monthDecimal = formattedDate.removeRange(2, formattedDate.length)
        val monthSName = getMonth(monthDecimal)
        val result = formattedDate.replaceRange(0, 2, monthSName)

        val dayFormat = SimpleDateFormat("EEEE", Locale.getDefault())
        Log.d(TAG, "getCurrentDate: $result")
        val day = dayFormat.format(date)
        return "$day, $result"
    }

    private fun getMonth(month: String): String {
        return when (month) {
            "01" -> {
                "Jan"
            }

            "02" -> {
                "Feb"
            }

            "03" -> {
                "Mar"
            }

            "04" -> {
                "April"
            }

            "05" -> {
                "May"
            }

            "06" -> {
                "June"
            }

            "07" -> {
                "July"
            }

            "08" -> {
                "Aug"
            }

            "09" -> {
                "Sep"
            }

            "10" -> {
                "Oct"
            }

            "11" -> {
                "Nov"
            }

            else -> {
                "Dec"
            }
        }
    }

    fun getList(): List<TaskEntity> {
        return mutableListOf(
            TaskEntity(R.color.selectedColor, R.drawable.ui_icon, "UI Design", "10 Days", 0.5F),
            TaskEntity(R.color.laravelColor,R.drawable.laravel_icon, "Laravel Task", "20 Days", 0.3F),
            TaskEntity(R.color.editorColor,R.drawable.pinterest_icon, "Edit Picture", "30 Days", 0.8F),
        )

    }
}