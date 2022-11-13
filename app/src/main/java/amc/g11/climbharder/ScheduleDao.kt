package amc.g11.climbharder

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface ScheduleDao {

    @Query("SELECT * FROM schedule_table ORDER BY _day DESC, _id DESC")
    fun getAllSchedules() : Flow<List<Schedule>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(schedule: Schedule)

    @Query("DELETE FROM schedule_table")
    suspend fun deleteAll()

    @Delete
    suspend fun delete(schedule: Schedule)

}