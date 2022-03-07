package com.laas.shoppingsmvvm.data.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.laas.shoppingsmvvm.R
import com.laas.shoppingsmvvm.data.adapter.listeners.ProductInfoListener
import com.laas.shoppingsmvvm.domain.model.ProductInfoModel

class ProductInfoAdapter(
    private val products: List<ProductInfoModel>,
    private val listener: ProductInfoListener
) :
    RecyclerView.Adapter<ProductInfoAdapter.ProductInfoViewHolder>() {
    inner class ProductInfoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var productName: TextView
        var productPrice: TextView
        var rating: TextView
        var reviews: TextView

        init {
            productName = itemView.findViewById(R.id.product_name)
            productPrice = itemView.findViewById(R.id.price)
            rating = itemView.findViewById(R.id.rating)
            reviews = itemView.findViewById(R.id.reviewers)

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductInfoViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.product_info_card, parent, false)
        return ProductInfoViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductInfoViewHolder, position: Int) {
        val product = products[position]

        holder.productName.text = product.productName
        holder.productPrice.text = product.productCurrency + " " + product.productPrice.toString()
        holder.rating.text = product.productRating.toString()
        holder.reviews.text = product.productReviews.toString()

        holder.itemView.setOnClickListener {
            listener.onProductClick(product)
        }

    }

    override fun getItemCount(): Int {
        return products.size
    }
}