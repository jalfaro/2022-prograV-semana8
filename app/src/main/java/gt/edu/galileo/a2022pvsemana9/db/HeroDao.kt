package gt.edu.galileo.a2022pvsemana9.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface HeroDao {
    @Insert
    suspend fun insertAll(vararg hero: Hero): List<Long>
    @Query("SELECT uuid, hero_name, printed_by FROM tbl_hero")
    suspend fun getHeros(): List<Hero>
}