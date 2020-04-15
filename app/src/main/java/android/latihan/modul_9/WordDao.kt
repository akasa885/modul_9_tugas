package android.latihan.modul_9

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface WordDao {
    @Query("select * from word_table order by word asc")
    fun getAlphabetizedWords(): LiveData<List<Word>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(word: Word)

    @Delete
    suspend fun delete(word: Word)

    @Query("delete from word_table")
    suspend fun deleteAll()
}