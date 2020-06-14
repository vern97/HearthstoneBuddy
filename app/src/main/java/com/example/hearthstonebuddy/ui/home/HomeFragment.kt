package com.example.hearthstonebuddy.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.hearthstonebuddy.*
import com.example.hearthstonebuddy.BlizzardAPI.Card
import com.example.hearthstonebuddy.BlizzardAPI.CardAdapter
import com.example.hearthstonebuddy.BlizzardAPI.CardsRepository
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home.view.*

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    private lateinit var allCards: RecyclerView
    private lateinit var allCardsAdapter: CardAdapter
    private lateinit var allCardsLayoutMgr: LinearLayoutManager
    private var allCardsPage = 1

    private lateinit var twoManaCostCards: RecyclerView
    private lateinit var twoManaCostCardsAdapter: CardAdapter
    private lateinit var twoManaCostCardsLayoutMgr: LinearLayoutManager
    private var twoManaCostCardsPage = 1

    private lateinit var oneManaCostCards: RecyclerView
    private lateinit var oneManaCostCardsAdapter: CardAdapter
    private lateinit var oneManaCostCardsLayoutMgr: LinearLayoutManager
    private var oneManaCostCardsPage = 1

    private lateinit var threeManaCostCards: RecyclerView
    private lateinit var threeManaCostCardsAdapter: CardAdapter
    private lateinit var threeManaCostCardsLayoutMgr: LinearLayoutManager
    private var threeManaCostCardsPage = 1

    private lateinit var fourManaCostCards: RecyclerView
    private lateinit var fourManaCostCardsAdapter: CardAdapter
    private lateinit var fourManaCostCardsLayoutMgr: LinearLayoutManager
    private var fourManaCostCardsPage = 1

    private lateinit var fiveManaCostCards: RecyclerView
    private lateinit var fiveManaCostCardsAdapter: CardAdapter
    private lateinit var fiveManaCostCardsLayoutMgr: LinearLayoutManager
    private var fiveManaCostCardsPage = 1

    private lateinit var sixManaCostCards: RecyclerView
    private lateinit var sixManaCostCardsAdapter: CardAdapter
    private lateinit var sixManaCostCardsLayoutMgr: LinearLayoutManager
    private var sixManaCostCardsPage = 1


    private var manaCost = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)

        allCards = root.findViewById(R.id.all_cards)
        allCardsLayoutMgr = LinearLayoutManager(
            root.context,
            LinearLayoutManager.HORIZONTAL,
            false
        )

        allCards.layoutManager = allCardsLayoutMgr
        allCardsAdapter = CardAdapter(mutableListOf()) { card -> showCardDetails(card) }
        allCards.adapter = allCardsAdapter

        getAllCards()

        //Mana cost slider
        root.manaCostSlider.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(
                seekBar: SeekBar,
                progress: Int,
                fromUser: Boolean
            ) {
                manaCost = progress
                manaCostText.text = manaCost.toString()
                if (manaCost == 0){
                    allCards = root.findViewById(R.id.all_cards)
                    allCardsLayoutMgr = LinearLayoutManager(
                        root.context,
                        LinearLayoutManager.HORIZONTAL,
                        false
                    )

                    allCards.layoutManager = allCardsLayoutMgr
                    allCardsAdapter = CardAdapter(mutableListOf()) { card -> showCardDetails(card) }
                    allCards.adapter = allCardsAdapter

                    getAllCards()
                }else if (manaCost == 1){
                    oneManaCostCards = root.findViewById(R.id.all_cards)
                    oneManaCostCardsLayoutMgr = LinearLayoutManager(
                        root.context,
                        LinearLayoutManager.HORIZONTAL,
                        false
                    )

                    oneManaCostCards.layoutManager = oneManaCostCardsLayoutMgr
                    oneManaCostCardsAdapter = CardAdapter(mutableListOf()) { card -> showCardDetails(card) }
                    oneManaCostCards.adapter = oneManaCostCardsAdapter

                    getOneManaCostCards()
                } else if (manaCost == 2){
                    twoManaCostCards = root.findViewById(R.id.all_cards)
                    twoManaCostCardsLayoutMgr = LinearLayoutManager(
                        root.context,
                        LinearLayoutManager.HORIZONTAL,
                        false
                    )

                    twoManaCostCards.layoutManager = twoManaCostCardsLayoutMgr
                    twoManaCostCardsAdapter = CardAdapter(mutableListOf()) { card -> showCardDetails(card) }
                    twoManaCostCards.adapter = twoManaCostCardsAdapter

                    getTwoManaCostCards()
                } else if (manaCost == 3){
                    threeManaCostCards = root.findViewById(R.id.all_cards)
                    threeManaCostCardsLayoutMgr = LinearLayoutManager(
                        root.context,
                        LinearLayoutManager.HORIZONTAL,
                        false
                    )

                    threeManaCostCards.layoutManager = threeManaCostCardsLayoutMgr
                    threeManaCostCardsAdapter = CardAdapter(mutableListOf()) { card -> showCardDetails(card) }
                    threeManaCostCards.adapter = threeManaCostCardsAdapter

                    getThreeManaCostCards()
                } else if (manaCost == 4) {
                    fourManaCostCards = root.findViewById(R.id.all_cards)
                    fourManaCostCardsLayoutMgr = LinearLayoutManager(
                        root.context,
                        LinearLayoutManager.HORIZONTAL,
                        false
                    )

                    fourManaCostCards.layoutManager = fourManaCostCardsLayoutMgr
                    fourManaCostCardsAdapter = CardAdapter(mutableListOf()) { card -> showCardDetails(card) }
                    fourManaCostCards.adapter = fourManaCostCardsAdapter

                    getFourManaCostCards()
                } else if (manaCost == 5) {
                    fiveManaCostCards = root.findViewById(R.id.all_cards)
                    fiveManaCostCardsLayoutMgr = LinearLayoutManager(
                        root.context,
                        LinearLayoutManager.HORIZONTAL,
                        false
                    )

                    fiveManaCostCards.layoutManager = fiveManaCostCardsLayoutMgr
                    fiveManaCostCardsAdapter = CardAdapter(mutableListOf()) { card -> showCardDetails(card) }
                    fiveManaCostCards.adapter = fiveManaCostCardsAdapter

                    getFiveManaCostCards()
                } else if (manaCost == 6) {
                    sixManaCostCards = root.findViewById(R.id.all_cards)
                    sixManaCostCardsLayoutMgr = LinearLayoutManager(
                        root.context,
                        LinearLayoutManager.HORIZONTAL,
                        false
                    )

                    sixManaCostCards.layoutManager = sixManaCostCardsLayoutMgr
                    sixManaCostCardsAdapter = CardAdapter(mutableListOf()) { card -> showCardDetails(card) }
                    sixManaCostCards.adapter = sixManaCostCardsAdapter

                    getSixManaCostCards()
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {}
            override fun onStopTrackingTouch(seekBar: SeekBar) {}
        })

        return root
    }

    private fun getAllCards() {
        CardsRepository.getAllCards(
            allCardsPage,
            ::onAllCardsFetched,
            ::onError
        )
    }

    private fun attachAllCardsOnScrollListener() {
        allCards.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                val totalItemCount = allCardsLayoutMgr.itemCount
                val visibleItemCount = allCardsLayoutMgr.childCount
                val firstVisibleItem = allCardsLayoutMgr.findFirstVisibleItemPosition()
                if (firstVisibleItem + visibleItemCount >= totalItemCount / 2) {
                    allCards.removeOnScrollListener(this)
                    allCardsPage++
                    getAllCards()
                }
            }
        })
    }

    private fun onAllCardsFetched(cards: List<Card>) {
        allCardsAdapter.appendCards(cards)
        attachAllCardsOnScrollListener()
    }

    private fun getOneManaCostCards() {
        CardsRepository.getOneManaCostCards(
            oneManaCostCardsPage,
            ::onOneManaCostCardsFetched,
            ::onError
        )
    }

    private fun attachOneManaCostCardsOnScrollListener() {
        oneManaCostCards.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                val totalItemCount = oneManaCostCardsLayoutMgr.itemCount
                val visibleItemCount = oneManaCostCardsLayoutMgr.childCount
                val firstVisibleItem = oneManaCostCardsLayoutMgr.findFirstVisibleItemPosition()
                if (firstVisibleItem + visibleItemCount >= totalItemCount / 2) {
                    oneManaCostCards.removeOnScrollListener(this)
                    oneManaCostCardsPage++
                    getOneManaCostCards()
                }
            }
        })
    }

    private fun onOneManaCostCardsFetched(cards: List<Card>) {
        oneManaCostCardsAdapter.appendCards(cards)
        attachOneManaCostCardsOnScrollListener()
    }

    private fun getTwoManaCostCards() {
        CardsRepository.getTwoManaCostCards(
            twoManaCostCardsPage,
            ::onTwoManaCostCardsFetched,
            ::onError
        )
    }

    private fun attachTwoManaCostCardsOnScrollListener() {
        twoManaCostCards.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                val totalItemCount = twoManaCostCardsLayoutMgr.itemCount
                val visibleItemCount = twoManaCostCardsLayoutMgr.childCount
                val firstVisibleItem = twoManaCostCardsLayoutMgr.findFirstVisibleItemPosition()
                if (firstVisibleItem + visibleItemCount >= totalItemCount / 2) {
                    twoManaCostCards.removeOnScrollListener(this)
                    twoManaCostCardsPage++
                    getTwoManaCostCards()
                }
            }
        })
    }

    private fun onTwoManaCostCardsFetched(cards: List<Card>) {
        twoManaCostCardsAdapter.appendCards(cards)
        attachTwoManaCostCardsOnScrollListener()
    }

    private fun getThreeManaCostCards() {
        CardsRepository.getThreeManaCostCards(
            threeManaCostCardsPage,
            ::onThreeManaCostCardsFetched,
            ::onError
        )
    }

    private fun attachThreeManaCostCardsOnScrollListener() {
        threeManaCostCards.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                val totalItemCount = threeManaCostCardsLayoutMgr.itemCount
                val visibleItemCount = threeManaCostCardsLayoutMgr.childCount
                val firstVisibleItem = threeManaCostCardsLayoutMgr.findFirstVisibleItemPosition()
                if (firstVisibleItem + visibleItemCount >= totalItemCount / 2) {
                    threeManaCostCards.removeOnScrollListener(this)
                    threeManaCostCardsPage++
                    getThreeManaCostCards()
                }
            }
        })
    }

    private fun onThreeManaCostCardsFetched(cards: List<Card>) {
        threeManaCostCardsAdapter.appendCards(cards)
        attachThreeManaCostCardsOnScrollListener()
    }

    private fun getFourManaCostCards() {
        CardsRepository.getFourManaCostCards(
            fourManaCostCardsPage,
            ::onFourManaCostCardsFetched,
            ::onError
        )
    }

    private fun attachFourManaCostCardsOnScrollListener() {
        fourManaCostCards.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                val totalItemCount = fourManaCostCardsLayoutMgr.itemCount
                val visibleItemCount = fourManaCostCardsLayoutMgr.childCount
                val firstVisibleItem = fourManaCostCardsLayoutMgr.findFirstVisibleItemPosition()
                if (firstVisibleItem + visibleItemCount >= totalItemCount / 2) {
                    fourManaCostCards.removeOnScrollListener(this)
                    fourManaCostCardsPage++
                    getFourManaCostCards()
                }
            }
        })
    }

    private fun onFourManaCostCardsFetched(cards: List<Card>) {
        fourManaCostCardsAdapter.appendCards(cards)
        attachFourManaCostCardsOnScrollListener()
    }

    private fun getFiveManaCostCards() {
        CardsRepository.getFiveManaCostCards(
            fiveManaCostCardsPage,
            ::onFiveManaCostCardsFetched,
            ::onError
        )
    }

    private fun attachFiveManaCostCardsOnScrollListener() {
        fiveManaCostCards.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                val totalItemCount = fiveManaCostCardsLayoutMgr.itemCount
                val visibleItemCount = fiveManaCostCardsLayoutMgr.childCount
                val firstVisibleItem = fiveManaCostCardsLayoutMgr.findFirstVisibleItemPosition()
                if (firstVisibleItem + visibleItemCount >= totalItemCount / 2) {
                    fiveManaCostCards.removeOnScrollListener(this)
                    fiveManaCostCardsPage++
                    getFiveManaCostCards()
                }
            }
        })
    }

    private fun onFiveManaCostCardsFetched(cards: List<Card>) {
        fiveManaCostCardsAdapter.appendCards(cards)
        attachFiveManaCostCardsOnScrollListener()
    }

    private fun getSixManaCostCards() {
        CardsRepository.getSixManaCostCards(
            sixManaCostCardsPage,
            ::onSixManaCostCardsFetched,
            ::onError
        )
    }

    private fun attachSixManaCostCardsOnScrollListener() {
        sixManaCostCards.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                val totalItemCount = sixManaCostCardsLayoutMgr.itemCount
                val visibleItemCount = sixManaCostCardsLayoutMgr.childCount
                val firstVisibleItem = sixManaCostCardsLayoutMgr.findFirstVisibleItemPosition()
                if (firstVisibleItem + visibleItemCount >= totalItemCount / 2) {
                    sixManaCostCards.removeOnScrollListener(this)
                    sixManaCostCardsPage++
                    getSixManaCostCards()
                }
            }
        })
    }

    private fun onSixManaCostCardsFetched(cards: List<Card>) {
        sixManaCostCardsAdapter.appendCards(cards)
        attachSixManaCostCardsOnScrollListener()
    }

    private fun onError() {
        Toast.makeText(context, getString(R.string.error_fetch_cards), Toast.LENGTH_SHORT).show()
    }

    private fun showCardDetails(card: Card) {
        val intent = Intent(context, CardDetailsActivity::class.java)
        intent.putExtra(CARD_IMG, card.image)
        intent.putExtra(CARD_NAME, card.name)
        intent.putExtra(CARD_DMG, card.flavorText)
        intent.putExtra(CARD_INFO, card.text)
        startActivity(intent)
    }
}