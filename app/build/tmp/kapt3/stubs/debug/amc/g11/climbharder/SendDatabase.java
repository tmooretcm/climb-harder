package amc.g11.climbharder;

import java.lang.System;

@androidx.room.Database(entities = {amc.g11.climbharder.Send.class}, version = 1, exportSchema = false)
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\'\u0018\u0000 \u00052\u00020\u0001:\u0002\u0005\u0006B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&\u00a8\u0006\u0007"}, d2 = {"Lamc/g11/climbharder/SendDatabase;", "Landroidx/room/RoomDatabase;", "()V", "getSendDao", "Lamc/g11/climbharder/SendDao;", "Companion", "SendDatabaseCallback", "app_debug"})
public abstract class SendDatabase extends androidx.room.RoomDatabase {
    @org.jetbrains.annotations.NotNull()
    public static final amc.g11.climbharder.SendDatabase.Companion Companion = null;
    @kotlin.jvm.Volatile()
    private static volatile amc.g11.climbharder.SendDatabase INSTANCE;
    
    public SendDatabase() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public abstract amc.g11.climbharder.SendDao getSendDao();
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0019\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\r"}, d2 = {"Lamc/g11/climbharder/SendDatabase$SendDatabaseCallback;", "Landroidx/room/RoomDatabase$Callback;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "(Lkotlinx/coroutines/CoroutineScope;)V", "onCreate", "", "db", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "populateDatabase", "sendDao", "Lamc/g11/climbharder/SendDao;", "(Lamc/g11/climbharder/SendDao;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
    static final class SendDatabaseCallback extends androidx.room.RoomDatabase.Callback {
        private final kotlinx.coroutines.CoroutineScope scope = null;
        
        public SendDatabaseCallback(@org.jetbrains.annotations.NotNull()
        kotlinx.coroutines.CoroutineScope scope) {
            super();
        }
        
        @java.lang.Override()
        public void onCreate(@org.jetbrains.annotations.NotNull()
        androidx.sqlite.db.SupportSQLiteDatabase db) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.Object populateDatabase(@org.jetbrains.annotations.NotNull()
        amc.g11.climbharder.SendDao sendDao, @org.jetbrains.annotations.NotNull()
        kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lamc/g11/climbharder/SendDatabase$Companion;", "", "()V", "INSTANCE", "Lamc/g11/climbharder/SendDatabase;", "getDatabase", "context", "Landroid/content/Context;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final amc.g11.climbharder.SendDatabase getDatabase(@org.jetbrains.annotations.NotNull()
        android.content.Context context, @org.jetbrains.annotations.NotNull()
        kotlinx.coroutines.CoroutineScope scope) {
            return null;
        }
    }
}