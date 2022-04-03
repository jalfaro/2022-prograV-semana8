package gt.edu.galileo.a2022pvsemana9.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Hero::class), version = 1)
abstract class HeroDatabase : RoomDatabase() {
    abstract fun heroDao(): HeroDao
    companion object {
        @Volatile private var instance: HeroDatabase? = null
        private val LOCK = Any()
        operator fun invoke(context: Context) = instance?: synchronized(LOCK) {
            instance ?: buildDatabase(context).also {
                instance = it
            }
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            HeroDatabase::class.java,
            "db_comics"
        ).build()
    }
}