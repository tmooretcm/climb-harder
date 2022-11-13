package amc.g11.climbharder;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u001c\u001a\u00020\u001dH\u0016R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\u0007\u001a\u00020\b8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u001b\u0010\r\u001a\u00020\u000e8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0012\u001a\u00020\u00138FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0016\u0010\f\u001a\u0004\b\u0014\u0010\u0015R\u001b\u0010\u0017\u001a\u00020\u00188FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001b\u0010\f\u001a\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001f"}, d2 = {"Lamc/g11/climbharder/ClimbHarderApplication;", "Landroid/app/Application;", "()V", "applicationScope", "Lkotlinx/coroutines/CoroutineScope;", "getApplicationScope", "()Lkotlinx/coroutines/CoroutineScope;", "schedule_database", "Lamc/g11/climbharder/ScheduleDatabase;", "getSchedule_database", "()Lamc/g11/climbharder/ScheduleDatabase;", "schedule_database$delegate", "Lkotlin/Lazy;", "schedule_repository", "Lamc/g11/climbharder/ScheduleRepository;", "getSchedule_repository", "()Lamc/g11/climbharder/ScheduleRepository;", "schedule_repository$delegate", "send_database", "Lamc/g11/climbharder/SendDatabase;", "getSend_database", "()Lamc/g11/climbharder/SendDatabase;", "send_database$delegate", "send_repository", "Lamc/g11/climbharder/SendRepository;", "getSend_repository", "()Lamc/g11/climbharder/SendRepository;", "send_repository$delegate", "onCreate", "", "Companion", "app_debug"})
public final class ClimbHarderApplication extends android.app.Application {
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.CoroutineScope applicationScope = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy send_database$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy send_repository$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy schedule_database$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy schedule_repository$delegate = null;
    @org.jetbrains.annotations.NotNull()
    public static final amc.g11.climbharder.ClimbHarderApplication.Companion Companion = null;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String CHANNEL_ID = "climb_reminder_id";
    
    public ClimbHarderApplication() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.CoroutineScope getApplicationScope() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final amc.g11.climbharder.SendDatabase getSend_database() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final amc.g11.climbharder.SendRepository getSend_repository() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final amc.g11.climbharder.ScheduleDatabase getSchedule_database() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final amc.g11.climbharder.ScheduleRepository getSchedule_repository() {
        return null;
    }
    
    @java.lang.Override()
    public void onCreate() {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lamc/g11/climbharder/ClimbHarderApplication$Companion;", "", "()V", "CHANNEL_ID", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}