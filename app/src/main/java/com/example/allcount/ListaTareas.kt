package com.example.allcount

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.allcount.ServicioREST.Tarea
import com.example.allcount.ServicioREST.TareaAPI
import com.example.examencl3dam1.ServicioREST.RetrofitHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ListaTareas : AppCompatActivity() {

    private lateinit var mesasRecycler: RecyclerView
    private lateinit var customMesaAdapter: CustomTareaAdapter
    private val data = ArrayList<Tarea>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_tareas)

        mesasRecycler = findViewById(R.id.gd_list_tarea)
        mesasRecycler.layoutManager = LinearLayoutManager(this)

        customMesaAdapter = CustomTareaAdapter(data)
        mesasRecycler.adapter = customMesaAdapter

        obtenerDatosDeServicio()
    }

    private fun obtenerDatosDeServicio() {
        val quotesAPI = RetrofitHelper.getRetrofitInstance().create(TareaAPI::class.java)

        GlobalScope.launch(Dispatchers.IO) {
            try {
                val response = quotesAPI.getQuotes()
                if (response.isSuccessful) {
                    val result = response.body()
                    if (result != null) {
                        Log.d("API Response", "Número de tareas obtenidas: ${result.size}")
                        withContext(Dispatchers.Main) {
                            data.addAll(result)
                            customMesaAdapter.notifyDataSetChanged()
                        }
                    } else {
                        Log.e("API Error", "Result is null")
                    }
                } else {
                    Log.e("API Error", "Error: ${response.code()}")
                }
            } catch (e: Exception) {
                Log.e("API Error", "Exception: ${e.message}")
            }
        }
    }

}