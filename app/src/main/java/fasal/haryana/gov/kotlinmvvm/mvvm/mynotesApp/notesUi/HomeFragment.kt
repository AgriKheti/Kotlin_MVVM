package fasal.haryana.gov.kotlinmvvm.mvvm.mynotesApp.notesUi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import fasal.haryana.gov.kotlinmvvm.R
import fasal.haryana.gov.kotlinmvvm.mvvm.mynotesApp.notesdb.NotesDatabase
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.coroutines.launch


class HomeFragment : BaseFragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    @Deprecated("Deprecated in Java")
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


        recycler_view_note.setHasFixedSize(true)
        recycler_view_note.layoutManager= StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL)


        launch {
            context?.let {
                val notes = NotesDatabase(it).getNoteDao().getAllnotes()
                recycler_view_note.adapter=NotesAdapter(notes)

            }
        }


        button_add_note.setOnClickListener {

            val action = HomeFragmentDirections.actionHomeFragmentToAddNoteFragment2()
            Navigation.findNavController(it).navigate(action)

//            val action = HomeFragmentD.actionHomeFragmentToAddNoteFragment2()
//            Navigation.findNavController(it).navigate(action)
        }
    }

}