package com.example.infocovid_19retrofit.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.infocovid_19retrofit.R
import com.example.infocovid_19retrofit.adapter.ProvinceAdapter
import com.example.infocovid_19retrofit.api.RetrofitClient
import com.example.infocovid_19retrofit.api.model.ProvinceResponse
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class ProvinceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_province)

        showProvince()
    }

    private fun showProvince() {
        val rvProvince : RecyclerView = findViewById(R.id.rvProvince)

        rvProvince.setHasFixedSize(true)
        rvProvince.layoutManager = LinearLayoutManager(this)
        RetrofitClient.instance.getProvince().enqueue(object : retrofit2.Callback<ArrayList<ProvinceResponse>>{
            override fun onResponse(
                call: Call<ArrayList<ProvinceResponse>>,
                response: Response<ArrayList<ProvinceResponse>>
            ) {
                val list = response.body()
                val adapter = list?.let { ProvinceAdapter(it) }
                rvProvince.adapter = adapter
            }

            override fun onFailure(call: Call<ArrayList<ProvinceResponse>>, t: Throwable) {
                Toast.makeText(this@ProvinceActivity, "${t.message}", Toast.LENGTH_SHORT).show()
            }

        })
    }
}