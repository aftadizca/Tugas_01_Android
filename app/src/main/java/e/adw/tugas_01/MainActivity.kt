package e.adw.tugas_01

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import java.io.Serializable

const val inputMahasiswa = "DataMahasiswa"

class MainActivity : AppCompatActivity() {

    private lateinit var submit:Button
    private lateinit var nama: EditText
    private lateinit var universitas:EditText
    private lateinit var jurusan:Spinner
    private lateinit var kelaminGroup: RadioGroup

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

        jurusan.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                p1 as TextView
                if(p2>0) p1.setTextColor(Color.BLACK) else{
                    p1.setTextColor(ContextCompat.getColor(applicationContext,R.color.colorHint))
                }

            }
        }
    }

    fun submitBtn(view: View){

        val idSelectedKelamin = kelaminGroup.checkedRadioButtonId
        val kelamin = findViewById<RadioButton>(idSelectedKelamin)
        val dataMahasiswa = Mahasiswa.DataMahasiswa(nama.text.toString(), universitas.text.toString(), jurusan.selectedItem.toString(),kelamin.text.toString())

        //cek jika form terisi lengkap
        if(!nama.text.toString().trim().isEmpty() && !universitas.text.toString().trim().isEmpty() && jurusan.selectedItemPosition != 0 ){
            val intent = Intent(this,ShowDataMahasiswa::class.java).apply {
                putExtra(inputMahasiswa, dataMahasiswa as Serializable)
            }
            startActivity(intent) //open other page
        }else{
            CostumDialog(this,CostumDialog.DIALOG_RED,"Please fill form!!").showDialog()
        }
    }

}
