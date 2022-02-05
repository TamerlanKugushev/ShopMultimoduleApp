package com.example.mainscreen.presentation.adapters

import android.os.Build
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.example.mainscreen.presentation.fragment.ItemStateListener
import com.example.mainscreen.R
import com.example.mainscreen.databinding.ItemCategoriesMainScreenBinding
import com.example.model.models.categories.Category
import com.example.utils.BOOKS_CATEGORY_ID
import com.example.utils.COMPUTER_CATEGORY_ID
import com.example.utils.HEALTH_CATEGORY_ID
import com.example.utils.PHONES_CATEGORY_ID


class CategoriesRVAdapter(private val itemStateListener: ItemStateListener) :
    RecyclerView.Adapter<CategoriesRVAdapter.ViewHolder>() {

    private val categories = listOf(
        Category(
            PHONES_CATEGORY_ID,
            R.drawable.category_phones_image,
            R.string.category_phones,
            true
        ),
        Category(
            COMPUTER_CATEGORY_ID,
            R.drawable.category_computer_image,
            R.string.category_computers
        ),
        Category(
            HEALTH_CATEGORY_ID,
            R.drawable.category_health_image,
            R.string.category_heals
        ),
        Category(
            BOOKS_CATEGORY_ID,
            R.drawable.category_books_image,
            R.string.category_books
        ),
        Category(
            PHONES_CATEGORY_ID,
            R.drawable.category_phones_image,
            R.string.category_phones
        ),
    )

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val binding = ItemCategoriesMainScreenBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(categories[position])
    }

    override fun getItemCount(): Int = categories.size

    inner class ViewHolder(private val binding: ItemCategoriesMainScreenBinding) :
        RecyclerView.ViewHolder(binding.root) {
        private val context = itemView.context
        private val resources = context.resources
        private val theme = context.theme
        fun bind(category: Category) {
            initView(category)
            chekStateView(category)
            setStateSelected(category)
            onClickItem(category)
        }

        private fun onClickItem(category: Category) {
            itemView.setOnClickListener {
                if (category.isSelected) {
                    return@setOnClickListener
                } else {
                    category.isSelected = true
                    notifyDataSetChanged()
                }
            }
        }

        private fun setStateSelected(category: Category) {
            if (category.isSelected) {
                category.isSelected = !category.isSelected
            }
        }

        @RequiresApi(Build.VERSION_CODES.M)
        private fun chekStateView(category: Category) {
            with(binding) {
                if (category.isSelected) {
                    ivCircleCategories.setColorFilter(
                        resources.getColor(
                            R.color.orange, theme
                        )
                    )
                    descriptionItemCategory.setTextColor(
                        resources.getColor(R.color.orange, theme)
                    )

                    setImageIcon(category.id)
                    itemStateListener.getActiveItem(category.id)
                } else {
                    ivCircleCategories.setColorFilter(
                        resources.getColor(
                            R.color.white, theme
                        )
                    )
                    descriptionItemCategory.setTextColor(
                        resources.getColor(R.color.blue, theme)
                    )
                }
            }
        }

        private fun initView(category: Category) {
            with(binding) {
                ivIconCategories.setImageResource(category.imageRes)
                descriptionItemCategory.text = context.resources.getString(category.description)
            }
        }

        private fun setImageIcon(id: Int) {
            when (id) {
                PHONES_CATEGORY_ID -> {
                    binding.ivIconCategories.setImageResource(R.drawable.category_phones_image_selected)
                }
                COMPUTER_CATEGORY_ID -> {
                    binding.ivIconCategories.setImageResource(R.drawable.category_computer_image_selected)
                }
                HEALTH_CATEGORY_ID -> {
                    binding.ivIconCategories.setImageResource(R.drawable.category_health_image_selected)
                }
                BOOKS_CATEGORY_ID -> {
                    binding.ivIconCategories.setImageResource(R.drawable.category_books_image_selected)
                }
            }
        }
    }
}