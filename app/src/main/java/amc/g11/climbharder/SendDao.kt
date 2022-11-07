package amc.g11.climbharder

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface SendDao {

    @Query("SELECT * FROM send_table ORDER BY _date DESC")
    fun getAllSends() : Flow<List<Send>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(send: Send)

    @Query("DELETE FROM send_table")
    suspend fun deleteAll()

    @Delete
    fun delete(send: Send)

}