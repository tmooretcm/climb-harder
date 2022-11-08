package amc.g11.climbharder

import android.content.Context
import androidx.lifecycle.ViewModelProvider.NewInstanceFactory.Companion.instance
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@Database(entities = [Send::class], version = 1, exportSchema = false)
public abstract class SendDatabase : RoomDatabase() {

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
            var send = Send(id_counter++, LocalDate.now().format(DateTimeFormatter.ofPattern("mm/DD/yyyy")), "V8", "/")
            sendDao.insert(send)
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