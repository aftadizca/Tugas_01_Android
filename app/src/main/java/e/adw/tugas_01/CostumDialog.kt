package e.adw.tugas_01

import android.animation.ObjectAnimator
import android.app.AlertDialog
import android.content.Context
import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.WindowManager
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat.getSystemService


class CostumDialog @JvmOverloads constructor(ctx: Context?, themeId:Int, msg:String) : AlertDialog.Builder(ctx, R.style.CostumDialog) {

    companion object {
        const val DIALOG_DEF = R.layout.popup_layout_default
        const val DIALOG_RED = R.layout.popup_layout_red
    }
    private val view: View = LayoutInflater.from(ctx).inflate(themeId,null)
    private lateinit var ad:AlertDialog
    private val okButton = view.findViewById<Button>(R.id.okBtn)
    private val msgText = view.findViewById<TextView>(R.id.msgPopUp)

    init {
        setView(view)
        msgText.text = msg
        okButton.setOnClickListener {
            ad.dismiss()
        }
    }

    fun showDialog(){
        ad = this.show()
        ad.setCanceledOnTouchOutside(false)
    }

}