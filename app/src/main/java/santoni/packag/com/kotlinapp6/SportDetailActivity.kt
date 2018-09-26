package santoni.packag.com.kotlinapp6

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_sport_detail.*

class SportDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sport_detail)

        val receiverData = intent.extras

        val sportImage = receiverData.getInt("image")
        val sportDetail = receiverData.getString("detail")

        detailImage.setImageResource(sportImage)
        detailText.text = sportDetail


    }
}
