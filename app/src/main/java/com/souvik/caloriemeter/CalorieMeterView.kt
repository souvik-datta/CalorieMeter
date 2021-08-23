package com.souvik.caloriemeter

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.util.AttributeSet
import android.view.View

class CalorieMeterView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private var rectArr = arrayOf<Rect>(
        Rect(0, 0, 0, 0), Rect(0, 0, 0, 0),
        Rect(0, 0, 0, 0), Rect(0, 0, 0, 0),
        Rect(0, 0, 0, 0), Rect(0, 0, 0, 0),
        Rect(0, 0, 0, 0), Rect(0, 0, 0, 0),
        Rect(0, 0, 0, 0), Rect(0, 0, 0, 0)
    )

    var paint = arrayOf<Paint>(
        Paint().apply {
            color = Color.LTGRAY
        },
        Paint().apply {
            color = Color.LTGRAY
        },
        Paint().apply {
            color = Color.LTGRAY
        },
        Paint().apply {
            color = Color.LTGRAY
        },
        Paint().apply {
            color = Color.LTGRAY
        },
        Paint().apply {
            color = Color.LTGRAY
        },
        Paint().apply {
            color = Color.LTGRAY
        },
        Paint().apply {
            color = Color.LTGRAY
        },
        Paint().apply {
            color = Color.LTGRAY
        },
        Paint().apply {
            color = Color.LTGRAY
        }
    )

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        initiate()
        for(i in rectArr.indices){
            canvas?.drawRect(rectArr[i],paint[i])
        }
    }

    fun initiate(){
        rectArr[0].apply {
            left = 10
            right = left + (width.minus(10))
            top = 10
            bottom = top + (height.div(15))
        }
        for(i in 1..rectArr.size-1){
            rectArr[i].apply {
                left = 10
                right = left + (width.minus(10))
                top = 20 + rectArr[i-1].bottom
                bottom = top + (height.div(15))
            }
        }
    }

    fun changeBarColor(level:Int){
        paint[0].setColor(Color.RED)
        paint[1].setColor(Color.rgb(255,69,0))
        paint[2].setColor(Color.rgb(255,165,0))
        paint[3].setColor(Color.rgb(255,215,0))
        paint[4].setColor(Color.rgb(255,255,0))
        paint[5].setColor(Color.rgb(154,205,50))
        paint[6].setColor(Color.rgb(124,252,0))
        paint[7].setColor(Color.rgb(60,179,113))
        paint[8].setColor(Color.rgb(64,224,208))
        paint[9].setColor(Color.rgb(0,255,255))
        for(i in 0..(paint.size-level-1)){
            paint[i].setColor(Color.LTGRAY)
        }
        postInvalidate()
    }
}