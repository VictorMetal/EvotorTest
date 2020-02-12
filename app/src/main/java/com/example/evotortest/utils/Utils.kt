package com.example.evotortest.utils

import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

object Utils {

//    fun String.toImageUri(): String {
//        return "https://img.napolke.ru/image/get?uuid=".plus(this)
//    }

    fun List<String>.toImageUriList(): List<String> {
        return this.map {
            "https://img.napolke.ru/image/get?uuid=".plus(it)
        }
    }

    fun List<String>.toImageUriArray(): Array<String> {
        return this.toImageUriList().toTypedArray()
    }

    fun getFormattedDate(dateString: String?): String {
        if (dateString.isNullOrBlank()) return "Дата не указана"
        val format = SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH)
        val date = try {
            format.parse(dateString)
        } catch (t: Throwable) {
            return "Дата не указана"
        }
        return DateFormat.getDateInstance(DateFormat.SHORT, Locale.getDefault()).format(date)
    }
}