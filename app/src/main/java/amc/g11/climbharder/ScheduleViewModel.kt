package amc.g11.climbharder

import androidx.lifecycle.*
import kotlinx.coroutines.launch

class ScheduleViewModel(private val repository: ScheduleRepository) : ViewModel() {
    val allSchedules: LiveData<List<Schedule>> = repository.allSchedules.asLiveData()

    val adapter = ScheduleListAdapter()

    fun insert(schedule: Schedule) = viewModelScope.launch {
        repository.insert(schedule)
    }

    fun delete(schedule: Schedule) = viewModelScope.launch {
        repository.delete(schedule)
    }
}

class ScheduleViewModelFactory(private val repository: ScheduleRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(ScheduleViewModel::class.java)) {
            return ScheduleViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}