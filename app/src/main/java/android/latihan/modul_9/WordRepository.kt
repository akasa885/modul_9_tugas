package android.latihan.modul_9

import android.content.Context
import android.os.AsyncTask
import androidx.lifecycle.LiveData
import androidx.room.Room


public class WordRepository(private val wordDao : WordDao) {
    val allWords : LiveData<List<Word>> = wordDao.getAlphabetizedWords()
    suspend fun insert(word: Word){
        wordDao.insert(word)
    }

    suspend fun delete(word: Word) {
        wordDao.delete(word)
    }
}