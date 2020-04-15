package android.latihan.modul_9

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class WordListAdapter internal constructor(context: Context) : RecyclerView.Adapter<WordListAdapter.WordViewHolder>(){

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var words = emptyList<Word>() //Cached Copy of words

    inner class WordViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val worditemView: TextView = itemView.findViewById(R.id.textView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        val itemView = inflater.inflate(R.layout.recyclerview_item,parent,false)
        return WordViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        val current = words[position]
        holder.worditemView.text = current.word
    }

    internal fun setWords(words: List<Word>){
        this.words = words
        notifyDataSetChanged()
    }

    fun getWordAtPosition(position: Int): Word {
        return words.get(position)
    }

    override fun getItemCount() = words.size
}