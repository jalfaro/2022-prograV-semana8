package gt.edu.galileo.a2022pvsemana9.db

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName="tbl_hero")
data class Hero(
    @ColumnInfo(name="hero_name")
    val name: String,
    @ColumnInfo(name="printed_by")
    val editorial: String,
    @PrimaryKey(autoGenerate = true)
    val uuid: Long = 0L
)
