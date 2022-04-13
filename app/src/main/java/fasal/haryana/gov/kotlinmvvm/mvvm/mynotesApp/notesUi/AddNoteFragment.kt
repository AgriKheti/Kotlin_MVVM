package fasal.haryana.gov.kotlinmvvm.mvvm.mynotesApp.notesUi

import android.app.AlertDialog
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import fasal.haryana.gov.kotlinmvvm.R
import fasal.haryana.gov.kotlinmvvm.mvvm.mynotesApp.notesdb.Notes
import fasal.haryana.gov.kotlinmvvm.mvvm.mynotesApp.notesdb.NotesDatabase
import fasal.haryana.gov.kotlinmvvm.mvvm.viewutil.message
import kotlinx.android.synthetic.main.fragment_add_note.*
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.coroutines.launch

class AddNoteFragment : BaseFragment() {

    private var note:Notes?=null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_note, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        /*receving note here */
        arguments?.let {
            note= AddNoteFragmentArgs.fromBundle(it).note
            title_tv.setText(note?.title)
            description_tv.setText(note?.description)
        }
        button_save.setOnClickListener { view->
            val title = title_tv.text.toString()
            val description = description_tv.text.toString()
            if (title.isEmpty()){
                title_tv.error="Title Required"
                title_tv.requestFocus()
                return@setOnClickListener
            } else if (description.isEmpty()){
                description_tv.error="Description Required"
                description_tv.requestFocus()
                return@setOnClickListener }
            /* we can not access the Roomdb from our main thread ? it will throw an error so we have to
            * call db functions either from coroutines or asycn task as from backround thread
            */
            launch {
                context?.let {
                    /*for updating the note*/
                    val mUpdateNote =Notes(title,description)
                    if (note==null){
                        /*mean new note is need to add*/
                        NotesDatabase(it).getNoteDao().addNote(mUpdateNote)
                        it.message("Note Saved")
                    }else {
                        /*existing note is updating*/
                            mUpdateNote.id = note!!.id
                        NotesDatabase(it).getNoteDao().updateNote(mUpdateNote)
                        it.message("Note Updated Successfully")
                    }
                    val action = AddNoteFragmentDirections.actionAddNoteFragmentToHomeFragment()
                    Navigation.findNavController(view).navigate(action)
                }
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.mymenu,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.delete_menu -> if (note!=null) deleteNote() else context?.message("Cannote delete")
        }
        return super.onOptionsItemSelected(item)

    }

    private fun deleteNote() {
        AlertDialog.Builder(context).apply {
            setTitle("Are you sure ?")
            setMessage("You can not undo this operation")
            setPositiveButton("Yes"){_,_ ->
                launch {
                    NotesDatabase(context).getNoteDao().deleteNote(note!!)
                    val action = AddNoteFragmentDirections.actionAddNoteFragmentToHomeFragment()
                    Navigation.findNavController(requireView()).navigate(action)
                    context.message("Note Deleted Successfully")
                }
                setNegativeButton("No"){_,_->

                }
            }.create().show()
        }

    }
}