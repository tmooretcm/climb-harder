package amc.g11.climbharder

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class ClimbHarderApplication : Application() {
    val applicationScope = CoroutineScope(SupervisorJob())
    val send_database by lazy {SendDatabase.getDatabase(this, applicationScope)}
    val send_repository by lazy {SendRepository(send_database.getSendDao())}
    val schedule_database by lazy {ScheduleDatabase.getDatabase(this, applicationScope)}
    val schedule_repository by lazy {ScheduleRepository(schedule_database.getScheduleDao())}

    override fun onCreate() {
        super.onCreate()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = getString(R.string.channel_name)
            val descriptionText = getString(R.string.channel_description)
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(CHANNEL_ID, name, importance).apply {
                description = descriptionText
            }
            // Register the channel with the system
            val notificationManager: NotificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }

    companion object {
        const val CHANNEL_ID = "climb_reminder_id"
    }
}
