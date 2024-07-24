package campus.tech.kakao.map.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import campus.tech.kakao.map.model.MapItem

@Dao
interface MapItemDao {
    @Query("SELECT * FROM map_item WHERE place_name LIKE :query")
    suspend fun searchItems(query: String): List<MapItem>

    @Insert
    suspend fun insert(mapItem: MapItem)
}
