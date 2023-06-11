package com.example.myapplication2.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication2.adapters.NotesAdapter
import com.example.myapplication2.R
import com.example.myapplication2.databinding.FragmentRecyclerviewBinding
import com.example.myapplication2.db.Note
import com.example.myapplication2.db.NotesDatabase
import com.example.myapplication2.viewmodels.NoteViewModel

class RecyclerViewFragment : Fragment() {

    private lateinit var binding: FragmentRecyclerviewBinding

    //ленивая инициализация с помощью by, требует implementation 'androidx.fragment:fragment-ktx:1.5.7'
    //NoteViewModel конструктор должен быть пустой
    //нужна для того, чтобы viewModel не уничтожалась вместе с вью
    private val viewModel: NoteViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //подписка фрагмента на обновления
        viewModel.noteList.observe(viewLifecycleOwner) {
            //функция обновления списка
            updateRecycler(it)
        }
        //запрашиваем значения списка из репозитория через viewmodel и обновляем
        updateRecycler(viewModel.getNotes())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentRecyclerviewBinding.inflate(inflater, container, false)
        return binding.root
    }

    fun updateRecycler(list: ArrayList<Note>) {
        //инициализация recyclerView
        binding.recyclerView.run {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = NotesAdapter()
            (adapter as? NotesAdapter)?.submitList(list)
            //перерисовка recyclerView
            adapter?.notifyDataSetChanged()
        }

    }
}