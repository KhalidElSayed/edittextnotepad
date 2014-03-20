package com.example.edittextnotepad;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.EditText;

public class NotePadEditText extends EditText {

	private static final int LINE_PADDING = 10;
	private Paint paint;
	private int linesColor;
	private int textSize;

	public NotePadEditText(Context context) {
		super(context);
		init();
	}

	public NotePadEditText(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}

	public NotePadEditText(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init();
	}

	private void init() {
		this.linesColor = Color.BLACK;
		this.paint = new Paint();
		
		setBackgroundColor(getContext().getResources().getColor(android.R.color.transparent));
		
		setGravity(Gravity.TOP);
		
		textSize += getLineHeight() * getContext().getResources().getDisplayMetrics().density;
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		
		int height = getMeasuredHeight();
		int linesSize =  getLineCount() * textSize;
		
		height =  height > linesSize ? height : linesSize;
		
		for (int y = textSize; y < height; y = y + textSize) {
			int start = LINE_PADDING;
			int end = canvas.getWidth() - LINE_PADDING;
			
			paint.setColor(linesColor);
			paint.setStyle(Style.FILL);
			
			canvas.drawLine(start, y, end, y, paint);
		}
	}

}
