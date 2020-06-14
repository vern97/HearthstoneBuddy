package com.example.hearthstonebuddy.BlizzardAPI

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.example.hearthstonebuddy.R

class CardAdapter (
    private var cards: MutableList<Card>,
    private val onCardClick: (card: Card) -> Unit
) : RecyclerView.Adapter<CardAdapter.CardViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_card, parent, false)
        return CardViewHolder(view)
    }
    override fun getItemCount(): Int = cards.size
    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        holder.bind(cards[position])
    }
    fun appendCards(cards: List<Card>) {
        this.cards.addAll(cards)
        notifyItemRangeInserted(
            this.cards.size,
            cards.size - 1
        )
    }
    inner class CardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val poster: ImageView = itemView.findViewById(R.id.item_card_img)
        fun bind(card: Card) {
            Glide.with(itemView)
                .load(card.image)
                .transform(CenterCrop())
                .into(poster)
            itemView.setOnClickListener {onCardClick.invoke(card)}
        }
    }
}