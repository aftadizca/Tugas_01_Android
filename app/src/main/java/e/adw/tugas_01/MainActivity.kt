package e.adw.tugas_01

import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.spinner_dropdown_item.*
import java.io.Serializable

const val inputMahasiswa = "DataMahasiswa"

class MainActivity : AppCompatActivity() {

    lateinit var submit:Button
    lateinit var nama: EditText
    lateinit var universitas:EditText
    lateinit var jurusan:Spinner
    lateinit var kelaminGroup: RadioGroup

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        submit = findViewById(R.id.button4)
        nama = findViewById(R.id.namaInput)
        universitas = findViewById(R.id.univInput)
        jurusan = findViewById(R.id.jurusanInput)
        kelaminGroup = findViewById(R.id.kelaminGroup)

        //create list in spinner
        val adapter = ArrayAdapter.createFromResource(this,R.array.jurusan_array,R.layout.spinner_item)
        adapter.setDropDownViewResource(R.layout.spinner_dropdown_item)
        jurusan.adapter = adapter

        jurusan?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                p1 as TextView
                if(p2>0){
                    p1.setTextColor(Color.BLACK)
                }else{
                    p1.setTextColor(ContextCompat.getColor(applicationContext,R.color.colorHint))
                }

            }
        }
    }

    fun Submit(view: View){

        val idSelectedKelamin = kelaminGroup.checkedRadioButtonId
        val kelamin = findViewById<RadioButton>(idSelectedKelamin)

        val dataMahasiswa = Mahasiswa.DataMahasiswa(nama.text.toString(), universitas.text.toString(), jurusan.selectedItem.toString(),kelamin.text.toString())

        //jika form terisi lengkap
        if(!nama.text.toString().trim().isEmpty() && !universitas.text.toString().trim().isEmpty() && !jurusan.selectedItem.toString().trim().isEmpty() ){
            Toast.makeText(applicationContext, dataMahasiswa.toString() ,Toast.LENGTH_LONG).show()
            val intent = Intent(this,ShowDataMahasiswa::class.java).apply {
                putExtra(inputMahasiswa, dataMahasiswa as Serializable)
            }
            startActivity(intent)
        }else{
            Toast.makeText(applicationContext, "Please fill form!!!!" ,Toast.LENGTH_LONG).show()
        }

    }
}
