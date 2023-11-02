package com.belhyto.expense_tracker
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class EntryAdapter : RecyclerView.Adapter<EntryAdapter.EntryViewHolder>() {

    private val entries = mutableListOf<Entry>()

    fun addEntry(entry: Entry) {
        entries.add(entry)
        notifyItemInserted(entries.size - 1)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EntryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return EntryViewHolder(view)
    }

    override fun onBindViewHolder(holder: EntryViewHolder, position: Int) {
        val entry = entries[position]
        holder.bind(entry)
    }

    override fun getItemCount(): Int {
        return entries.size
    }

    class EntryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val descriptionTextView: TextView = itemView.findViewById(R.id.descriptionTextView)
        private val amountTextView: TextView = itemView.findViewById(R.id.amountTextView)

        fun bind(entry: Entry) {
            descriptionTextView.text = entry.description
            amountTextView.text = entry.amount.toString()
        }
    }
}
