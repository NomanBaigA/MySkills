package com.example.myskills

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.myskills.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

   // Step: 5(2) - Data binding implementation
    lateinit var binding: ActivityMainBinding

    lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Step: 5(3) - Data binding implementation
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val dao = SkillDatabase.getDatabase(applicationContext).skillDao()
        val repository = SkillRepository(dao)

        mainViewModel =
            ViewModelProvider(this, MainViewModelFactory(repository)).get(MainViewModel::class.java)

        mainViewModel.getSkills().observe(this, Observer { it ->

            // binding.quotes = it.toString()

            val skillsList = mutableListOf<String>()

            if (it.isNotEmpty()) {

                it.forEach {
                   // Log.i("Test for text view", it.author)
                    skillsList.add(it.skill)
                }
            }else{
                binding.skillsTextView = "Nothing To Show"
            }

            binding.skillsTextView = skillsList.toString()
        })


        binding.btnAddSkill.setOnClickListener {

            // Log.i("Test for input text", binding.inputText.text.toString())

            val skill = Skill(0, binding.inputText.text.toString())

            mainViewModel.insertSkills(skill)

            binding.inputText.setText("")
        }
    }
}
