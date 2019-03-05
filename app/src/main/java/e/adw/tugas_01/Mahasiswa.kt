package e.adw.tugas_01

import java.io.Serializable

class Mahasiswa {

    data class DataMahasiswa(var nama:String, var univ:String, var jurusan:String, var kelamin:String):Serializable
}