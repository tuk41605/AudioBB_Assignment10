package edu.temple.audiobb_assignment10

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import com.android.volley.Request
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import org.json.JSONArray

lateinit var jsonArray:JSONArray
class SearchActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        findViewById<ImageButton>(R.id.searchButton).setOnClickListener {

            val url = "https://kamorris.com/lab/cis3515/search.php?term=" +
                    findViewById<EditText>(R.id.searchStringEditText).text.toString()

            Volley.newRequestQueue(this).add(
                JsonArrayRequest(Request.Method.GET, url, null, {
                    jsonArray = it
                    setResult(RESULT_OK,
                        Intent().putExtra(BookList.BOOKLIST_KEY, BookList().apply{
                            populateBooks(it)


                        })
                    )
                    finish()
                }, {})
            )


        }
    }

    companion object{
        fun getJSONArray():JSONArray{
            return jsonArray
        }

    }
}