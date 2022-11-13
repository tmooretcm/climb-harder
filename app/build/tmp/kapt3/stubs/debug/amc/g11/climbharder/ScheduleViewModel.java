package amc.g11.climbharder;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\fJ\u000e\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\fR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001d\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lamc/g11/climbharder/ScheduleViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lamc/g11/climbharder/ScheduleRepository;", "(Lamc/g11/climbharder/ScheduleRepository;)V", "adapter", "Lamc/g11/climbharder/ScheduleListAdapter;", "getAdapter", "()Lamc/g11/climbharder/ScheduleListAdapter;", "allSchedules", "Landroidx/lifecycle/LiveData;", "", "Lamc/g11/climbharder/Schedule;", "getAllSchedules", "()Landroidx/lifecycle/LiveData;", "delete", "Lkotlinx/coroutines/Job;", "schedule", "insert", "app_debug"})
public final class ScheduleViewModel extends androidx.lifecycle.ViewModel {
    private final amc.g11.climbharder.ScheduleRepository repository = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<amc.g11.climbharder.Schedule>> allSchedules = null;
    @org.jetbrains.annotations.NotNull()
    private final amc.g11.climbharder.ScheduleListAdapter adapter = null;
    
    public ScheduleViewModel(@org.jetbrains.annotations.NotNull()
    amc.g11.climbharder.ScheduleRepository repository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<amc.g11.climbharder.Schedule>> getAllSchedules() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final amc.g11.climbharder.ScheduleListAdapter getAdapter() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job insert(@org.jetbrains.annotations.NotNull()
    amc.g11.climbharder.Schedule schedule) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job delete(@org.jetbrains.annotations.NotNull()
    amc.g11.climbharder.Schedule schedule) {
        return null;
    }
}