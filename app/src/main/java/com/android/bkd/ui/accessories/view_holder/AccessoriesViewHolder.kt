package com.android.bkd.ui.accessories.view_holder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.android.bkd.databinding.ItemAccessoriesBinding

class AccessoriesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val mBinding = ItemAccessoriesBinding.bind(itemView.rootView)

    fun bind(iconAccessories: Int, priceAccessories: String) {
        mBinding.iconAccessories.setImageResource(iconAccessories)

        mBinding.priceAccessories.text = priceAccessories

    }

    fun pieceAccessories() {
        var count = 0
        var x = mBinding.priceAccessories.text.toString().toFloat()
        val y = mBinding.priceAccessories.text.toString().toFloat()
        mBinding.pieces = count.toString()
        mBinding.priceAccessories.text = 0.0.toString()

        mBinding.btnPlus.setOnClickListener {
            when {
                count < 9 -> {
                    count += 1
                    if (count > 1) x = y * count
                    mBinding.priceAccessories.text = x.toString()
                    if (count == 1) mBinding.priceAccessories.text = y.toString()
                }
                else -> {
                    count = 9
                }
            }
            mBinding.pieces = count.toString()
        }
        mBinding.btnMinus.setOnClickListener {
            when {
                count > 0 -> {
                    count -= 1
                    x -= y
                    mBinding.priceAccessories.text = x.toString()
                }
                else -> {
                    count = 0
                }
            }

            mBinding.pieces = count.toString()
        }

    }


}