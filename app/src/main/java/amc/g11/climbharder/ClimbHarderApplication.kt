package amc.g11.climbharder

import android.app.Application
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class ClimbHarderApplication : Application() {
    val applicationScope = CoroutineScope(SupervisorJob())
    val send_database by lazy {SendDatabase.getDatabase(this, applicationScope)}
    val send_repository by lazy {SendRepository(send_database.getSendDao())}
    val schedule_database by lazy {ScheduleDatabase.getDatabase(this, applicationScope)}
    val schedule_repository by lazy {ScheduleRepository(schedule_database.getScheduleDao())}
}
