package com.example.hikerapp1
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

data class HikingTrail(
    val name: String,
    val difficulty: String,
    val distance: Double,
    val elevationGain: Double,
    val estimatedTime: String,


    // Add other properties as needed
)

class HikingTrailAdapter(private val hikingTrails: List<HikingTrail>) :
    RecyclerView.Adapter<HikingTrailAdapter.ViewHolder>()  {




    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val trailName : TextView = itemView.findViewById(R.id.textViewTrailName)
        val  trailDifficulty: TextView = itemView.findViewById(R.id.textViewDifficulty)
        val trailDistance: TextView = itemView.findViewById(R.id.textViewDistance)
        val trailElevation: TextView = itemView.findViewById(R.id.textViewElevation)
        val trailTime: TextView = itemView.findViewById(R.id.textViewTime)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_hiking_trail, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {

        return hikingTrails.size
    }

    //@SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val trail = hikingTrails[position]
        holder.trailName.text = trail.name
        "Difficulty: ${trail.difficulty}".also { holder.trailDifficulty.text = it }
        "Distance: ${trail.distance} miles".also { holder.trailDistance.text = it }
        "Elevation Gain: ${trail.elevationGain} feet".also { holder.trailElevation.text = it }
        "Estimated Time: ${trail.estimatedTime}".also { holder.trailTime.text = it }
    }


}
