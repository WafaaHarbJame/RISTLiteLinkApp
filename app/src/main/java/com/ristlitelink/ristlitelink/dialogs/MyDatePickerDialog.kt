package com.ristlitelink.ristlitelink.dialogs

import android.app.Activity
import android.app.DatePickerDialog
import android.content.Context
import android.widget.DatePicker
import com.ristlitelink.ristlitelink.R
import com.ristlitelink.ristlitelink.Utils.DateHandler
import com.ristlitelink.ristlitelink.apiHandler.DataFetcherCallBack

import java.util.*

class MyDatePickerDialog(
    var activity: Context,
    var dataFetcherCallBack: DataFetcherCallBack?
) {
    var datePickerDialog: DatePickerDialog? = null

    var selectedYear = 0
    var selectedMonth = 0
    var selectedDay = 0
    var maxDate: Long = 0

    private val dialog: MyDatePickerDialog
        get() = this

    init {

        initDates()

        datePickerDialog = DatePickerDialog(
            activity,
            R.style.MyDatePickerDialogTheme,
            { datePicker: DatePicker?, year: Int, month: Int, dayOfMonth: Int ->
                selectedYear = year
                selectedMonth = month
                selectedDay = dayOfMonth
                val date =
                    selectedYear.toString() + "-" + (selectedMonth + 1) + "-" + selectedDay
                dataFetcherCallBack?.Result(
                    DateHandler.FormatDate4(
                        date,
                        "yyyy-MM-dd",
                        "yyyy-MM-dd"
                    ), "", true
                )
            }, selectedYear, selectedMonth, selectedDay
        )
        datePickerDialog?.datePicker?.maxDate = maxDate
        datePickerDialog?.show()
        datePickerDialog?.datePicker?.touchables!![0].performClick()


    }

    private fun initDates() {

        val c = Calendar.getInstance()
        c.add(Calendar.HOUR_OF_DAY, 1)
        maxDate = c.time.time - 60000
        c[Calendar.YEAR] = 1990
        selectedYear = c[Calendar.YEAR]
        selectedMonth = c[Calendar.MONTH]
        selectedDay = c[Calendar.DAY_OF_MONTH]

    }

}
