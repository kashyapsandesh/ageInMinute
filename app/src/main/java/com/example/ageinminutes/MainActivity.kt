package com.example.ageinminutes

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.DatePicker
import android.widget.TextView
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        var selectedDate=findViewById<Button>(R.id.datePicker)
        selectedDate.setOnClickListener{view->
            clickedDatePicker(view)

        }

    }
     fun clickedDatePicker(view:View){
        val myCalendar=Calendar.getInstance()
        val year=myCalendar.get(Calendar.YEAR)
        val month=myCalendar.get(Calendar.MONTH)
        val day=myCalendar.get(Calendar.DAY_OF_MONTH)

        DatePickerDialog(
            this,
            DatePickerDialog.OnDateSetListener{view,selectedYear,selectedMonth,selectedDay->
//                Toast.makeText(this,"The selected date is ${selectedMonth+1}/${selectedYear}/${selecedDay}",Toast.LENGTH_LONG).show();
                val selectedDate="${selectedDay}/${selectedMonth+1}/${selectedYear}";
                var dateText=findViewById<TextView>(R.id.tvSelectedDate);
                dateText.setText(selectedDate);
                var sdf=SimpleDateFormat("dd/mm/yyyy", Locale.ENGLISH);
                var theDate=sdf.parse(selectedDate);
                val selectedDateINMinutes=theDate!!.time/60000;
                Toast.makeText(this," ${selectedDateINMinutes}}",Toast.LENGTH_LONG).show();

                val currentDate=sdf.parse(sdf.format(System.currentTimeMillis()))
                val currentDateToMinutes=currentDate!!.time/60000;
                Toast.makeText(this," ${currentDateToMinutes}}",Toast.LENGTH_LONG).show();
                val differenceInMinutes=currentDateToMinutes-selectedDateINMinutes;
                val dateInMin=findViewById<TextView>(R.id.tvSelectedDateInMinute);
                dateInMin.setText(differenceInMinutes.toString());

            },year,month,day
        ).show()

    }
}