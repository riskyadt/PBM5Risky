package com.example.pbm5risky

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rv_partRisky.layoutManager = LinearLayoutManager(this)
        rv_partRisky.setHasFixedSize(true)
        val data = createPhoneData()
        rv_partRisky.adapter = PhoneAdapter(data, {phoneItem: Phone -> phoneItem(phoneItem)})
    }

    private fun phoneItem(phone: Phone){
        val showDetail = Intent(this, PhoneDetail::class.java)
        showDetail.putExtra(Intent.EXTRA_TEXT, phone.phone.toString())
        startActivity(showDetail)
    }

    private fun createPhoneData() : List<Phone>{
        val listdata = ArrayList<Phone>()
        listdata.add(Phone(6282374592, "Risky"))
        listdata.add(Phone(6293367289, "Aditya"))
        listdata.add(Phone(6281866399, "Mandai"))
        return listdata
    }
}