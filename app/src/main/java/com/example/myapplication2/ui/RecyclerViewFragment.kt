package com.example.myapplication2.ui

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication2.adapters.NotesAdapter
import com.example.myapplication2.R
import com.example.myapplication2.databinding.FragmentRecyclerviewBinding
import com.example.myapplication2.db.Note
import com.example.myapplication2.repository.SharedPreferenceRepository
import com.example.myapplication2.viewmodels.NoteViewModel

class RecyclerViewFragment : Fragment(), RecycleClickListener {
    //наследуем свой интерфейс для передачи клика из адаптера
    //переопределяем функцию клика

    private lateinit var binding: FragmentRecyclerviewBinding

    //храним выделенную заметку
    private var selectedNote: Note? = null

    //обработка нажатий на item
    override fun onClick(note: Note) {
        restoreMainToolbar()
        Toast.makeText(context, note.noteName, Toast.LENGTH_LONG).show()
    }

    override fun onLongClick(note: Note) {
        //меняем тулбар для работы с заметкой
        binding.toolbar.run {
            menu.clear()
            title = ""
            inflateMenu(R.menu.toolbar_menu_selected)
            selectedNote = note
        }
    }

    //ленивая инициализация с помощью by, требует implementation 'androidx.fragment:fragment-ktx:1.5.7'
    //NoteViewModel конструктор должен быть пустой
    //нужна для того, чтобы viewModel не уничтожалась вместе с вью
    private val viewModel: NoteViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //инициализируем тулбар
        restoreMainToolbar()
        //запрашиваем значения списка из репозитория через viewmodel и обновляем
        viewModel.getNotes()
        //обрабатываем нажатия меню тулбара
        binding.toolbar.run {
            setOnClickListener {
                if (this.title != getString(R.string.notes_name)) {
                    restoreMainToolbar()
                }
            }
            setOnMenuItemClickListener {
                when (it.itemId) {
                    R.id.action_add -> {
                        parentFragmentManager.beginTransaction()
                            .replace(R.id.main_fragment, AddNoteFragment())
                            .addToBackStack("").commit()
                        true
                    }

                    R.id.action_delete -> {
                        selectedNote?.let { note ->
                            showDeteleDialog(note)
                        }
                        true
                    }
                    else -> false
                }
                //возвращаем исходное состояние тулбара
                restoreMainToolbar()
                true
            }

        }
        //переводим флаг в состояние "не первый запуск"
        SharedPreferenceRepository.setIsFirstOpen()
        //подписка фрагмента на обновления
        viewModel.noteList.observe(viewLifecycleOwner) {
            //функция обновления списка
            updateRecycler(it)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentRecyclerviewBinding.inflate(inflater, container, false)
        return binding.root
    }


    //функция обновления recycler
    fun updateRecycler(list: ArrayList<Note>) {
        //инициализация recyclerView
        binding.recyclerView.run {
            if (adapter == null) {
                layoutManager = LinearLayoutManager(requireContext())
                adapter = NotesAdapter(this@RecyclerViewFragment)
            }
            (adapter as? NotesAdapter)?.submitList(list)
            //перерисовка recyclerView
            adapter?.notifyDataSetChanged()
        }
    }

    private fun restoreMainToolbar() {
        binding.toolbar.run {
            menu.clear()
            selectedNote = null
            inflateMenu(R.menu.toolbar_menu_main)
            title = getString(R.string.notes_name)
        }
    }

    //диалоковое окно с удалением заметки
    fun showDeteleDialog(note: Note) {
        AlertDialog.Builder(requireContext())
            .setTitle(getString(R.string.delete_note_dialog))
            .setMessage(getString(R.string.delete_question))
            .setPositiveButton(getString(R.string.yes)) { _, _ ->
                viewModel.delNote(note)
            }
            .setNegativeButton(getString(R.string.no)) { _, _ ->

            }
            .setNeutralButton(getString(R.string.cancel)) { _, _ ->

            }
            .show()
    }
}