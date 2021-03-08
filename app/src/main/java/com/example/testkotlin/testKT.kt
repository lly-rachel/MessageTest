package com.example.testkotlin

import android.content.Context
import android.view.View
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import java.lang.RuntimeException
import java.time.Duration
import kotlin.math.max


fun main(){
    println("hello Kotlin")

    val a = 10
    println("\na = "+a)
    println("-->${Large(45,90)}")

    println("------max------${maxNum(12,58,96,56,1,0,77,11,-8)}")
    println("------max------${maxNumber(12.58,96.56,1.0,77.11,-8.0)}")

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

fun maxNum(vararg nums:Int):Int{
    var maxNum = Int.MIN_VALUE
    for(num in nums){
        maxNum = max(maxNum,num)
    }
    return maxNum
}

fun <T:Comparable<T>> maxNumber(vararg nums:T):T{
    if(nums.isEmpty()) throw RuntimeException("Params can't be empty.")
    var maxNum = nums[0]
    for(num in nums){
        if(maxNum<num){
            maxNum = num
        }
    }
    return maxNum
}


fun getScore(name: String) = when(name){
    "Tom" -> 86
    "Jim" -> 77
    else -> 0
}

fun String.showToast(context: Context,duration: Int = Toast.LENGTH_SHORT){
    Toast.makeText(context,this,duration).show()
}

fun Int.showToast(context: Context,duration: Int = Toast.LENGTH_SHORT){
    Toast.makeText(context,this,duration).show()
}

fun View.showSnackbar(text :String,actionText:String?=null,
    duration: Int =  Snackbar.LENGTH_SHORT,block:(()->Unit)? = null){
    val snackbar = Snackbar.make(this,text, duration)
    if(actionText!=null&&block!=null){
        snackbar.setAction(actionText){
            block()
        }
    }
    snackbar.show()
}

fun View.showSnackbar(resId:Int,actionResId:Int ?=null,
                      duration: Int =  Snackbar.LENGTH_SHORT,block:(()->Unit)? = null){
    val snackbar = Snackbar.make(this,resId, duration)
    if(actionResId!=null&&block!=null){
        snackbar.setAction(actionResId){
            block()
        }
    }
    snackbar.show()
}