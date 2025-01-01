package com.example.unwindappwork

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.unwindappwork.Fragments.DemoVideos
import com.example.unwindappwork.Fragments.LanguageFragment
import com.example.unwindappwork.Fragments.ReferFriendFragment
import com.example.unwindappwork.Fragments.RewardsFragment
import com.example.unwindappwork.Fragments.TrackOrder
import com.google.android.material.navigation.NavigationView
import com.google.android.material.tabs.TabLayout


class MainActivity : AppCompatActivity() {
    private lateinit var tabLayout: TabLayout
    private lateinit var viewPager: ViewPager2

    lateinit var toggle : ActionBarDrawerToggle
    lateinit var drawerLayout: DrawerLayout
    lateinit var navigationView: NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.main_activity)
        drawerLayout = findViewById(R.id.drawerLayout)
        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)

        replaceFragment(TrackOrder())
        navigationView = findViewById(R.id.navigationView)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)




/*        tabLayout = findViewById(R.id.rewards_tab_layout)
        viewPager = findViewById(R.id.rewards_content_view_pager)

        val tabAdapter = TabAdapter(this)
        viewPager.adapter = tabAdapter

        TabLayoutMediator(
            tabLayout, viewPager
        ) { tab: TabLayout.Tab, position: Int ->
            when (position) {
                0 -> tab.setText("Coupons")
                1 -> tab.setText("Unwinned coins")
            }
        }.attach()*/


/*
        val recyclerView = findViewById<RecyclerView>(R.id.languagesRecyclerView)
        val array = resources.getStringArray(R.array.languages)

        val languageAdapter = LanguagesAdapter(
            array
        )

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = languageAdapter
*/

        navigationView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.trackOrder -> replaceFragment(TrackOrder())
                R.id.demoVideos -> replaceFragment(DemoVideos())
                R.id.referAFriend -> replaceFragment(ReferFriendFragment())
                R.id.rewards -> replaceFragment(RewardsFragment(this))
                R.id.languages -> replaceFragment(LanguageFragment())
            }
            drawerLayout.closeDrawers()
            true
        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}