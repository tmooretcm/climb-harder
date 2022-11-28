package amc.g11.climbharder

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "send_table")
// Sends will have a time associated with the send, the v grade of the send, and a picture.
// We won't store the picture in the DB, but we will instead store the filepath.
data class Send (@PrimaryKey @ColumnInfo(name = "_id") val id: Int,
                             @ColumnInfo(name = "_date") val date: String,
                             @ColumnInfo(name = "_grade") val grade: String,
                             @ColumnInfo(name = "_image") val image: String)