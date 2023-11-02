package com.belhyto.expense_tracker

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var databaseHelper: DatabaseHelper
    private lateinit var adapter: EntryAdapter // Create an adapter for the RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        databaseHelper = DatabaseHelper(this)
        adapter = EntryAdapter()

        // Set up the RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        addEntryButton.setOnClickListener {
            val description = descriptionEditText.text.toString()
            val amount = amountEditText.text.toString().toDoubleOrNull()
            val type = if (expenseRadioButton.isChecked) "Expense" else "Income"

            if (amount != null) {
                val entry = Entry(0, description, amount, type)
                if (databaseHelper.insertEntry(entry)) {
                    Toast.makeText(this, "Entry added successfully", Toast.LENGTH_SHORT).show()
                    adapter.addEntry(entry) // Add the new entry to the adapter
                } else {
                    Toast.makeText(this, "Failed to add entry", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Please enter a valid amount", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
