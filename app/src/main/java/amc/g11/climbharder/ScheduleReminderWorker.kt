package amc.g11.climbharder

import android.app.Notification
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.work.*
import java.util.concurrent.TimeUnit
import kotlin.random.Random

class ScheduleReminderWorker(val context: Context, workerParameters: WorkerParameters): Worker(context, workerParameters) {
    override fun doWork(): Result {
        val intent = Intent(applicationContext, MainActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }

        val pendingIntent: PendingIntent = PendingIntent
            .getActivity(applicationContext, 0, intent, PendingIntent.FLAG_IMMUTABLE)

        makeNotification(pendingIntent)
        return Result.success()
    }

    private fun makeNotification(pendingIntent: PendingIntent){
        val notifBuilder = NotificationCompat.Builder(applicationContext, "push_notifs")
            .setSmallIcon(R.drawable.climbharderlogo)
            .setContentTitle("Climb Harder Notification")
            .setContentText("It's time to Climb Harder! Log on to log your send!")
            .setContentIntent(pendingIntent)
            .setPriority(NotificationCompat.PRIORITY_HIGH)

        with(NotificationManagerCompat.from(applicationContext)){
            notify(Random.nextInt(), notifBuilder.build())
        }

    }


}