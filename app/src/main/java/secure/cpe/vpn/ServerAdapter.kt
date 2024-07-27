package secure.cpe.vpn

import android.annotation.SuppressLint
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.Date
import kotlin.random.Random

class ServerAdapter(var activity: ConnectActivity, var list: MutableList<ServerModel>): RecyclerView.Adapter<ServerAdapter.ServerVH>() {

    class ServerVH(view: View): RecyclerView.ViewHolder(view) {
        var flag: ImageView = view.findViewById(R.id.slImage)
        var country: TextView = view.findViewById(R.id.slName)
        var ip: TextView = view.findViewById(R.id.slIp)
        var speed: ImageView = view.findViewById(R.id.slSpeed)
    }

    val random = Random(Date().time)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ServerVH {
        return ServerVH(LayoutInflater.from(parent.context).inflate(R.layout.server_layout, parent, false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onBindViewHolder(holder: ServerVH, position: Int) {

        holder.speed.setImageDrawable(activity.getDrawable(Config.generateSpeed()))
        holder.flag.setImageDrawable(activity.getDrawable(list[position].flag))
        holder.ip.text = list[position].ip
        holder.country.text = list[position].name

        holder.itemView.setOnClickListener {
            activity.setSelectedServer(list[position])
        }

    }

}