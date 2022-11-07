package amc.g11.climbharder

import android.content.Context
import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Send::class], version = 1, exportSchema = false)
public abstract class SendDatabase : RoomDatabase() {

    abstract fun getSendDao(): SendDao

    companion object {
        @Volatile
        private var INSTANCE: SendDatabase? = null

        fun getDatabase(context: Context): SendDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = androidx.room.Room.databaseBuilder(
                    context.applicationContext,
                    SendDatabase::class.java,
                    "send_database"
                ).build()
                INSTANCE = instance

                instance
            }
        }
    }
}