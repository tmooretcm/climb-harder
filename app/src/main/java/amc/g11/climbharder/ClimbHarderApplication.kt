package amc.g11.climbharder

import android.app.Application

class ClimbHarderApplication : Application() {
    val send_database by lazy {SendDatabase.getDatabase(this)}
    val send_repository by lazy {SendRepository(send_database.getSendDao())}
}