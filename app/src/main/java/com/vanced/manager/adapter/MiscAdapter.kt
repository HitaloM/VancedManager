package com.vanced.manager.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources
import androidx.recyclerview.widget.RecyclerView
import com.vanced.manager.R
import com.vanced.manager.databinding.ViewSocialLinkBinding
import com.vanced.manager.model.LinkModel
import com.vanced.manager.ui.viewmodels.HomeViewModel

class MiscAdapter(
    private val context: Context,
    private val viewModel: HomeViewModel
) : RecyclerView.Adapter<MiscAdapter.LinkViewHolder>() {

    private val artelegram = LinkModel(
        AppCompatResources.getDrawable(context, R.drawable.ic_telegram),
        ARTELEGRAM
    )

    val links = arrayOf(artelegram)

    inner class LinkViewHolder(private val binding: ViewSocialLinkBinding) :
        RecyclerView.ViewHolder(binding.root) {

        val logo = binding.linkImage

        fun bind(position: Int) {
            binding.linkBg.setOnClickListener {
                viewModel.openUrl(context, links[position].linkUrl)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LinkViewHolder {
        val view = ViewSocialLinkBinding.inflate(LayoutInflater.from(context), parent, false)
        return LinkViewHolder(view)
    }

    override fun onBindViewHolder(holder: LinkViewHolder, position: Int) {
        holder.bind(position)
        holder.logo.setImageDrawable(links[position].linkIcon)
    }

    override fun getItemCount(): Int = links.size

    companion object {
        const val ARTELEGRAM = "https://t.me/AndroidRepo"
    }

}