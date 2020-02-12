package com.example.evotortest

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.evotortest.model.Product
import com.example.evotortest.utils.Utils.toImageUriList
import kotlinx.android.synthetic.main.item_product.view.*

class ProductsAdapter(private val onItemClickListener: OnItemClickListener) :
    RecyclerView.Adapter<ProductsAdapter.ProductViewHolder>() {

    private var products: List<Product> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        return ProductViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_product,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return products.size
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bindItem(products[position])
        holder.itemView.setOnClickListener {
            onItemClickListener.onProductClick(position)
        }
    }

    fun updateProducts(products: List<Product>) {
        this.products = products
        notifyDataSetChanged()
    }

    class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val context: Context = itemView.context
        private val productImage: ImageView = itemView.ivItemProductImage
        private val productBrand: TextView = itemView.tvItemProductBrand
        private val productName: TextView = itemView.tvItemProductName

        fun bindItem(item: Product) {
            productBrand.text = item.brandName
            productName.text = item.name
            loadImages(item.imagesUUID.toImageUriList())
        }

        private fun loadImages(images: List<String>) { // Костыль, загружаем первую из картинок, что не выдаст ошибку
            if (images.isNotEmpty()) {
                val glide = Glide.with(context).load(images[0])
                for (i in 1 until images.size) {
                    glide.error(Glide.with(context).load(images[i]))
                }
                glide.apply(
                    RequestOptions()
                        .placeholder(R.mipmap.ic_launcher)
                        .error(R.mipmap.ic_launcher)
                ).into(productImage)
            }
        }
    }

    interface OnItemClickListener {
        fun onProductClick(position: Int)
    }
}