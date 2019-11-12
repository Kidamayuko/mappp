package com.example.database

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.Required
import java.util.*

open class map : RealmObject() {
    @PrimaryKey
    var id : Long = 0
    var latitude : Long = 0
    var longitude : Long = 0
    var atm : Long = 0
    var cs : Long = 0
    var toilet : Long = 0
    var ticket : Long = 0
    var inside : Long = 0
    var tower : Long = 0
}
