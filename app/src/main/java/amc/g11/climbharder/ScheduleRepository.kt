package amc.g11.climbharder

import androidx.annotation.WorkerThread
import kotlinx.coroutines.flow.Flow

class ScheduleRepository(private val scheduleDao: ScheduleDao) {
    val allSchedules: Flow<List<Schedule>> = scheduleDao.getAllSchedules()

    @WorkerThread
    suspend fun insert(schedule: Schedule) {
        scheduleDao.insert(schedule)
    }

    @WorkerThread
    suspend fun delete(schedule: Schedule) {
        scheduleDao.delete(schedule)
    }
}