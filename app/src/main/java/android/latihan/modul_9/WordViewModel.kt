package android.latihan.modul_9

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class WordViewModel (application: Application) : AndroidViewModel(application) {
    private val repository: WordRepository
    val allWords : LiveData<List<Word>>

    init {
        //pada bagian ini kita memulai untuk mengonek ke DB room local kita
        val wordsDao = WordRoomDatabase.getDatabase(application, viewModelScope).wordDao()
        repository = WordRepository(wordsDao)
        allWords = repository.allWords
    }

    //memanggil launch itu guna menyatakan bahwa langkah ini adalah routine, dan memerlukan koneksi DB
    fun insert(word: Word) = viewModelScope.launch {
        repository.insert(word)
    }

    fun deleteWord(word: Word) = viewModelScope.launch {
        repository.delete(word)
    }
}