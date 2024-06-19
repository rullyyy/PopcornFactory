package luna.raul.popcornfactory

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MovieDetail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_movie_detail)

        var header: ImageView = findViewById(R.id.movie_header)
        var movieTitle: TextView = findViewById(R.id.movie_title_detail)
        var desc: TextView = findViewById(R.id.movie_desc)
        val seatsLeft: TextView = findViewById(R.id.seatsLeft)
        val buyTickets: Button = findViewById(R.id.buyTickets)
        var ns = 0
        val content = intent.extras
        var id = -1;
        var title = ""

        if (content != null) {

            ns = content.getInt("numberSeats")
            id = content.getInt("pos")
            header.setImageResource(content!!.getInt("header"))
            movieTitle.setText(content.getString("titulo"))
            desc.setText(content.getString("sinopsis"))
            seatsLeft.setText("$ns seats available")
        }

        if (ns == 0) {
            buyTickets.isEnabled = false
        } else {
            buyTickets.setOnClickListener {
                val intent: Intent = Intent(this, SeatSelection::class.java)

                intent.putExtra("id", id)
                intent.putExtra("titulo", title)


                this.startActivity(intent)

            }
        }
    }
}