package amc.g11.climbharder

import androidx.annotation.WorkerThread
import kotlinx.coroutines.flow.Flow

class SendRepository(private val sendDao: SendDao) {
    val allSends: Flow<List<Send>> = sendDao.getAllSends()

    @WorkerThread
    suspend fun insert(send: Send) {
        sendDao.insert(send)
    }
}