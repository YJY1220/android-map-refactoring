package campus.tech.kakao.map.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "map_item")
data class MapItem(
    @PrimaryKey val id: String,
    val place_name: String,
    val road_address_name: String,
    val category_group_name: String,
    val x: Double,
    val y: Double
)
