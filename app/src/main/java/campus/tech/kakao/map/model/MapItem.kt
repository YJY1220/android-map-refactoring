package campus.tech.kakao.map.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "MapItem")
data class MapItem(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val place_name: String,
    val road_address_name: String,
    val category_group_name: String,
    val x: Double,
    val y: Double
)
