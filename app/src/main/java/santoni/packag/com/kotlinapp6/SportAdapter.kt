package santoni.packag.com.kotlinapp6

import android.content.Context
import android.content.Intent
import android.support.v4.content.ContextCompat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.sport_item.view.*

class SportAdapter: BaseAdapter {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        var sport: Sport = sportDatabase?.sports?.get(position) ?: Sport("no Name", "No Detail",
                R.drawable.placeholder)
        var inflater = context?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        var sportItem = inflater.inflate(R.layout.sport_item, null)
        sportItem.sportImage.setImageResource(sport.sportImage ?: R.drawable.placeholder)
        sportItem.sportName.setText(sport.sportName)

        sportItem.setOnClickListener {

            val detailIntent = Intent(context, SportDetailActivity::class.java)
            detailIntent.putExtra("image", sport.sportImage)
            detailIntent.putExtra("detail", sport.sportDetail)
            ContextCompat.startActivity(context!!, detailIntent, null)

        }

        return sportItem

    }

    override fun getItem(position: Int): Any {

        return sportDatabase?.sports?.get(position) ?: Sport("No Name", "No Detail", R.drawable.placeholder)

    }

    override fun getItemId(position: Int): Long {

        return position.toLong()

    }

    override fun getCount(): Int {
        return sportDatabase?.sports?.size ?: 0

    }

    private var context: Context? = null
    private var sportDatabase: SportDatabase? = null

    constructor(context: Context) {

        this.context = context
        sportDatabase = SportDatabase()

    }



}