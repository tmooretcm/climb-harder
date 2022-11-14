package amc.g11.climbharder

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate

@Entity (tableName = "schedule_table")
// Sends will have a time associated with the send, the v grade of the send, and a picture.
// We won't store the picture in the DB, but we will instead store the filepath.
data class Schedule (@PrimaryKey @ColumnInfo(name = "_id") val id: Int,
                     @ColumnInfo(name = "_day") val day: String,
                     @ColumnInfo(name = "_time") val time: String)