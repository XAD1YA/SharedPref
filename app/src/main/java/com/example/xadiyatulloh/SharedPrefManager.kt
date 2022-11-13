package com.example.xadiyatulloh


import android.content.Context

class SharedPrefManager(context: Context) {
    private val pref = context.getSharedPreferences("uyga vazifa", Context.MODE_PRIVATE)
    private val edit = pref.edit()

    fun saveValue(key: String, value: String){
        edit.putString(key, value)
        edit.apply()
    }

    fun getValue(key: String): String? {
        return pref.getString(key, null)
    }
}