package e.adw.tugas_01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class ShowDataMahasiswa : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_data_mahasiswa)

        val dataMahasiswa = intent.extras.get("DataMahasiswa") as Mahasiswa.DataMahasiswa

        Toast.makeText(this,"Nama : ${dataMahasiswa.nama} Universitas : ${dataMahasiswa.univ} Jurusan : ${dataMahasiswa.jurusan} Kelamin : ${dataMahasiswa.kelamin}",Toast.LENGTH_LONG).show()

    }
}
