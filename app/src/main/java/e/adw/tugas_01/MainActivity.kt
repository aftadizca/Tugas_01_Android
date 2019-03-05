package e.adw.tugas_01

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import java.io.Serializable

const val inputMahasiswa = "DataMahasiswa"

class MainActivity : AppCompatActivity() {

    lateinit var submit:Button
    lateinit var nama: EditText
    lateinit var universitas:EditText
    lateinit var jurusan:EditText
    lateinit var kelaminGroup: RadioGroup

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        submit = findViewById(R.id.button4)
        nama = findViewById(R.id.namaInput)
        universitas = findViewById(R.id.univInput)
        jurusan = findViewById(R.id.jurusanInput)
        kelaminGroup = findViewById(R.id.kelaminGroup)
    }

    fun Submit(view: View){

        val idSelectedKelamin = kelaminGroup.checkedRadioButtonId
        val kelamin = findViewById<RadioButton>(idSelectedKelamin)

        val dataMahasiswa = Mahasiswa.DataMahasiswa(nama.text.toString(), universitas.text.toString(), jurusan.text.toString(),kelamin.text.toString())

        //jika form terisi lengkap
        if(!nama.text.toString().trim().isEmpty() && !universitas.text.toString().trim().isEmpty() && !jurusan.text.toString().trim().isEmpty() ){
            Toast.makeText(applicationContext, dataMahasiswa.toString() ,Toast.LENGTH_LONG).show()
            val intent = Intent(this,ShowDataMahasiswa::class.java).apply {
                putExtra(inputMahasiswa, dataMahasiswa as Serializable)
            }
            startActivity(intent)
        }else{
            Toast.makeText(applicationContext, "Please fill form!" ,Toast.LENGTH_LONG).show()
        }

    }
}
