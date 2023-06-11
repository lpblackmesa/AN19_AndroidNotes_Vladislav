package com.example.myapplication2.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myapplication2.R

//
class OnbordingFragment: Fragment() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.fragment_onbording);
//        var textView = findViewById<TextView>(R.id.skipText)
//        textView.setOnClickListener{
//            startActivity(Intent(this,SignUpActivity::class.java))
//        }
//    }
override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
): View? {
    return inflater.inflate(R.layout.fragment_onbording, container, false)
}

}