package cowma.katotama.agecalchumanandanimal

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CalendarView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnDataPicker.setOnClickListener {view ->
            clickDatePicker(view)
        }
    }

    fun clickDatePicker(view: View){

        val myCalendar = Calendar.getInstance()
        val year = myCalendar.get(Calendar.YEAR)
        val month = myCalendar.get(Calendar.MONTH)
        val dayOfMonth = myCalendar.get(Calendar.DAY_OF_MONTH)

        val dpd = DatePickerDialog(
            this,DatePickerDialog.OnDateSetListener {
                    view, selectedYear, selectedMonth, selectedDay ->
                val selectedDate = "${selectedYear}/${selectedMonth+1}/${selectedDay}"
               textDate.setText(selectedDate)

                //born date
                val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)
                val theDate = sdf.parse(selectedDate)
                Toast.makeText(this,"the date is $sdf", Toast.LENGTH_LONG).show()

                val selectedDateInMinute = theDate!!.time / 60000

                //current date
                val currentDate = sdf.parse(sdf.format(System.currentTimeMillis()))
                val currentDateInMinute = currentDate!!.time / 60000

                //differenceDate
                val differenceMinute = (currentDateInMinute - selectedDateInMinute) / ( 60 * 24 )

                textDifferenceInMinute.setText(differenceMinute.toString())

            }
            ,year,month,dayOfMonth)


        dpd.datePicker.setMaxDate(Date().time - 86400000)
        dpd.show()

    }
}
