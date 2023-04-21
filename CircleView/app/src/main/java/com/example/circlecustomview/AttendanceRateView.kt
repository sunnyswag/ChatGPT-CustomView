package com.example.circlecustomview

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.graphics.Typeface
import android.util.AttributeSet
import android.view.View

class AttendanceRateView(context: Context, attrs: AttributeSet? = null) :
    View(context, attrs) {

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val rectF = RectF()
    private var percentage: Float = 0f
    private val text = "出勤率"

    init {
        paint.isAntiAlias = true
    }

    fun setPercentage(percentage: Float) {
        this.percentage = percentage
        invalidate()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        val width = width
        val height = height
        val strokeWidth = 30
        val padding = 20

        // Draw the light blue background circle
        paint.color = Color.parseColor("#66BBF0")
        paint.strokeWidth = strokeWidth.toFloat()
        paint.style = Paint.Style.STROKE
        rectF.set(padding.toFloat(), padding.toFloat(), (width - padding).toFloat(), (height - padding).toFloat())
        canvas.drawOval(rectF, paint)

        // Draw the dark blue progress arc
        paint.color = Color.parseColor("#2F4F8B")
        paint.setShadowLayer(10f, 0f, 0f, Color.BLACK)
        canvas.drawArc(rectF, -90f, percentage * 3.6f, false, paint)
        paint.clearShadowLayer()

        // Draw the percentage text
        paint.textSize = width / 3f
        paint.color = Color.BLACK
        paint.typeface = Typeface.DEFAULT_BOLD
        paint.style = Paint.Style.FILL
        val percentageText = String.format("%.1f%%", percentage)
        val percentageTextWidth = paint.measureText(percentageText)
        canvas.drawText(percentageText, (width - percentageTextWidth) / 2, height / 2f, paint)

        // Draw the "出勤率" text
        paint.textSize = width / 7f
        val textWidth = paint.measureText(text)
        canvas.drawText(text, (width - textWidth) / 2, height * 3 / 4f, paint)
    }
}
