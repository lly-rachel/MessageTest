package com.example.testkotlin

import kotlin.math.max


fun main(){
    println("hello Kotlin")

    val a = 10
    println("\na = "+a)
    println("-->"+ Large(45,90))




    /***************************************************/
    //for in 循环
    for(i in 0..10){
        print(i)
    }
    println("\n");
    //until step
    for (i in 0 until 10 step 2){
        print(i)
    }
    println("\n");
    for(i in 10 downTo 1){
        print(i)
    }
    println("\n");
    /***************************************************/

    //listOf不可变 mutableListOf可变(add)
    val list1 = listOf("Banana","apple","pear","Cup")
    for(i in list1){
        println(i)
    }

    //mapOf
    val map = mapOf("Banana" to 1,"apple" to 3,"Pear" to 2,"Cup" to 4)
    for((fruit,number) in map){
        println("fruit->"+fruit+","+"number->"+number)
    }

}

fun Large(para2: Int,para1: Int):Int{
    return max(para1,para2)
}

fun getScore(name: String) = when(name){
    "Tom" -> 86
    "Jim" -> 77
    else -> 0
}
