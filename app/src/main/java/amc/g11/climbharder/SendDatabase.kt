package amc.g11.climbharder

import android.content.Context
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Database(entities = [Send::class], version = 1, exportSchema = false)
abstract class SendDatabase : RoomDatabase() {

    abstract fun getSendDao(): SendDao

    private class SendDatabaseCallback (private val scope: CoroutineScope) : RoomDatabase.Callback() {
        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            INSTANCE?.let { database ->
                scope.launch {
                    populateDatabase(database.getSendDao())
                }
            }
        }

        suspend fun populateDatabase(sendDao: SendDao) {
            sendDao.deleteAll()
        }
    }

    companion object {
        @Volatile
        private var INSTANCE: SendDatabase? = null

        fun getDatabase(context: Context,
                        scope: CoroutineScope
                        ): SendDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = androidx.room.Room.databaseBuilder(
                    context.applicationContext,
                    SendDatabase::class.java,
                    "send_database"
                ).addCallback(SendDatabaseCallback(scope)).build()
                INSTANCE = instance

                instance
            }
        }
    }
}