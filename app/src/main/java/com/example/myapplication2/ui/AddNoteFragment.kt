package com.example.myapplication2.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.myapplication2.R
import com.example.myapplication2.databinding.FragmentAddNoteBinding
import com.example.myapplication2.db.Note
import com.example.myapplication2.utils.getString
import com.example.myapplication2.viewmodels.AddNoteViewModel
import com.example.myapplication2.viewmodels.NoteViewModel
import java.util.Calendar


class AddNoteFragment : Fragment() {
    private lateinit var binding: FragmentAddNoteBinding
    private val viewModel: AddNoteViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddNoteBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //нажатие кнопки назад
        binding.skipText.setOnClickListener {
            parentFragmentManager.popBackStack()
        }
        //сохранение заметки
        binding.addButton.setOnClickListener {
            viewModel.addNote(
                Note(
                    binding.titleEdit.getString(),
                    Calendar.getInstance().timeInMillis,
                    binding.messageEdit.getString()
                )
            )
            parentFragmentManager.popBackStack()
            Toast.makeText(context, "saved", Toast.LENGTH_LONG).show()
        }
    }
}