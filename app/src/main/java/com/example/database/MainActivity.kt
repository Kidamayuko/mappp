package com.example.database

import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import io.realm.Realm
import io.realm.RealmResults

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var realm: Realm

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        // create test
        create()
        create()

        // read test
        val getData = read()
        getData.forEach {
            Log.d("debug", "緯度 :" + it.latitude.toString() + "経度 : " + it.longitude.toString())
        }

        Realm.init(this)
        realm = Realm.getDefaultInstance()

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }

    fun read() : RealmResults<map> {
            return realm.where(map::class.java).findAll()
    }

    fun create() {
        realm = Realm.getDefaultInstance()
        realm.executeTransaction{realm ->
            val map1 = realm.createObject(map::class.java)
            map1.latitude = 35.656967.toLong()
            map1.longitude = 139.753927.toLong()
            map1.atm = 0
            map1.cs = 1
            map1.toilet = 0
            map1.ticket = 0
            map1.inside = 0
            map1.tower = 1

            val map2 = realm.createObject(map::class.java)
            map2.latitude = 35.6568484.toLong()
            map2.longitude = 139.7545477.toLong()
            map2.atm = 0
            map2.cs = 0
            map2.toilet = 0
            map2.ticket = 1
            map2.inside = 1
            map2.tower = 0

            val map3 = realm.createObject(map::class.java)
            map3.latitude = 35.6568405.toLong()
            map3.longitude = 139.7549447.toLong()
            map3.atm = 0
            map3.cs = 0
            map3.toilet = 1
            map3.ticket = 1
            map3.inside = 1
            map3.tower = 0

            val map4= realm.createObject(map::class.java)
            map4.latitude = 35.6568863.toLong()
            map4.longitude = 139.7542007.toLong()
            map4.atm = 1
            map4.cs = 0
            map4.toilet = 1
            map4.ticket = 0
            map4.inside = 1
            map4.tower = 1
        }
    }





    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        realm.close()
    }
}
