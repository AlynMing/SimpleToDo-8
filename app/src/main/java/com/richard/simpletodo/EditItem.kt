package com.richard.simpletodo

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class EditItem : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)

        val data = this.intent.extras
        val editItem = findViewById<EditText>(R.id.editItemText)
        val btnSave = findViewById<Button>(R.id.saveButton)

        if (data != null) {
            editItem.setText(data.get("item_text").toString())
        }

        btnSave.setOnClickListener {
            val i = Intent()

            i.putExtra("item_text", editItem.text.toString())
            if (data != null) {
                i.putExtra("item_position", data.getInt("item_position"))
            }
            setResult(20, i)
            finish()
        }

    }
}