package com.example.evotortest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.evotortest.utils.Constants
import com.example.evotortest.utils.Utils
import kotlinx.android.synthetic.main.activity_product.*

class ProductActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)
        intent?.run {
            val brand = getStringExtra(Constants.BRAND)
            val name = getStringExtra(Constants.NAME)
            val price = getFloatExtra(Constants.PRICE, 0.0f)
            val images = getStringArrayExtra(Constants.IMAGES)
            val deliveryDate = getStringExtra(Constants.NEAREST_DELIVERY_DATE)
            val boxing = getStringExtra(Constants.BOXING)
            val weightValue = getDoubleExtra(Constants.WEIGHT_VALUE, 0.0)
            val weightMeasuring = getStringExtra(Constants.WEIGHT_UNIT)

            tvProductBrand.text = brand
            tvProductName.text = name
            tvProductPrice.text = getString(R.string.price_format, price)
            showImages(images)
            tvProductDeliveryDate.text =
                getString(R.string.nearest_delivery_date, Utils.getFormattedDate(deliveryDate))
            if (weightMeasuring.isNullOrBlank() || weightValue == 0.0)
                tvProductBoxing.text = getString(R.string.boxing_format, boxing)
            else
                tvProductBoxing.text =
                    getString(R.string.boxing_format_full, boxing, weightValue, weightMeasuring)
        } ?: showError()
    }

    private fun showImages(images: Array<String>?) {
        if (!images.isNullOrEmpty()) {
            val glide = Glide.with(this).load(images[0])
            for (i in 1 until images.size) {
                glide.error(Glide.with(this).load(images[i]))
            }
            glide.apply(
                RequestOptions()
                    .placeholder(R.mipmap.ic_launcher)
                    .error(R.mipmap.ic_launcher)
            ).into(ivProductImage)
        }
    }

    private fun showError() {
        Toast.makeText(this, "Что-то пошло не так :(", Toast.LENGTH_LONG).show()
    }

}
