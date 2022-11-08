package amc.g11.climbharder

import androidx.lifecycle.*
import kotlinx.coroutines.launch

class SendViewModel(private val repository: SendRepository) : ViewModel() {
    val allSends: LiveData<List<Send>> = repository.allSends.asLiveData()

    val adapter = SendListAdapter()

    fun insert(send: Send) = viewModelScope.launch {
        repository.insert(send)
    }

    fun delete(send: Send) = viewModelScope.launch {
        repository.delete(send)
    }
}

class SendViewModelFactory(private val repository: SendRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(SendViewModel::class.java)) {
            return SendViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}