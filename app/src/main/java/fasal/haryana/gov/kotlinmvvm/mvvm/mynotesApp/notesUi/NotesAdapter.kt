package fasal.haryana.gov.kotlinmvvm.mvvm.mynotesApp.notesUi

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import fasal.haryana.gov.kotlinmvvm.R
import fasal.haryana.gov.kotlinmvvm.mvvm.mynotesApp.notesdb.Notes
import kotlinx.android.synthetic.main.note_layout.view.*

class NotesAdapter(private val notes:List<Notes>): RecyclerView.Adapter<NotesAdapter.NoteViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {

        return NoteViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.note_layout,parent,false)
        )
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.itemView.note_title.text=notes[position].title
        holder.itemView.note_desc.text=notes[position].description

    }

    override fun getItemCount()=notes.size

    class NoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }
}