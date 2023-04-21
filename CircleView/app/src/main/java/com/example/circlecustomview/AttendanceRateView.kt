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

    private val percentageTextColor: Int
    private val attendanceTextColor: Int
    private val circleBackgroundColor: Int
    private val circleProgressColor: Int


    init {
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.AttendanceRateView)
        percentageTextColor = typedArray.getColor(R.styleable.AttendanceRateView_percentageTextColor, Color.BLACK)
        attendanceTextColor = typedArray.getColor(R.styleable.AttendanceRateView_attendanceTextColor, Color.BLACK)
        circleBackgroundColor = typedArray.getColor(R.styleable.AttendanceRateView_circleBackgroundColor, resources.getColor(R.color.circle_view_background_color))
        circleProgressColor = typedArray.getColor(R.styleable.AttendanceRateView_circleProgressColor, resources.getColor(R.color.circle_view_progress_color))
        typedArray.recycle()

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
        paint.color = circleBackgroundColor
        paint.strokeWidth = strokeWidth.toFloat()
        paint.style = Paint.Style.STROKE
        rectF.set(padding.toFloat(), padding.toFloat(), (width - padding).toFloat(), (height - padding).toFloat())
        canvas.drawOval(rectF, paint)

        // Draw the dark blue progress arc
        paint.color = circleProgressColor
        paint.setShadowLayer(10f, 0f, 0f, Color.BLACK)
        canvas.drawArc(rectF, -90f, percentage * 3.6f, false, paint)
        paint.clearShadowLayer()

        // Draw the percentage text
        paint.textSize = width / 3f
        paint.color = percentageTextColor
        paint.typeface = Typeface.DEFAULT_BOLD
        paint.style = Paint.Style.FILL
        val percentageText = String.format("%.1f%%", percentage)
        val percentageTextWidth = paint.measureText(percentageText)
        canvas.drawText(percentageText, (width - percentageTextWidth) / 2, height / 2f, paint)

        // Draw the "出勤率" text
        paint.textSize = width / 7f
        paint.color = attendanceTextColor
        val textWidth = paint.measureText(text)
        canvas.drawText(text, (width - textWidth) / 2, height * 3 / 4f, paint)
    }
}
