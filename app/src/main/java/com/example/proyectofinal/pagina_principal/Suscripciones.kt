import com.example.proyectofinal.R
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.MaterialAutoCompleteTextView
class Suscripciones : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_suscripciones)

        val btnBack = findViewById<ImageButton>(R.id.btnBack)
        btnBack.setOnClickListener {
            finish() // Cierra la actividad actual
        }

        val subscription = findViewById<MaterialAutoCompleteTextView>(R.id.actSubscription)
        val type = findViewById<MaterialAutoCompleteTextView>(R.id.actType)
        val account = findViewById<MaterialAutoCompleteTextView>(R.id.actAccount)

        val subsAdapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            listOf("Netflix", "Spotify", "Disney+")
        )

        val typeAdapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            listOf("1 mes", "3 meses", "1 año")
        )

        val accountAdapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            listOf("Principal", "Ahorros")
        )

        subscription.setAdapter(subsAdapter)
        type.setAdapter(typeAdapter)
        account.setAdapter(accountAdapter)
    }
}
