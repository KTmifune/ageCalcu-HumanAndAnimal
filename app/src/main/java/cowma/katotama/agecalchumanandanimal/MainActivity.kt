package cowma.katotama.agecalchumanandanimal

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnDataPicker.setOnClickListener {view ->
            clickDatePicker(view)
            Toast.makeText(this,"Button works", Toast.LENGTH_SHORT).show()
        }
    }

    fun clickDatePicker(view: View){
        DetePickeDialog(this,DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->  })

    }
}
